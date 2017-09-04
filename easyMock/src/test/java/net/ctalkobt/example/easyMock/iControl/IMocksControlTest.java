/*
 * Copyright (C) 2017 Craig Taylor <ctalkobt@ctalkobt.net>
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
 *
**/

package net.ctalkobt.example.easyMock.iControl;

import java.util.List;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Test;

public class IMocksControlTest {
    
    @Test
    public void iControlTest() {
        final Long magicNumber = 42L;
        
        IMocksControl control = EasyMock.createControl();

        
        List<Long> mockList = control.createMock(List.class);
        
        /* For size return -1 */
        EasyMock.expect(mockList.size()).andReturn(-1);
        
        /* For get(0), always return magicNumber */
        EasyMock.expect(mockList.get(0)).andReturn(magicNumber).anyTimes();
        
        control.replay();
        
        Assert.assertEquals(-1, mockList.size());
        Assert.assertEquals(magicNumber, mockList.get(0));
        Assert.assertEquals(magicNumber, mockList.get(0));
        Assert.assertEquals(magicNumber, mockList.get(0));
        
        control.verify();
    }
}
