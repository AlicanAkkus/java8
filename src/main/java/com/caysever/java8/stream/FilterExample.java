package com.caysever.java8.stream;

import java.util.List;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

/**
 * @author alican
 *
 */
public class FilterExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
	List<Person> persons = PersonUtil.mockPersons();

	// streaming and pipeling and then system out consuming
	// pring all person begingging with 'a'
	persons.stream().filter(p -> p.getFirstname().startsWith("a")).forEach(System.out::println);
	
	// streaming and pipeling and then system err consuming
	// pring all person begingging with 'a'
	// hatunları err'de yazdiralim :)
	persons.stream().filter(p -> p.getGender().equalsIgnoreCase("female")).forEach(System.err::println);

    }

}
