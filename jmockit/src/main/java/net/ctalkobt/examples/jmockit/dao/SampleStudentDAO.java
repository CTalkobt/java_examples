package net.ctalkobt.examples.jmockit.dao;

import net.ctalkobt.examples.jmockit.model.SampleStudent;

public class SampleStudentDAO {
    public SampleStudent findStudent(String firstName, String lastName) {
        throw new RuntimeException("Database call would have been invoked here for : " + firstName + " / " + lastName);
    }
}
