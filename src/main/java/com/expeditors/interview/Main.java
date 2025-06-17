package com.expeditors.interview;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Queue;


public class Main 
{
    public static void main( String[] args )
    {
        String filePath = "src/data/data.txt";

        Set<Residence> allResidences = new HashSet<>();
        List<Person> people = new ArrayList<>();
       // PriorityQueue<Person> pq = new PriorityQueue<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines){
                Residence residence = Parser.parseResidence(line);
                Person person = Parser.parsePerson(line);
                if(!allResidences.contains(residence)){
                    allResidences.add(residence);
                }
                if(person.getAge() >= 18){
                    residence.addResident(person);
                }
                allResidences.add(residence);
                people.add(person);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        String houseHolds = "";
        for(Residence r : allResidences){
            String line = "Household: " + r + " Occupants: " + r.getResidentsCount() + ":\n";
            houseHolds += line;
            System.out.println(line);
            Person last;
            Queue<Person> pq = r.getResidents();
            while ((last = pq.poll()) != null) {
                System.out.println(last);
            }
            System.out.println();
        }
        //System.out.println(houseHolds);
        

    }


}