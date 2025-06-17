/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Unit testing suite for the residence manager class 
 */
package com.expeditors.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResidenceManagerTests {

    private ResidenceManager residenceManager;
    private Residence residence1;
    private Residence residence2;
    private Person person1;
    private Person person2;
    private Person person3;

    @BeforeEach
    void setUp() {
        residenceManager = new ResidenceManager();
        residence1 = new Residence("123 Main St", "seattle", "wa");
        residence2 = new Residence("234 2nd Ave", "Tacoma", "wa");

        person1 = new Person("Frank", "Jones", 23);
        person2 = new Person("George", "Brown", 18);
        person3 = new Person("Ian", "Smith", 18);
    }

    @Test
    void testAddResidence() {
        residenceManager.addResidence(residence1);
        Map<String, Residence> residences = residenceManager.getAllResidences();
        
        assertEquals(1, residences.size());
        assertTrue(residences.containsKey(residence1.toString()));
    }

    @Test
    void testAddPersonToResidence() {
        residenceManager.addPersonToResidence(residence1, person1);
        
        assertEquals(1, residence1.getResidentsCount());
        assertTrue(residence1.getResidents().contains(person1));
        assertEquals(residence1, person1.getResidence());
    }

    @Test
    void testAddMultiplePeopleToResidence() {
        residenceManager.addPersonToResidence(residence1, person1);
        residenceManager.addPersonToResidence(residence1, person2);
        
        assertEquals(2, residence1.getResidentsCount());
        assertTrue(residence1.getResidents().contains(person1));
        assertTrue(residence1.getResidents().contains(person2));
    }

    @Test
    void testAddPersonToNonExistentResidence() {
        residenceManager.addPersonToResidence(residence2, person3);

        assertEquals(1, residenceManager.getAllResidences().size());
        assertEquals(1, residence2.getResidentsCount());
        assertTrue(residence2.getResidents().contains(person3));
    }

    @Test
    void testGetResidencesSummary() {
        residenceManager.addPersonToResidence(residence1, person1);

        String summary = residenceManager.getResidencesSummary();

        assertTrue(summary.contains("Household: " + residence1));
        assertTrue(summary.contains("Occupants: 1"));
        assertTrue(summary.contains(person1.toString()));

    }

    @Test
    void testGetResidencesOccupantsOver18() {
        residenceManager.addPersonToResidence(residence1, person1);
        residenceManager.addPersonToResidence(residence1, person2);
        residenceManager.addPersonToResidence(residence1, person3);

        String summary = residenceManager.getResidencesSummary();

        assertTrue(summary.contains("Household: " + residence1));
        assertTrue(summary.contains("Occupants: 3"));
        assertTrue(summary.contains(person1.toString()));
        assertFalse(summary.contains(person2.toString()));
        assertFalse(summary.contains(person3.toString()));

    }
}