package com.caysever.java8.datetime;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class InstantExample {

    public static void main(String[] args) {
        List<Person> persons = PersonUtil.mockPersons();

        Optional<Person> firstPerson = Optional.of(persons.get(0));

        Instant instantBirthDay = Instant.ofEpochMilli(firstPerson.get().getBirthday());
        System.out.println("First Person birthday : " + instantBirthDay);
    }

}
