package com.expeditors.interview;

import java.util.ArrayList;
import java.util.List;


public class Residence {

    private String address;
    private String city;
    private String state;
    private List<Person> residents;

    public Residence(){
        this.address = "";
        this.residents = new ArrayList<>();
    }

    public List<Person> getResidents(){
        return this.residents;
    }

    public void addResident(Person resident){
        this.residents.add(resident);
    }
    
}
