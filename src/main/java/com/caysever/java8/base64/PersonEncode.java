package com.caysever.java8.base64;

import com.caysever.java8.model.Person;
import com.caysever.java8.utils.PersonUtil;

import java.util.Base64;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class PersonEncode {

    public static void main(String[] args) {
        List<Person> persons = PersonUtil.mockPersons();

        System.err.println("Printing encoded person as list;");
        process(persons, (p) -> {
            p.setFirstname(Base64.getEncoder().encodeToString(p.getFirstname().getBytes()));
            return p;
        }, (p) -> System.out.println("Encoded firstname attr : " + p));

        System.err.println("Printing decoded person as list;");
        process(persons, (p) -> {
            p.setFirstname(new String(Base64.getDecoder().decode(p.getFirstname().getBytes())));
            return p;
        }, (p) -> System.out.println("Decoded firstname attr : " + p));

    }

    private static void process(List<Person> persons, Function<Person, Person> function, Consumer<Person> consumer) {
        for (Person p : persons) {
            p = function.apply(p);
            consumer.accept(p);
        }
    }
}
