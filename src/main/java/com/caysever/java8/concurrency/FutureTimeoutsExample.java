package com.caysever.java8.concurrency;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author alican
 */
public class FutureTimeoutsExample {

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


            try {
                List<Person> resultOfPersonsTask = future.get(1, TimeUnit.SECONDS);//we should getting timeout exception
                resultOfPersonsTask.forEach(System.out::println);
            } catch (TimeoutException te) {
                te.printStackTrace();
                //java.util.concurrent.TimeoutException
                // at java.util.concurrent.FutureTask.get(FutureTask.java:205)
                // at
                // com.caysever.java8.concurrency.FutureTimeoutsExample.main(FutureTimeoutsExample.java:43)

            } finally {
                executor.shutdownNow();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
