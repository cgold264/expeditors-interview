/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: March, 2025
 *
 * Residence class description ... 
 */

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
 
     public Residence(String address, String city, String state){
         this.address = address;
         this.city = city;
         this.state = state;
         this.residents = new ArrayList<>();
     }
 
     public List<Person> getResidents(){
         return this.residents;
     }
 
     public int getResidentsCount(){
         return this.residents.size();
     }
 
     public void addResident(Person resident){
         this.residents.add(resident);
     }
     
     @Override
     public String toString(){
         return this.address + ", " + this.city + ", " + this.state;
     }
 }