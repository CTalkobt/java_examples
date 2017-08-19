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

/**
 *
 */
public class StringSwitchExample {
    private static final Logger log = Logger.getLogger(StringSwitchExample.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String color = "blue";

        log.debug("For : " + color);
        switch (color) {
            case "blue":
                log.debug("**BLUE**");
                break;
            case "red":
                log.debug("**RED**");
                break;
            case "green":
                log.debug("**GREEN**");
                break;
            default:
                log.debug("Unknown");
                break;
        }

    }
}
