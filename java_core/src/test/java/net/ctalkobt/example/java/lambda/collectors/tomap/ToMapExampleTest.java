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

package net.ctalkobt.example.java.lambda.collectors.tomap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

public class ToMapExampleTest {
    private static final Logger LOG = Logger.getLogger(ToMapExampleTest.class);

    @Test
    public void testMap() {
        List<String> firstName = Arrays.asList("Albert", "Isaac", "Willy", "Abraham");
        List<String> lastName = Arrays.asList("Einstein", "Newton", "Wonka", "Lincoln");

        Map<String,String> mappedNames = firstName.stream()
            .collect(Collectors.toMap(
                Function.identity(), 
                key -> lastName.get(firstName.indexOf(key)) ) 
            );
        
        for (int index=0; index < firstName.size(); index++) {
            Assert.assertEquals("Index " + index + " mismatch", 
                mappedNames.get(firstName.get(index)),
                lastName.get(index));
        }
        
        mappedNames.forEach( (x,y) -> LOG.debug(y + ", " + x));
    }
}
