package edu.asu.ser335.jfm;

public class ModerateValidateUser implements IValidateUserStrategy{

    /*
     * insists on passwords that are at least length 3, uses only letters or numbers, and
     * requires at least 1 letter and 1 numeric digit
     */
    @Override
    public boolean validateUser(String userName, String password) 
    {
        /*
         * validate the user
         */
        if ( password.length() < 3 )
            {
            return false;
            }

        boolean hasLetter = false;
        boolean hasNumber = false;
        for ( int i = 0; i < password.length(); i++ )
            {
            char c = password.charAt( i );
            if ( Character.isLetter( c ) )
                {
                hasLetter = true;
                }
            else if ( Character.isDigit( c ) )
                {
                hasNumber = true;
                }
            else
                {
                return false;
                }
            }

        return hasLetter && hasNumber;
    }
}
