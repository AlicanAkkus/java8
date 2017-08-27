package com.caysever.java8.concurrency;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author alican
 */
public class CallableExample {

    public static void main(String[] args) {

        try {
            List<Person> persons = PersonUtil.mockPersons();

            //Callables are functional interfaces just like runnables but instead of being void they return a value.
            Callable<List<Person>> personsSortingAndFilteringTask = () -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    return persons.stream().sorted((p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday())).filter((p) -> p.getFirstname() != null)
                            .collect(Collectors.toList());
                } catch (InterruptedException e) {
                    throw new IllegalStateException("task interrupted", e);
                }
            };

            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<List<Person>> future = executor.submit(personsSortingAndFilteringTask);

            //executor.shutdownNow(); dont call this method in this point. executor and callable-future is tightly coupled.

            System.out.println("future done? " + future.isDone());

            List<Person> resultOfPersonsTask = future.get();
            executor.shutdownNow();// we can shutdown now

            System.out.println("future done? " + future.isDone());

            resultOfPersonsTask.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
