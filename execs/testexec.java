package execs;
 
 public class testexec
 {
     public testexec()
     {
         @SuppressWarnings("unused") Process child;
         try {
        	 System.out.println("executing the command now...");
        	 String command = "cmd.exe /C E:\\eclipse\\workspace\\tester\\src\\dodir.bat";
        	 System.out.println(System.getProperty("os.name"));
        	 //System.getSecurityManager().checkExec(command);
        	 //System.out.println("checked the command now...");
            child = Runtime.getRuntime().exec(command);            
            System.out.println("executing the command now...");
         }
         catch( Exception e )
         {
             e.printStackTrace();
             System.out.println( "Create process fails:  " + e.getMessage() );
             return;
         }
 /*
         //int status;
         //try{status = child.waitFor();}
         //catch(InterruptedException e){System.out.println("Interrupted");}
         
         InputStream x;
         try {
             x = child.getInputStream();
         }
         catch( Exception e )
         {
             e.printStackTrace();
             System.out.println( "InputStream fails:  " + e.getMessage()
 );
             return;
         }
 
            int buff;
            try{
             while((buff = x.read()) != -1)
             {
                   System.out.println( "readLine: '" + String.valueOf(
 (char)buff ) + "'" );
                   //System.out.flush();
             }
            } catch(IOException e) { e.printStackTrace();}
            
             
            System.out.println( "End of this test - sleep for 10 secs."
 );
            System.out.flush();
            //try{ Thread.sleep( 10000 ); }
            //catch ( Exception e )
            //{
            //    e.printStackTrace();
            //    System.out.println( "sleep interruption" + e.getMessage() );
            //}
 
            try{ x.close(); }
            catch ( Exception e )
            {
                e.printStackTrace();
                System.out.println( "datasteam close " + e.getMessage()
 );
            }
 
         System.out.println( "Exiting from testexec." );
         child.destroy();
 */    
     }
 // Main program for TestHelloWorld
     public static void main( String args[] )
     {
         new testexec();
 
         System.out.println( "testexec - grand exit" );
     }
 }
 
