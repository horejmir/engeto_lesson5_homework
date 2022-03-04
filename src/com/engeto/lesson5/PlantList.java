package com.engeto.lesson5;

import java.io.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlantList extends ArrayList<Plant> {

    public void importFromFile(String filename, String delimiter){

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            int rowCounter = 0;
            int rowImported = 0;

            while (scanner.hasNextLine()) {
                rowCounter++;
                String inputLine = scanner.nextLine();

                try {
                    Plant plant = new Plant(inputLine, delimiter);
                    this.add(plant);
                    rowImported++;
                } catch (DateTimeException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("ERROR - READING DATA FROM FILE ('"+ filename +"') ON ROW " + rowCounter + " (row skipped): " + e.getMessage());
                } catch (PlantException e) {
                    System.err.println("ERROR - CREATING PLANT OBJECT FROM DATA IN FILE ('"+ filename +"') ON ROW " + rowCounter + " (row skipped): " + e.getMessage());
                }
            }

            System.out.println("DONE - FROM FILE: '" + filename + "' " + rowImported + "/" + rowCounter + " ROWS SUCCESSFULLY IMPORTED.");
        } catch (IOException e) {
            System.err.println("ERROR - READING FILE '" + filename + "'");
        }
    }

    public void exportToFile(String filename, String delimiter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for(Plant plant : this) {
                writer.write(plant.getName());
                writer.newLine();

            }


        } catch (IOException e) {
            System.err.println("ERROR - WRITING TO FILE '" + filename + "'");
        }

    }
}