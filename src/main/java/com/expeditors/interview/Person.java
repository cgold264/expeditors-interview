/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Represents a person based on the attributes from the given data.
 */

 package com.expeditors.interview;

 public class Person implements Comparable<Person>{
     private String firstName;
     private String lastName;
     private int age;
     private Residence residence;
 
     public Person(){
         firstName = "";
         lastName = "";
         age = -1;
         residence = null;
     }
 
     public Person(String firstName, String lastName, int age){
         this.firstName = firstName;
         this.lastName = lastName;
         this.age = age;
         this.residence = null;
     }
 
     public String getFirstName(){
         return this.firstName;
     }
 
     public String getLastName(){
         return this.lastName;
     }
 
     public int getAge(){
         return this.age;
     }
 
     public Residence getResidence(){
         return this.residence;
     }
 
     public void setResidence(Residence residence){
         this.residence = residence;
     }
 
 
     @Override
     public String toString(){
         return this.firstName + ", " + this.lastName + ", " + this.residence.toString() + ", " + String.valueOf(age);
     }
 
     @Override
     public int compareTo(Person other) {
         if(this.lastName.equals(other.getLastName())){
             return this.firstName.compareTo(other.getFirstName());
         }
         return this.lastName.compareTo(other.getLastName()); 
     }
 
 }