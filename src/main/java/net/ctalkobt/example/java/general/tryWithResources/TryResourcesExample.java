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
package net.ctalkobt.example.java.general.tryWithResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 */
public class TryResourcesExample {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/duck/tryResources.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.err.println(">> " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
