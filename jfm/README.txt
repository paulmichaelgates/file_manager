Changes:

   * SER335 LAB5 (1)  -  src/org/jfm/po/CopyAction.java:copyFiles
   * 
   * Added defenesive programming to prevent null pointer exception
   * and other exceptions such as Checking that each file to be copied
   * exists before attempting to copy it. Skipping files that don't exist
   * instead of throwing an exception.
   * 
   * Removed exception by using boolean return type which specifies if
   * the copy was successful or not.


   * SER335 LAB5 (2) - src/org/jfm/po/CopyAction.java:copyFile
   *  
   * Make the code more secure by doing proper input validation.
   * 1. Check if the file exists before copying it.
   * 2. Check if the file is a directory before copying it.
   * 3. check for null printStackTrace

