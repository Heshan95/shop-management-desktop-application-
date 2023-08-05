/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laksha;

import GUI.loginForm;

/**
 *
 * @author kulas
 */

public class Laksha {
    public static void main(String[] args) {
        loading l = new loading();
        l.setVisible(true);
        try {
            for(int i = 0; i <= 100; i++){
                Thread.sleep(40);
                l.lbl.setText(Integer.toString(i)+"%");
                loginForm lf = new loginForm();
                if(i == 100){
                    l.dispose();
                    lf.show();
                }
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
                
            }
        } catch (Exception e) {
        }
    }
}
