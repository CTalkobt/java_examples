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

package net.ctalkobt.example.java.general.multicatch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class MatchCaseTest {
    private static final Logger log = Logger.getLogger(MatchCaseTest.class);

    @Test
    @SuppressWarnings("CallToPrintStackTrace")
    public void matchCaseExample() {
        String strNum1="100";
        String strNum2 = "5";
        
        try {
            // throws NumberFormatException
            Double d1 = Double.valueOf(strNum1); 
            Double d2 = Double.valueOf(strNum2);
            
            Double result = d1 / d2;
            log.debug( d1 + " / " + d2 + "=" + result);
            
            // Following can throw IOException
            // Force a null pointer exception
            String filename = "MultiCatchExample";   // null
            File f = File.createTempFile(filename, "example");
            Files.delete(f.toPath());                                 
            Assert.assertTrue(true);
        } catch (NullPointerException | IOException | NumberFormatException ex) {
            log.debug("Exception: " + ex); 
            Arrays.asList(ex.getStackTrace()).forEach(log::debug);
            Assert.assertFalse(true);
        }
    }

}
