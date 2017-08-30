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

package net.ctalkobt.example.java.lambda.mapping.flatmap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class FlatMapTest {
    private static final Logger LOG = Logger.getLogger(FlatMapTest.class);

    @Test
    public void flatMapTest() {
        List<String> scientists = Arrays.asList("Ben Franklin","Isaac Newton", "Marie Caruie", "Albert Einstein");
        List<String> politicians = Arrays.asList("Napolean Bonaparte", "Ben Franklin", "Donald Trump", "John F Kennedy");
        
        Stream<List<String>> scientistsPoliticians = Stream.of(scientists, politicians);
        Stream<String> uniqs = scientistsPoliticians
                .flatMap(Collection::stream)                // Turn list into a stream of Strings.
                .distinct();                                 // Remove duplicate Ben Franklin
        
        Set<String> uniqueSet = new HashSet<>();
        uniqueSet.addAll(scientists);
        uniqueSet.addAll(politicians);
        int numUnique = uniqueSet.size();
        
        Assert.assertEquals(numUnique, uniqs.toArray().length);
        LOG.debug("Number unique:" + uniqs.toArray().length);
    }

}
