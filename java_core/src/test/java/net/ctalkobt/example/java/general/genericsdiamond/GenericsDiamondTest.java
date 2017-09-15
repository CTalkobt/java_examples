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
import org.junit.Test;
import org.junit.Assert;

/**
 *
 */
public class GenericsDiamondTest {
    private final Logger LOG = Logger.getLogger(GenericsDiamondTest.class);

    @Test
    public void testGenericDiamond() {
        
        // New shorter format using the <> "diamond" operator to automaticaly 
        // use the inferred type.
        List<Integer> int2 = new ArrayList<>();
        LOG.debug(int2);
        
        Map<String, List<Integer>> mapExample = new HashMap<>();
        mapExample.put("abc", int2);
        
        Assert.assertEquals(int2, mapExample.get("abc"));
    }

}
