package com.caysever.java8.func.interfaces;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerFunc {

    public static void main(String[] args) {

        List<Person> persons = PersonUtil.mockPersons();

        // Predicate<Person> predicate = p -> true
        // p is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value p has.

        System.out.println("Print all persons to system out stream:");

        // pass p as parameter
        process(persons, p -> true, System.out::println);

        // Predicate<Person> predicate1 = p ->
        // p.getGender().equalsIgnoreCase("male")
        // p is passed as parameter to test method of Predicate interface
        // test method will return true if person has gender as male

        System.out.println("Print male persons to system err stream:");
        process(persons, p -> p.getGender().equalsIgnoreCase("male"), System.err::println);

        // Predicate<Person> predicate2 = p -> p.getFirstname().startsWith("a")
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if p.firstname start with 'a'

        System.out.println("Print persons beginning with 'a' to system out stream:");
        process(persons, p -> p.getFirstname().startsWith("a"), System.out::println);
    }

    private static void process(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consume) {
        for (Person p : persons) {
            if (predicate.test(p)) {
                consume.accept(p);
            }
        }
    }

}
