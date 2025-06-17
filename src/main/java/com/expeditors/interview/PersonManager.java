package com.expeditors.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PersonManager {
    private List<Person> people;

    public PersonManager(){
        people = new ArrayList<>();
    }

    public List<Person> getPeople(){
        return this.people;
    }

    public void addPerson(Person person){
        this.people.add(person);
    }

    public String formatPeopleList() {
        StringBuilder result = new StringBuilder();
        Collections.sort(this.people);
        for (Person person : this.people) {
            if(person.getAge() >= 18)
                result.append(person).append("\n");
        }
        return result.toString();
    }
}