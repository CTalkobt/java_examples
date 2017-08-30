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

package net.ctalkobt.example.java.general.optional;

import java.util.Optional;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class OptionalExampleTest {
    private static final Logger log = Logger.getLogger(OptionalExampleTest.class);

    @Test
    public void optionalTest() {
        Optional<String> test = myFunction("one");

        Long value = test
                .map(Long::parseLong)
                .orElse(-1L);
        
        Assert.assertEquals((Long) 2L, value);
        Assert.assertEquals((Object) value.getClass(), (Object) Long.class);
    }

    private static Optional myFunction(String parm) {
        if (!parm.equals("one")) {
            return Optional.empty();
        }
        return Optional.of("2");
    }

}
