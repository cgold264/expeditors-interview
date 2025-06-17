/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Represents a residence based on the attributes of given data. 
 */

 package com.expeditors.interview;
 import java.util.ArrayList;
 import java.util.List;
 
 public class Residence {
     private String address;
     private String city;
     private String state;
     private List<Person> residents;
 
     /**
      * Default constructor, initializes all attributes to empty.
      */
     public Residence(){
         this.address = "";
         this.city = "";
         this.state = "";
         this.residents = new ArrayList<>();
     }
 
     /**
      * Constructs a Residence object with specified address, city, state.
      * Residents is set to an empty ArrayList.
      * 
      * @param address the main address for the residence.
      * @param city city where the residence is located.
      * @param state state where the residence is located. 
      */
     public Residence(String address, String city, String state){
         this.address = address;
         this.city = city;
         this.state = state;
         this.residents = new ArrayList<>();
     }
 
     /**
      * Gets the address for the residence.
      * 
      * @return string representation of the address.
      */
     public String getAddress(){
         return this.address;
     }
 
     /**
      * Gets the city for the residence.
      * 
      * @return string representation of City.
      */
     public String getCity(){
         return this.city;
     }
 
     /**
      * Gets the state for the residence.
      * 
      * @return string representation of state. 
      */
     public String getState(){
         return this.state;
     }
 
     /**
      * Gets all residents for the given residence.
      * 
      * @return an ArrayList of all Person objects that 
      * reside at address.
      */
     public List<Person> getResidents(){
         return this.residents;
     }
 
     /**
      * Gets the count of all residents at residence.
      * 
      * @return the number of residents at residence.
      */
     public int getResidentsCount(){
         return this.residents.size();
     }
 
     /**
      * Adds a new Resident to current residence.
      * 
      * @param resident A Person object that represents an 
      * occupant of the residence.
      */
     public void addResident(Person resident){
         this.residents.add(resident);
     }
     
 
     /**
      * Returns a string representation of the residence.
      * The format is: "Address, City, State".
      * 
      * @return A formatted string representation of the residence.
      */
     @Override
     public String toString(){
         return this.address + ", " + this.city + ", " + this.state;
     }  
 }