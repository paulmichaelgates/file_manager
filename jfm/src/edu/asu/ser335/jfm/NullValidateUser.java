package edu.asu.ser335.jfm;

public class NullValidateUser implements IValidateUserStrategy{
    /*
     *  insists on usernames and passwords that are not empty.
     */
    @Override
    public boolean validateUser(String userName, String password) 
    {
        /*
         * validate the user
         */
        if ( userName.length() == 0 || password.length() == 0 )
            {
            return false;
            }
        return true;
    }
}
