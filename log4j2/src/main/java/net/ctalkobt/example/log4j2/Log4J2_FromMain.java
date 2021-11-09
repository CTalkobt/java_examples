/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 */
package net.ctalkobt.example.log4j2;

// Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
 
public class Log4J2_FromMain {
 
    // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
 
    public static void main(final String[] args) {
 
        Logger logger = LogManager.getLogger("test");

        // Set up a simple configuration that logs on the console.
 
        logger.error("Entering application.");

        logger.trace("Exiting application.");
    }
}
