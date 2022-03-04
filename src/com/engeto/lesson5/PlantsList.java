package com.engeto.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PlantsList extends ArrayList<Plant> {

    public void importFromFile(String filename, String delimiter){

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {

            while (scanner.hasNextLine()) {

                String inputLine = scanner.nextLine();
                String[] parts = inputLine.split(delimiter);

                String name = parts[0];
                String notes = parts[1];
                int wateringFrequency = Integer.parseInt(parts[2]);
                LocalDate lastWateringDate = LocalDate.parse(parts[3]);
                LocalDate plantedDate = LocalDate.parse(parts[4]);

                try {
                    Plant plant = new Plant(name, notes, plantedDate, lastWateringDate, wateringFrequency);
                    this.add(plant);
                } catch (PlantException e){
                    System.err.println("ERROR - CREATING PLANT OBJECT: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("ERROR - FILE '" + filename + "' NOT FOUND.");
        } catch (DateTimeException | IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            System.err.println("ERROR - READING DATA FROM FILE ('"+ filename +"'):" + e.getMessage());
        }
    }
}
