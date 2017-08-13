/*
 * Copyright (C) 2017 Craig Taylor <ctalkobt@ctalkobt.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
**/

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
