/*
 * Copyright (C) 2018 Craig Taylor <ctalkobt@ctalkobt.net>
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
package net.ctalkobt.example.junit.problems.injectedStubs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Craig Taylor <ctalkobt@ctalkobt.net>
 */
public class PatientBSTest {

    private PatientBS instance;
    class StubPatientDAO implements DAO {
        @Override
        public Object find(long id) throws Exception {
            return "Patient:" + id;
        }
    }
    
    public PatientBSTest() {
    }
    
    @Before
    public void setUp() {
        StubPatientDAO stubDAO = new StubPatientDAO();
        instance = new PatientBS(stubDAO);
    }

    /**
     * Test of render method, of class PatientBS.
     * @throws java.lang.Exception
     */
    @Test
    public void testRender() throws Exception {
        Assert.assertEquals("Patient:1", instance.render(1));
        Assert.assertEquals("Patient:42", instance.render(42));
    }
    
}
