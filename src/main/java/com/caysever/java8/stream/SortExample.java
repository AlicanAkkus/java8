package com.caysever.java8.stream;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;

/**
 * @author alican
 */
public class SortExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Person> persons = PersonUtil.mockPersons();

        // streaming and pipeling sorting and then system out consuming
        // sorted by birthday, result will be different when different time
        persons.stream().sorted((p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday())).forEach(System.out::println);

    }

}
