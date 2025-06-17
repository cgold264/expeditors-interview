package com.expeditors.interview;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;


public class Main 
{
    public static void main( String[] args )
    {
        String filePath = "src/data/data.txt";

        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines){
                Parser.parsePerson(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
}