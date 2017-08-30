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

package net.ctalkobt.example.java.lambda.collections.foreach;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

public class ForEachExampleTest {
    private static final Logger LOG = Logger.getLogger(ForEachExampleTest.class);

    @Test
    public void testForEach() {
        List<String> example = Arrays.asList("A", "B", "C", "D");
        final StringBuffer sb = new StringBuffer();
        example.forEach(sb::append);
        
        LOG.debug("forEachExample: " + sb.toString());
        Assert.assertEquals("ABCD", sb.toString());
    }

}
