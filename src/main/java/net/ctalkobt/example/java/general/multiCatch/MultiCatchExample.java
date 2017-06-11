/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.example.java.general.multiCatch;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class MultiCatchExample {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String strNum1="100";
        String strNum2 = "5";
        
        try {
            // throws NumberFormatException
            Double d1 = Double.valueOf(strNum1); 
            Double d2 = Double.valueOf(strNum2);
            
            Double result = d1 / d2;
            System.err.println( d1 + " / " + d2 + "=" + result);
            
            // Following can throw IOException
            // Force a null pointer exception
            String filename = "MultiCatchExample";
//            String filename = null;
            File f = File.createTempFile(filename, "example");
            f.delete();
                     
        } catch (NullPointerException | IOException | NumberFormatException ex) {
            System.err.println("Exception: " + ex); 
            ex.printStackTrace();
        }
    }

}
