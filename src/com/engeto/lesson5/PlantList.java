package com.engeto.lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class PlantList extends ArrayList<Plant> {

    private static final Logger LOGGER = Logger.getLogger(PlantList.class.getName());

    public void importFromFile(String filename, String delimiter) throws PlantException {

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            int rowCounter = 0;
            int rowImported = 0;
            List<String> exceptionMessages = new ArrayList<>();

            while (scanner.hasNextLine()) {
                rowCounter++;
                String inputLine = scanner.nextLine();

                try {
                    this.add(new Plant(inputLine, delimiter));
                    rowImported++;

                } catch (PlantException e) {
                    exceptionMessages.add("ERROR - READING DATA FROM FILE ('" + filename + "') ON ROW " + rowCounter + " (row skipped)\n\t" + e.getMessage());
                }
            }

            LOGGER.info("IMPORTED ROWS "+ rowImported + "/" + rowCounter + " FROM FILE: '" + filename + "'");

            if (exceptionMessages.size() > 0)
                throw new PlantException(String.join("\n", exceptionMessages));

        } catch (IOException e) {
                throw new PlantException("ERROR - READING FILE '" + filename + "'");
        }
    }

    public void exportToFile(String filename, String delimiter) throws PlantException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            int rowCounter = 0;

            for(Plant plant : this) {
                writer.write(plant.getName() + delimiter +
                                plant.getNotes() + delimiter +
                                plant.getWateringFrequency() + delimiter +
                                plant.getLastWateringDate() + delimiter +
                                plant.getPlantedDate());
                writer.newLine();
                rowCounter++;
            }

            LOGGER.info("WRITE " + rowCounter + " ITEMS TO FILE: '" + filename + "'");
        } catch (IOException e) {
            throw new PlantException("ERROR - WRITING TO FILE '" + filename + "'");
        }

    }
}
