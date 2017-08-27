package com.caysever.java8.concurrency;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author alican
 */
public class MultipleCallablesExample {

    public static void main(String[] args) {

        try {
            List<Person> persons = PersonUtil.mockPersons();

            //create callable list which return sorted persons
            List<Callable<List<Person>>> callables = Arrays.asList(() -> {
                System.out.println("Persons sorting by birthday..");
                return persons.stream().sorted((p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday())).collect(Collectors.toList());
            }, () -> {
                System.out.println("Persons sorting by firstname..");
                return persons.stream().sorted((p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname())).collect(Collectors.toList());
            }, () -> {
                System.out.println("Persons sorting by lastname..");
                return persons.stream().sorted((p1, p2) -> p1.getLastname().compareTo(p2.getLastname())).collect(Collectors.toList());
            });

            //create work stealing pool for more than one tasks
            ExecutorService executor = Executors.newWorkStealingPool();

            executor.invokeAll(callables).stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }).forEach(System.out::println);

            //executor.invokeAny(callables).forEach(System.out::println); // call the invokeAny function for returns the string result of the fastest callable

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
