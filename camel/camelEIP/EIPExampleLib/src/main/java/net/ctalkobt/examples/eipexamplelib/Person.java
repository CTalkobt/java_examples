/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.examples.eipexamplelib;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -8235930359087063108L;
    public enum PersonType {
        Atypical,
        WorthWeightInGold,
        SomewhatNormal,
        Normal,
        VisitorAnotherPlanet
    }
    
    public enum Gender {
        Male,
        Female,
        Unknown        
    }
    
    public static final Person MARY_JOE = new Person("Mary", "Joe", 25, Gender.Female, PersonType.Normal);
    public static final Person CASPER = new Person("Casper", "TheGhost", 450, Gender.Unknown, PersonType.Atypical);
    public static final Person GOOD_POLITICIAN = new Person("Goody", "Politician", 54, Gender.Male, PersonType.Atypical);
    public static final Person ORPHAN_ANNIE = new Person("Orphan", "Annie", 6, Gender.Female, PersonType.Normal);
    public static final Person JACK_SPRAT = new Person("Jack", "Sprat", 10, Gender.Male, PersonType.SomewhatNormal);
    
    public static List<Person> AllPeeps = Arrays.asList(MARY_JOE, CASPER, GOOD_POLITICIAN, ORPHAN_ANNIE, JACK_SPRAT);
    
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;
    private final PersonType type;

    public Person(String firstName, String lastName, int age, Gender gender, PersonType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public PersonType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", type=" + type + '}';
    }
    
    
    
    
    
}
