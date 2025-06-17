/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Parser class description ... 
 */

 package com.expeditors.interview;

 import java.io.FileWriter;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.util.List;
 
 public class Processor {
 
     public static Residence parseResidence(String line){
         String[] data = line.split("\"");
         String address = data[5].toLowerCase().trim().replaceAll("[^a-z0-9 ]", "");
         String city = data[7].toLowerCase();
         String state = data[9].toLowerCase();
         return new Residence(address, city, state);
     }
 
     public static Person parsePerson(String line){
         String[] data = line.split("\"");
         
         String firstName = data[1];
         String lastName = data[3];
         String age = data[data.length - 1];
         
         return new Person(firstName, lastName, Integer.valueOf(age));
     }
 
     public static List<String> readFile(String filePath) {
         try {
             return Files.readAllLines(Paths.get(filePath));
         } catch (IOException e) {
             e.printStackTrace();
             return List.of(); 
         }
     }
 
     public static void writeToFile(String outputPath, String content) {
         try (FileWriter writer = new FileWriter(outputPath, false)) {
             writer.write(content);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     
 }