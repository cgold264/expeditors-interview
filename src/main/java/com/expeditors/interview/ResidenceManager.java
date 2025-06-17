/**
 * Expeditors Take Home Assessment
 * 
 * NAME: Connor Goldschmidt
 * DATE: June, 2025
 *
 * Manages the state of all residence objects. 
 */
package com.expeditors.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ResidenceManager {
    private Map<String, Residence> allResidences;

    /**
     * Default constructor, initializes allResidences to an empty HashMap.
     */
    public ResidenceManager(){
        this.allResidences = new HashMap<>();
    }

    /**
     * Getter for allResidences attribute.
     * 
     * @return a map where each key is the string representation
     * of a residence object and each value is the residence object.
     */
    public Map<String, Residence> getAllResidences(){
        return allResidences;
    }

    /**
     * Add a single residence to the manager.
     * 
     * @param residence to be added. 
     */
    public void addResidence(Residence residence){
        this.allResidences.put(residence.toString(), residence);
    }

    /**
     * Adds a single person to the given residence.
     * 
     * @param person to be added to residence.
     * @param residence that person will be added to.
     */
    public void addPersonToResidence(Residence residence, Person person) {
        String key = residence.toString();
        allResidences.putIfAbsent(key, residence);
        allResidences.get(key).addResident(person);
        person.setResidence(residence);
    }
    
    /**
     * Builds a string representation of all current residence objects and 
     * counts the number of associated Occupants for each residence.
     * 
     * @return A string representation of each residence followed by number of 
     * occupants.
     */
    public String getResidencesSummary() {
        StringBuilder summary = new StringBuilder();
        for (Residence residence : allResidences.values()) {
            summary.append("Household: ").append(residence)
                   .append(" Occupants: ").append(residence.getResidentsCount())
                   .append("\n");
            List<Person> occupants = new ArrayList<>(residence.getResidents());
            Collections.sort(occupants);
            for(Person occupant : occupants){
                if(occupant.getAge() > 18)
                    summary.append(occupant).append("\n");
            }
        }
        return summary.toString();
    }
}