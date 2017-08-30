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
 */

package net.ctalkobt.example.java.lambda.collections.removeif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class RemoveIfExampleTest {
    private static final Logger LOG = Logger.getLogger(RemoveIfExampleTest.class);

    @Test
    public void testRemoveIf() {
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Joe", "Bob", "Anton", "Mary", "Sue", "Sally", "Alex"));
        
        LOG.debug("Pre removal:" + names);
        names.removeIf(x -> x.contains("x") || "Bob".equals(x));        
        LOG.debug("After removal: " + names);
        
        Assert.assertArrayEquals(
                Arrays.asList("Joe", "Anton", "Mary", "Sue", "Sally").toArray(), 
                names.toArray());
    }

}
