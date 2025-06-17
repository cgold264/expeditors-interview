/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: March, 2025
 *
 * Person class description ... 
 */

 package com.expeditors.interview;

 public class Person {
     private String firstName;
     private String lastName;
     private int age;
 
     public Person(){
         firstName = "";
         lastName = "";
         age = -1;
     }
 
     public Person(String firstName, String lastName, int age){
         this.firstName = firstName;
         this.lastName = lastName;
         this.age = age;
     }
 
     public int getAge(){
         return this.age;
     }
 
     @Override
     public String toString(){
         return firstName + ", " + lastName + ", " + String.valueOf(age);
     }
 
 }