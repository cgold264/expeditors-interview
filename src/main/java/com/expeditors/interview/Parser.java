/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: March, 2025
 *
 * Parser class description ... 
 */

 package com.expeditors.interview;

 public class Parser {
 
     public static Residence parseResidence(String line){
         String[] data = line.split("\"");
         String address = data[5];
         String city = data[7];
         String state = data[9];
         return new Residence(address, city, state);
     }
 
     public static Person parsePerson(String line){
         String[] data = line.split("\"");
         
         String firstName = data[1];
         String lastName = data[3];
         String age = data[data.length - 1];
         
         return new Person(firstName, lastName, Integer.valueOf(age));
     }
     
 }