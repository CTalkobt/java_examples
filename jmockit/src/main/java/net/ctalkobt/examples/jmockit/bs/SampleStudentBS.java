package net.ctalkobt.examples.jmockit.bs;

import net.ctalkobt.examples.jmockit.dao.SampleStudentDAO;
import net.ctalkobt.examples.jmockit.model.SampleStudent;

public class SampleStudentBS {
    
    public SampleStudentDAO dao = null;
    
    public SampleStudentBS(SampleStudentDAO dao) {
        this.dao = dao;
    }
    
    public SampleStudent getStudent(String firstName, String lastName) {
        return dao.findStudent(firstName, lastName);
    }
}
