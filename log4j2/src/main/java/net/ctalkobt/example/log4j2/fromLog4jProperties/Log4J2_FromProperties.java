/*
 * Copyright (C) 2021 Craig Taylor <ctalkobt@ctalkobt.net>
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
package net.ctalkobt.example.log4j2.fromLog4jProperties;

// Import log4j classes.
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


/**
 * Attempt to initialize logger from log4j.properties.
 */
public class Log4J2_FromProperties {

    public static void main(final String[] args) {
        
        // Attempt to use logger.
        Logger logger = (Logger) LogManager.getLogger(Log4J2_FromProperties.class.getName());

        /** @@PROBLEM: These all get logged to stderr, but not to the file defined in the log4j.properties */
        logger.error(" -- Log4J2_FromProperties --");

        logger.debug("Here is some DEBUG");
        logger.info("Here is some INFO");
        logger.warn("Here is some WARN");
        logger.error("Here is some ERROR");
        logger.fatal("Here is some FATAL");
    }
}
