package com.caysever.java8.concurrency;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author alican
 */
public class ExecutorsExample {

    public static void main(String[] args) {

        try {
            List<Person> persons = PersonUtil.mockPersons();

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();// pool-1-thread-1
                persons.forEach((p) -> System.out.println(threadName + " | " + p));
            });

            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();// pool-1-thread-1
                persons.forEach((p) -> System.err.println(threadName + " | " + p));
            });

            // the java process never stops!

            // executor.shutdown();// Executors have to be stopped explicitly -
            // waits
            // for currently running tasks to finish

            // executor.shutdownNow();// interrupts all running tasks and shut
            // the executor down immediately.

            // or you can this;
            System.out.println("attempt to shutdown executor in 15 seconds");
            executor.awaitTermination(15, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
