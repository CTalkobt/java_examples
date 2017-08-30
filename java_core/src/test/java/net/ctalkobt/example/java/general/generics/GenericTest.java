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

package net.ctalkobt.example.java.general.generics;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class GenericTest {
    private static final Logger LOG = Logger.getLogger(GenericTest.class);

    @Test
    public void genericTest() {
        // Example: Diamond operator.
        // Note that use of generic type avoids changess to create multiple classes.
        Parent<String> pStr = new Parent<>("ABC");
        Parent<Long> pLong = new Parent<>(5L);
        
        pStr.set("ABC");
        
        LOG.debug("pInt=" + pLong );
        LOG.debug("pStr=" + pStr );
        Assert.assertEquals((Long) 5L, pLong.get());
        Assert.assertEquals("ABC", pStr.get());
    }

}
