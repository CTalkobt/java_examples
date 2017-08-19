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

package net.ctalkobt.example.java.general.genericsdiamond;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 */
public class GenericsDiamond {
    private static final Logger log = Logger.getLogger(GenericsDiamond.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // New shorter format using the <> "diamond" operator to automaticaly 
        // use the inferred type.
        List<Integer> int2 = new ArrayList<>();
        log.debug(int2);
        
        Map<String, List<Integer>> mapExample = new HashMap<>();
        mapExample.put("abc", int2);
    }

}
