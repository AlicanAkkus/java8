package com.caysever.java8.func.interfaces;

import java.util.List;
import java.util.function.Function;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

public class FunctionFunc {

    public static void main(String[] args) {

	List<Person> persons = PersonUtil.mockPersons();

	System.out.println("Print all person with firsname upper case:");
	// pass p as parameter, all firstname will be upper case
	process(persons, (p) -> {
	    p.setFirstname(p.getFirstname().toUpperCase());
	    return p;
	});

	System.out.println("Print all person with lastname upper case:");
	process(persons, (p) -> {
	    p.setLastname(p.getLastname().toUpperCase());
	    return p;
	});

    }

    private static void process(List<Person> persons, Function<Person, Person> function) {
	for (Person p : persons) {
	    function.apply(p);
	    System.out.println(p);
	}
    }

}
