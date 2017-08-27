package com.caysever.java8.stream;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author alican
 */
public class CollectExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Person> persons = PersonUtil.mockPersons();

        // streaming and pipeling sorting and then system out consuming
        // sorted by birthday, result will be different when different time
        // limit with 3
        // and collect (result of processing on the elements of a stream. )
        List<Person> sortedAndLimitedPersons = persons.stream().sorted((p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday())).limit(3)
                .collect(Collectors.toList());
        System.err.println("0. Print sorted and limited persons: ");
        sortedAndLimitedPersons.forEach(System.out::println);

        Map<String, List<Person>> groupByGenderList = persons.stream().collect(Collectors.groupingBy(Person::getGender));
        // Group by gender List : Female-> Persons and Male -> Persons
        System.err.println("1. Group persons by gender - get result in List: ");
        System.out.println(groupByGenderList.toString());

        Map<String, Optional<Person>> personByMaxAgeForEachGender = persons.stream().collect(
                Collectors.groupingBy(Person::getGender, Collectors.maxBy(Comparator.comparing(Person::getAge))));
        System.err.println("2. Group person objects by gender and get person with max age: ");
        System.out.println(personByMaxAgeForEachGender.toString());

    }

}
