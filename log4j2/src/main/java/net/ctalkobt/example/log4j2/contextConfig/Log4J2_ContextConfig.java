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
package net.ctalkobt.example.log4j2.contextConfig;

// Import log4j classes.
import java.nio.charset.Charset;
import java.util.function.BiConsumer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.layout.PatternLayout;
 
/**
 * Attempt to initialize log4j2 based upon the LoggerContext. This does not work with log4j.properties.
 */
public class Log4J2_ContextConfig {

    public static void main(final String[] args) {               
        Logger logger = (Logger) LogManager.getLogger(Log4J2_ContextConfig.class.getName());

        // MINOR: Programmatic logger setting doesn't work. 
        logger.setLevel(Level.TRACE);

        LoggerContext ctx = LoggerContext.getContext(true);
        Configuration cfg = ctx.getConfiguration();
       
        PatternLayout layout = PatternLayout.createLayout("%m%n", null, null, null, Charset.defaultCharset(),false,false,null,null);
                        
        Appender appender = FileAppender.newBuilder().withName("File").withFileName("target/test.log").withLayout(layout).build();
        appender.start();
        logger.addAppender(appender); 
        
        logger.error(" -- Log4J2_ContextConfig --");
        
        ctx.getLoggers().forEach(log -> {
            logger.error(" Log: " + log.getName());
        });
        
    cfg.getAppenders().forEach((BiConsumer<? super String, ? super Appender>) new BiConsumer<String, Appender>() {
            @Override
            public void accept(String name, Appender append) {
                logger.error("Appender: " + name + " = " + append.toString());
            }
        });
    
        logger.error("Config source: " + cfg.getConfigurationSource().getLocation());
        
        logger.error("Entering application.");
        logger.debug("debug");
        logger.info("info");
                
        logger.trace("Exiting application.");        
    }
}
