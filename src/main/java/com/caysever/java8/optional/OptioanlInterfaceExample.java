package com.caysever.java8.optional;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class OptioanlInterfaceExample {

    public static void main(String[] args) {

        List<Person> persons = PersonUtil.mockPersons();

        Optional<Person> person = Optional.of(persons.get(0));// persons have a
        // more than one
        // person. don't
        // allows passed
        // parameter to be
        // null

        // should print person
        person.ifPresent(System.out::println);// Person [firstname=alican,
        // lastname=akkuş, gender=male,
        // age=23, birthday=1489024012864]

        try {
            person = Optional.of(null);// throws NullPointerException if passed
            // parameter is null
        } catch (NullPointerException e) {
            System.err.println("An error occured while person creating..");
        }

        person = Optional.ofNullable(null);// could't throw any exception in
        // this point.
        // should't print person
        person.ifPresent(System.out::println);// no output

        // Optional.orElse - returns the value if present otherwise returns
        // the default value passed.
        Person p = person.orElse(new Person("hatun", "hatun", "female", 25, new Date().getTime() + new Random().nextInt()));

        person = Optional.of(p);
        // should print person
        person.ifPresent(System.out::println);
    }

}
