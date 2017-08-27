package com.caysever.java8.concurrency;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author alican
 */
public class ScheduledFixedRateExecutorsExample {

    public static void main(String[] args) {

        try {
            List<Person> persons = PersonUtil.mockPersons();

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

            Runnable task = () -> {
                String threadName = Thread.currentThread().getName();// pool-1-thread-1
                persons.forEach((p) -> System.out.println(threadName + " | " + p));
            };

            ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

            long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
            System.out.printf("Remaining Delay: %sms", remainingDelay);//remaining time almost is 2.99 second
            System.out.println();

            executor.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
