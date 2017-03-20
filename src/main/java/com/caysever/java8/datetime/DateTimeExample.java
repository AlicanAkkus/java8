package com.caysever.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeExample {

    public static void main(String[] args) {

	// Get the current date and time
	LocalDateTime currentTime = LocalDateTime.now();
	System.out.println("Current DateTime: " + currentTime);

	LocalDate date1 = currentTime.toLocalDate();
	System.out.println("date1: " + date1);

	Month month = currentTime.getMonth();
	int day = currentTime.getDayOfMonth();
	int seconds = currentTime.getSecond();

	System.out.println("Month: " + month + " day: " + day + " seconds: " + seconds);

	LocalDateTime graduatedDate = currentTime.withMonth(6).withDayOfMonth(15).withYear(2016);
	System.out.println("graduatedDate: " + graduatedDate);

	// 6  march 2017
	LocalDate armBrokedDate = LocalDate.of(2017, Month.MARCH, 6);
	System.out.println("armBrokedDate: " + armBrokedDate);

	// 22 hour 15 minutes
	LocalTime sampleTime = LocalTime.of(22, 15);
	System.out.println("sampleTime: " + sampleTime);

	// parse a string
	LocalTime sampleTimePaarsing = LocalTime.parse("22:15:30");
	System.out.println("sampleTimePaarsing: " + sampleTimePaarsing);
	
    }

}
