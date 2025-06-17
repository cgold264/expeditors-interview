package com.expeditors.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ResidenceManager {
    private Map<String, Residence> allResidences;

    public ResidenceManager(){
        this.allResidences = new HashMap<>();
    }

    public Map<String, Residence> getAllResidences(){
        return allResidences;
    }

    public void addPersonToResidence(Residence residence, Person person) {
        String key = residence.toString();
        allResidences.putIfAbsent(key, residence);
        person.setResidence(residence);
    }
    
    public String getResidencesSummary() {
        StringBuilder summary = new StringBuilder();
        for (Residence residence : allResidences.values()) {
            summary.append("Household: ").append(residence)
                   .append(" Occupants: ").append(residence.getResidentsCount())
                   .append("\n");
        }
        return summary.toString();
    }
}