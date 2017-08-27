package com.caysever.java8.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedTimeExample {

    public static void main(String[] args) {

        // Get the current date and time
        ZonedDateTime islambolTime = ZonedDateTime.parse("2017-06-20T10:15:30+03:30[Europe/Istanbul]");
        System.out.println("islambolTime: " + islambolTime);

        ZoneId id = ZoneId.of("Europe/Istanbul");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);

    }

}
