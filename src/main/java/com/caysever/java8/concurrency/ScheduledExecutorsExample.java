package com.caysever.java8.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author alican
 *
 */
public class ScheduledExecutorsExample {

    public static void main(String[] args) {

	try {
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	    
	    //print time with every second
	    Runnable task = () -> {
		System.out.println("Current date time: " + LocalDateTime.now());
	    };
	    
	    executor.scheduleAtFixedRate(task,0, 1, TimeUnit.SECONDS);//0: initial delay, 1: period
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
