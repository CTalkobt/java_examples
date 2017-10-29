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

package net.ctalkobt.example.camel.eip.routingSlip;

import net.ctalkobt.examples.eipexamplelib.Person;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private Config myConfig;
    
    public void doTest() {
        ProducerTemplate prodTemplate = myConfig.getProducerTemplate();
        
        Person.AllPeeps.forEach(peep -> prodTemplate.sendBody("vm://routingSlipExample", peep));

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.err.println("Starting test.");
        doTest();
    }

}
