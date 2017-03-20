package com.caysever.java8.method.reference;

import java.util.List;
import java.util.function.Consumer;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

public class MethodReference {

    public static void main(String[] args) {

	List<Person> persons = PersonUtil.mockPersons();
	
	process(persons, System.out::println);//print to system out , method reference
	process(persons, System.err::println);//print to system err , method reference 
    }
    
    private static void process(List<Person> persons, Consumer<Person> consumer){
	
	for(Person person : persons){
	    consumer.accept(person);
	}
	
    }

}
