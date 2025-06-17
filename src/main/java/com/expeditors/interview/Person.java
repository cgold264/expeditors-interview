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
 
 
     /**
      * Default constructor initializing fields to default values.
      */
     public Person(){
         firstName = "";
         lastName = "";
         age = -1;
         residence = null;
     }
 
     /**
      * Constructs a Person object with the specified first name, last name, and age.
      * The residence is initially set to null.
      * 
      * @param firstName The person's first name.
      * @param lastName The person's last name.
      * @param age The person's age.
      */
     public Person(String firstName, String lastName, int age){
         this.firstName = firstName;
         this.lastName = lastName;
         this.age = age;
         this.residence = null;
     }
 
 
     /**
      * Gets the last name of the person.
      * 
      * @return The last name.
      */
     public String getFirstName(){
         return this.firstName;
     }
 
     /**
      * Gets the age of the person.
      * 
      * @return The age.
      */
     public String getLastName(){
         return this.lastName;
     }
 
     /**
      * Gets the age of the person.
      * 
      * @return The age.
      */
     public int getAge(){
         return this.age;
     }
 
     /**
      * Gets the residence of the person.
      * 
      * @return The residence, or null if not set.
      */
     public Residence getResidence(){
         return this.residence;
     }
 
     /**
      * Sets the residence of the person.
      * 
      * @param residence The residence to associate with this person.
      */
     public void setResidence(Residence residence){
         this.residence = residence;
     }
 
     /**
      * Returns a string representation of the person.
      * The format is: "FirstName, LastName, Residence, Age".
      * 
      * @return A formatted string representation of the person.
      */
     @Override
     public String toString(){
         return this.firstName + ", " + this.lastName + ", " + this.residence.toString() + ", " + String.valueOf(age);
     }
 
 
     /**
      * Compares this person with another person for sorting purposes.
      * Persons are sorted first by last name, then by first name.
      * 
      * @param other The other person to compare to.
      * @return A negative integer, zero, or a positive integer if this person
      *         is less than, equal to, or greater than the specified person.
      */
     @Override
     public int compareTo(Person other) {
         if(this.lastName.equals(other.getLastName())){
             return this.firstName.compareTo(other.getFirstName());
         }
         return this.lastName.compareTo(other.getLastName()); 
     }
 
 }