package com.caysever.java8.func.interfaces;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class CallableFunc {

    public static void main(String[] args) throws Exception {

        Callable<List<Person>> callableForPersonAgeGreaterThan22 = () -> PersonUtil.mockPersons().stream().filter(p -> p.getAge() > 22).collect(Collectors.toList());

        List<Person> personList = callableForPersonAgeGreaterThan22.call();

        personList.stream().forEach(System.out::println);

    }

}
