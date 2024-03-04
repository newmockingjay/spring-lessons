package ru.spring.zayceva.dao;

import org.springframework.stereotype.Component;
import ru.spring.zayceva.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Dan"));
        people.add(new Person(++PEOPLE_COUNT, "Den"));
        people.add(new Person(++PEOPLE_COUNT, "Dasha"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
