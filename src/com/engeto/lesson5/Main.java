package com.engeto.lesson5;

import java.time.LocalDate;
import java.util.Random;

public class Main {

    private static final String DELIMITER = "\t";
    public static final String INPUT_FILENAME =
            "kvetiny.txt";
//          "neexistujici_soubor.txt";
//          "kvetiny_spatna_frekvence.txt";
//          "kvetiny_spatne_datum.txt";
//          "kvetiny_nesplnuje_logiku_tridy_plant.txt";
//          "vystup.txt";


    private static final String OUTPUT_FILENAME = "vystup.txt";

    public static void main(String[] args) {

        var plants = new PlantList();

        // reading plants from file
        plants.importFromFile(INPUT_FILENAME, DELIMITER);

        //adding 2 new plants
        var plant1 = new Plant("Fíkus");
        plants.add(plant1);

        try {
            var plant2 = new Plant("Pažitka", "na vaření", LocalDate.of(2022, 1, 12),
                    LocalDate.of(2022, 1, 12), 2);
            plants.add(plant2);
        } catch (PlantException e) { System.err.println(e.getMessage()); }

        //delete random plant
        Random rnd = new Random();
        plants.remove(rnd.nextInt(plants.size()));

        System.out.println("=== Watering info ===");
        plants.forEach(p -> System.out.println(p.getWateringInfo()));
        System.out.println("=====================");

        // export to file
        plants.exportToFile(OUTPUT_FILENAME, DELIMITER);
    }
}
