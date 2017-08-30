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
package net.ctalkobt.example.java.general.stringswitch;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class StringSwitchExampleTest {
    private static final Logger LOGs = Logger.getLogger(StringSwitchExampleTest.class);

    @Test
    public void testSwitch() {
        String color = "blue";
        String result;

        switch (color) {
            case "blue":
                result = "**BLUE**";
                break;
            case "red":
                result = "**RED**";
                break;
            case "green":
                result = "**GREEN**";
                break;
            default:
                result = "Unknown";
                break;
        }
        Assert.assertEquals("**BLUE**", result);

    }
}
