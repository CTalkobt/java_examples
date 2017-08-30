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
package net.ctalkobt.example.java.lambda.consumers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class ConsumersExampleTest {
    private static final Logger LOG = Logger.getLogger(ConsumersExampleTest.class);

    @Test
    public void ConsumerTest() {
        List<Integer> strs = Arrays.asList(1, 2, 3, 4, 5);
        
        Consumer<Integer> displayX = LOG::debug;
        Consumer<Integer> displayXSquared = x -> LOG.debug(" " + x*x);
        
        
        LOG.debug("Consumers.andThen");        
        strs.stream()
                .forEach(displayX.andThen(displayXSquared));
        
        LOG.debug("Consumers.accept:");
        strs.stream().forEach(displayXSquared::accept);

        final StringBuffer sb = new StringBuffer();
        Consumer<Integer> xSquared = x -> sb.append(x*x);
        xSquared.accept(5);
        Assert.assertEquals("25", sb.toString());
    }

}
