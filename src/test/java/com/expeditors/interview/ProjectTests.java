/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Unit testing suite for the parser object 
 */

 package com.expeditors.interview;

 import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.junit.jupiter.api.Assertions.assertFalse;
 import static org.junit.jupiter.api.Assertions.assertTrue;
 import org.junit.jupiter.api.Test;
 
 
 public class ProjectTests 
 {
 
     @Test
     void testPersonToString()
     {
         Person testPerson = new Person("Dave", "Smith", 43);
         String expectedString = "Dave, Smith, 43";
         assertEquals( expectedString, testPerson.toString() );
     }
 
     @Test
     void testPersonParser()
     {
         String testString = "\"Dave\",\"Smith\",\"123 main st.\",\"seattle\",\"wa\",\"43\"";
         Person testPerson = Processor.parsePerson(testString);
         String expectedString = "Dave, Smith, 43";
         assertEquals( expectedString, testPerson.toString() );
     }
 
 }