package com.engeto.lesson5;

import java.time.LocalDate;

public class Main {

    private static final String DELIMITER = "\t";
    public static final String FILE_NAME = "kvetiny.txt";

    public static void main(String[] args) {

        PlantsList plants = new PlantsList();

        plants.importFromFile(FILE_NAME, DELIMITER);



        try {
            Plant plant1 = new Plant("Fíkus");

            plants.add(plant1);

            Plant plant2 = new Plant("Bazalka", "na vaření", LocalDate.of(2022,1,12),
                    LocalDate.of(2022,1,11), 2);

            plants.add(plant2);

        } catch (PlantException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("=== Watering info ===");
        plants.forEach(p -> System.out.println(p.getWateringInfo()));
        System.out.println("=====================");
    }
}
