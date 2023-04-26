package edu.asu.ser335.jfm;

public class StrictValidateUser
    implements IValidateUserStrategy
{
    /*
     * insists on passwords that are at least length 6, uses only letters, numbers, or the special
     * characters !_=@%, and requires at least 1 uppercase letter, 1 lowercase letter, 1 special character, and 1 numeric digit
     */
    public boolean validateUser(String userName, String password) 
    {
        /*
         * local variables
         */
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        boolean hasNumber = false;

        /*
        * check password
        */
        if ( password.length() < 6 )
            {
            return false;   
            }

        /*
         * do the other checks
         */
        for ( int i = 0; i < password.length(); i++ )
            {
            char c = password.charAt( i );
            if ( Character.isUpperCase( c ) )
                {
                hasUpper = true;
                }
            else if ( Character.isLowerCase( c ) )
                {
                hasLower = true;
                }
            else if ( Character.isDigit( c ) )
                {
                hasNumber = true;
                }
            else if ( c == '!' || c == '_' || c == '=' || c == '@' || c == '%' )
                {
                hasSpecial = true;
                }
        }

        return hasUpper && hasLower && hasSpecial && hasNumber;
    }
}
    
