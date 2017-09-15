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
package net.ctalkobt.example.java.general.trywithresources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class TryResourcesExample {
    private static final Logger LOG = Logger.getLogger(TryResourcesExample.class);
    private File outputFile;
    
    @Before
    public void createTempFile() throws IOException { 
        outputFile = File.createTempFile("TryResourceExample", ".txt");
        try (FileWriter outputWriter = new FileWriter(outputFile.getPath())) {
            for (int i=0; i<10; i++) {
                outputWriter.write("Line: " + i + "\n");
            }
        } 
    }
    
    @After
    public void deleteTempFile() {
        outputFile.delete();
    }
    
    @Test
    @SuppressWarnings("CallToPrintStackTrace")
    public void tryWResourcesTest() {
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile.getPath()))) {
            String line;

            while ((line = br.readLine()) != null) {
                LOG.debug(">> " + line);
            }
            Assert.assertTrue(true);
            
        } catch (IOException e) {
            Arrays.asList(e.getStackTrace()).stream().forEach(LOG::debug);
            Assert.fail(e.getMessage());
        }
    }

}
