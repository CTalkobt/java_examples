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
 */

package net.ctalkobt.example.java.lambda.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static net.ctalkobt.example.java.lambda.Predicate.Person.GENDER_FEMALE;
import static net.ctalkobt.example.java.lambda.Predicate.Person.GENDER_MALE;

public class PredicateExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> peeps = new ArrayList<>();
        
        // Note: Ages are abitrary
        peeps.add(new Person("Steve", "Wozniak", 50, GENDER_MALE));
        peeps.add(new Person("Grace", "Hopper", 25, GENDER_FEMALE));
        peeps.add(new Person("Alan", "Turing", 60, GENDER_MALE));
        peeps.add(new Person("Ada", "Lovelace", 45, GENDER_FEMALE));
        peeps.add(new Person("John", "Atanasoft", 52, GENDER_MALE));
        
        Predicate<Person> predIsMale = peep -> peep.getGender().equals(GENDER_MALE);
        Predicate<Person> olderThan30 = peep -> peep.getAge() > 30;
        
        System.err.println("Male : " + peeps.stream().filter(predIsMale).collect(Collectors.toList()));
        System.err.println("Female : " + peeps.stream()
                .filter(p -> p.getGender().equals(GENDER_FEMALE))
                .collect(Collectors.toList()));
        System.err.println("Female - form 2 :" + peeps.stream()
            .filter(predIsMale.negate())
            .collect(Collectors.toList()));
        
        System.err.println("Males older than 30 : " + peeps.stream()
            .filter(predIsMale.and(olderThan30))
            .collect(Collectors.toList()));
        System.err.println("Males less than or equal to 30 : " + peeps.stream()
            .filter(predIsMale.and(olderThan30.negate()))
            .collect(Collectors.toList()));
        
        System.err.println("Feales older than 30 : " + peeps.stream()
            .filter(predIsMale.negate().and(olderThan30))
            .collect(Collectors.toList()));
        System.err.println("Females less than or equal to 30 : " + peeps.stream()
            .filter(predIsMale.negate().and(olderThan30.negate()))
            .collect(Collectors.toList()));

    }
}
