/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Person class description ... 
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
         residence = new Residence();
     }
 
     public Person(String firstName, String lastName, int age){
         this.firstName = firstName;
         this.lastName = lastName;
         this.age = age;
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
 
     public void setResidence(Residence residence){
         this.residence = residence;
     }
 
     @Override
     public String toString(){
         return this.firstName + ", " + this.lastName + ", " + String.valueOf(age);
     }
 
     @Override
     public int compareTo(Person other) {
         if(this.lastName.equals(other.getLastName())){
             return this.firstName.compareTo(other.getFirstName());
         }
         return this.lastName.compareTo(other.getLastName()); 
     }
 
 }