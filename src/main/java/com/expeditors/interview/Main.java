package com.expeditors.interview;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Queue;
import java.util.Collections;


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
        String formattedPersonInformation = personManager.formatPeopleList();

        Processor.writeToFile(outputPath, formattedResidenceInformation + formattedPersonInformation);
    }
}