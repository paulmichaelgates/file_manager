package org.jfm.main;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.FileOutputStream;

/*
 * Logger class used for logging failed attempts to login
 * contains logic for writing to a file. 
 */
public class Logger implements ISecureObserver {
   private final String file_name = "jfmlog.txt"; 

    public void update( String user_name, String password, String role )
    {
    write_to_file( user_name, password, role );
    }

    private void write_to_file(  String user_name, String password, String role  )
    {
    /*
     * write the user information to the module file
     */
    String record =  "["  + ( new Date() ).toString() +  "] user:" + user_name + ",  password:" + password + " , role:" + role + "\n";
    try
        {
        OutputStream out = new FileOutputStream( file_name, true );
    
        out.write( record.getBytes() );

        out.close();
        }
    catch (Exception e)
        {
        System.out.println( "Error: " + e.getMessage() );
        }

    }                     

}
