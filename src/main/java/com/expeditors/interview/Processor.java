/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Static class that manages the data interactions for project. 
 */

 package com.expeditors.interview;

 import java.io.FileWriter;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.util.List;
 
 public class Processor {
 
     /**
      * Parses a single line of data and creates Residence object 
      * for given line. Assume each line of data is in correct format
      * and contains information for a single residence. 
      * 
      * @param line a single line of given data.
      * @return Residence object that 
      */
     public static Residence parseResidence(String line){
         String[] data = line.split("\"");
         String address = data[5].toLowerCase().trim().replaceAll("[^a-z0-9 ]", "");
         String city = data[7].toLowerCase();
         String state = data[9].toLowerCase();
         return new Residence(address, city, state);
     }
 
     /**
      * Parses a single line of data and creates Person object 
      * for given line. Assume each line of data is in correct format
      * and contains information for a single person. 
      * 
      * @param line a single line of given data.
      * @return Person object 
      */
     public static Person parsePerson(String line){
         String[] data = line.split("\"");
         String firstName = data[1];
         String lastName = data[3];
         String age = data[data.length - 1];
         
         return new Person(firstName, lastName, Integer.valueOf(age));
     }
 
     /**
      * Reads a given file and extracts all lines.
      * 
      * @param filePath represents the path to the file to be read.
      * @return List<String> a list that represents all lines for read file.
      */
     public static List<String> readFile(String filePath) {
         try {
             return Files.readAllLines(Paths.get(filePath));
         } catch (IOException e) {
             e.printStackTrace();
             return List.of(); 
         }
     }
 
     /**
      * Writes a given file and extracts all lines. Will overwrite contents of 
      * given file. 
      * 
      * @param filePath represents the path to the file to be written to.
      * @param content the string representation .
      */
     public static void writeToFile(String outputPath, String content) {
         try (FileWriter writer = new FileWriter(outputPath, false)) {
             writer.write(content);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     
 }