package net.ctalkobt.examples.jmockit.bs;

import mockit.Expectations;
import mockit.Mocked;
import net.ctalkobt.examples.jmockit.dao.SampleStudentDAO;
import net.ctalkobt.examples.jmockit.model.SampleStudent;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SampleStudentBSTest {
    @Mocked
    private SampleStudentDAO mockDAO;

    private SampleStudentBS instance; 
    
    public SampleStudentBSTest() {
    }
    
    @Before
    public void setUp() {
        instance = new SampleStudentBS(mockDAO); 
    }

    /**
     * Test of getStudent method, of class SampleStudentBS.
     */
    @Test
    public void testGetStudent() {
        SampleStudent studentJohnSmith = new SampleStudent();
        
        new Expectations() {{
            mockDAO.findStudent("John", "Smith"); result = studentJohnSmith; times = 1; 
        }};
                
        SampleStudent result = instance.getStudent("John", "Smith");
        
        Assert.assertSame("Unable to retrieve John Smith", studentJohnSmith, result);
    }
    
}
