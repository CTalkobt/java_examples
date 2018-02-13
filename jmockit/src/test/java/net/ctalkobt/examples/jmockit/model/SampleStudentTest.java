package net.ctalkobt.examples.jmockit.model;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SampleStudentTest {
    private final List<Double> initialGrades = Arrays.asList(1.0D, 2.0D, 3.0D, 4.0D, 5.0D);
    private final SampleStudent instance = new SampleStudent();
    
    public SampleStudentTest() {
    }
    
    @Before
    public void setUp() {
        instance.getGrades().addAll(initialGrades);
    }

    /**
     * Test of getGPA method, of class SampleStudent.
     */
    @Test
    public void testGetGPA() {
        Assert.assertEquals("Grade average not correct", 3.0d, instance.getGPA(), 0.1d);
    }

    /**
     * Test of getGrades method, of class SampleStudent.
     */
    @Test
    public void testGetGrades() {
        Assert.assertEquals("Grades do not match", initialGrades, instance.getGrades());
    }
    
}
