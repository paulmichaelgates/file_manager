package edu.asu.ser335.jfm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * This class is a factory that returns the appropriate strategy for validating a user
 * based on the properties file
 */
public class ValidateUserFactory {
    private final String file_name = "jfm.properties";

    public IValidateUserStrategy get_validation_strategy()
    {
    /*
     * Read in the property file and return the appropriate strategy
     */
    String type_str = read_properties_file();

    if( type_str.equals("NullValidateUser") )
        {
        return new NullValidateUser();
        }
    else if( type_str.equals("StrictValidateUser" ) )
        {
        return new StrictValidateUser();
        }
    else if ( type_str.equals("ModerateValidateUser" ) )
        {
        return new ModerateValidateUser();
        }
    else
        {
        System.out.println( "Error: invalid type string in properties file!" );
        }

    /*
     * If we get here, something went wrong
     */
    return null;
    }

    /*
     * Read in the property file and return the appropriate strategy
     */
    private String read_properties_file()
    {
    /*
     * Local variables
     */
    String type_str = null;
    InputStreamReader reader = null;
    
    /*
     * do the file IO
     */
    try
        {
        reader = new FileReader(file_name);
        }
    catch( FileNotFoundException e )
        {
        System.out.println( "Error: " + e.getMessage() );
        }
        
    /*
     * parse the string for the value between the < and the >
     */
    try
        {
        int c = reader.read();
        while( c != -1 )
            {
            if( c == '<' )
                {
                c = reader.read();
                while( c != '>' )
                    {
                    type_str += (char)c;
                    c = reader.read();
                    }
                }
            c = reader.read();
            }
        }
    catch( Exception e )
        {
        System.out.println( "Error: " + e.getMessage() );
        }

    /*
     * Validate the parsed string
     */
    if( type_str == null )
        {
        System.out.println( "Error: Properties file badly formatted!" );
        type_str = "StrictValidateUser"; /* Fail safe baby  */
        }
        
    
    return type_str;
    }
}
