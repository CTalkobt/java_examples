/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.example.java.general.dateTime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 *
 */
public class DateTimeExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        
        System.err.println("Now = " + now);
        System.err.println("Hour: " + now.getHour());
        
        LocalDateTime lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        System.err.println("Last day of month: " + lastDayOfMonth);
        
        System.err.println("Truncated to hour: " + now.truncatedTo(ChronoUnit.HOURS));
    }

}
