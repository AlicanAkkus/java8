package com.caysever.java8.stream;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author alican
 */
public class StatisticsExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Person> persons = PersonUtil.mockPersons();

        Map<String, IntSummaryStatistics> groupPersonsByAge = persons.stream().collect(
                Collectors.groupingBy(Person::getGender, Collectors.summarizingInt(Person::getAge)));
        System.err.println("0. Group person objects by gender and get age statistics: ");
        System.out.println(groupPersonsByAge.toString());
        IntSummaryStatistics malesAge = groupPersonsByAge.get("male");
        System.out.println("Avgerage male age:" + malesAge.getAverage());
        System.out.println("Max male age:" + malesAge.getMax());
        System.out.println("Min male age:" + malesAge.getMin());
    }

}
