/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Program entry point.
 */

 package com.expeditors.interview;

 import java.util.List;
 
 public class Main 
 {
     public static void main( String[] args )
     {
         String filePath = "src/data/data.txt";
         String outputPath = "src/data/output.txt";
         List<String> lines = Processor.readFile(filePath);
         ResidenceManager residenceManager = new ResidenceManager();
         PersonManager personManager = new PersonManager();
         for(String line : lines){
             Residence residence = Processor.parseResidence(line);
             Person person = Processor.parsePerson(line);
             residenceManager.addPersonToResidence(residence, person);
             personManager.addPerson(person);
         }
         String formattedResidenceInformation = residenceManager.getResidencesSummary();
         Processor.writeToFile(outputPath, formattedResidenceInformation);
     }
 }