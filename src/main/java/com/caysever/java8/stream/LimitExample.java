package com.caysever.java8.stream;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;

/**
 * @author alican
 */
public class LimitExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Person> persons = PersonUtil.mockPersons();

        // streaming and pipeling and then system out consuming
        // pring top 2 male person
        persons.stream().filter(p -> p.getGender().equalsIgnoreCase("male")).limit(2).forEach(System.out::println);

    }

}
