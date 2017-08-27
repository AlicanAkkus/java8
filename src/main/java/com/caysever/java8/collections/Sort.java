package com.caysever.java8.collections;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();

        List<Person> persons = PersonUtil.mockPersons();

        sort.sortUsingJava7(persons);
        System.out.println(Arrays.toString(persons.toArray()));

        sort.sortUsingJava8(persons);
        System.out.println(Arrays.toString(persons.toArray()));

    }

    // sort using java 7
    private void sortUsingJava7(List<Person> persons) {
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getFirstname().compareTo(p2.getFirstname());
            }
        });
    }

    // sort using java 8
    private void sortUsingJava8(List<Person> persons) {
        Collections.sort(persons, (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname()));
    }

}
