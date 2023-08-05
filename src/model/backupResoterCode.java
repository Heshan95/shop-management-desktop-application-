/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kulas
 */


public class backupResoterCode {
    public String backupDB(String path){
        String msg = null;
        
        try {
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe -uroot -pTc@19720228 --add-drop-database --port=3307 -B sad_shop-center -r "+path );
            
            int processComplete = p.waitFor();
            System.out.println("Process Done "+processComplete);
            msg = "You Backup saved Successfuly !";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error "+e.getMessage();
        }
        
        return msg;
    }
    
     public String restoreDB(String path){
        String msg = null;
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] restoreCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe",
                    "--user=root" ,
                    "--password=Tc@19720228",
                    "-e",
                    " source " + path};
            Process p = runtime.exec(restoreCmd);
            
            int processComplete = p.waitFor();
            System.out.println("Restore Process Done "+processComplete);
            msg = "You Restore Process Done !";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error "+e.getMessage();
        }
        
        return msg;
    }
}
