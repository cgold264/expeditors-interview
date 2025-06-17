package com.expeditors.interview;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class Main 
{
    public static void main( String[] args )
    {
        String filePath = "src/data/data.txt";

        List<Residence> allResidences = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines){
                Residence residence = Parser.parseResidence(line);
                Person person = Parser.parsePerson(line);
                allResidences.add(residence);
                people.add(person);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        String houseHolds = "";
        for(Residence r : allResidences){
            houseHolds += "Household: " + r + " Occupants: " + r.getResidentsCount() + "\n";
        }
        System.out.println(houseHolds);


    }


}