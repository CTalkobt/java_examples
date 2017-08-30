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

package net.ctalkobt.example.java.general.datetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class DateTimeExampleTest {
    private static final Logger LOG = Logger.getLogger(DateTimeExampleTest.class);

    @Test
    public void testDateTime_now() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        Thread.sleep(1000L);
        LocalDateTime nowPlus1 = LocalDateTime.now();

        long offset = now.until(nowPlus1, ChronoUnit.SECONDS);
        LOG.debug(nowPlus1 + " - " + now + " = " + offset + " second");
        Assert.assertEquals(1L, offset);
    }
    
}
