package net.ctalkobt.examples.jmockit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 */
public class SampleStudent {
    private final List<Double> grades = new ArrayList<>();
    
    public SampleStudent() {
        
    }
 
    public double getGPA() {
        Double avg = getGrades().stream().
                collect(Collectors.averagingDouble(x -> x));
                
        return avg;
    }
    
    public List<Double> getGrades() {
        return grades;
    }

}
