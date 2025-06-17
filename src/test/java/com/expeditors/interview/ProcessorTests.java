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
 
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 
 
 public class ProcessorTests{
 
    private String line1;
    private String line2;
    private String line3;
 
     @BeforeEach
     void setUp() {
         line1 = "\"Dave\",\"Smith\",\"123 main st.\",\"seattle\",\"wa\",\"43\"";
         line2 = "\"Alice\",\"Smith\",\"123 Main St.\",\"Seattle\",\"WA\",\"45\"";
         line3 = "\"Bob\",\"Williams\",\"234 2nd Ave.\",\"234 2nd Ave\",\"WA\",\"26\"";
     }
 
     @Test
     void testParsePerson()
     {
         Person person1 = Processor.parsePerson(line1);
         Person test1 = new Person("Dave", "Smith", 43);
         assertEquals(person1.getFirstName(), test1.getFirstName());
         assertEquals(person1.getLastName(), test1.getLastName());
         assertEquals(person1.getAge(), test1.getAge());
     }
 
     @Test
     void testParseResidence()
     {
         Residence residence1 = Processor.parseResidence(line1);
         Residence test1 = new Residence("123 main st", "seattle", "wa");
         assertEquals(residence1.getAddress(), test1.getAddress());
         assertEquals(residence1.getCity(), test1.getCity());
         assertEquals(residence1.getState(), test1.getState());
     }
 
 
 
 }