package com.engeto.lesson5;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        PlantsList plantsList = new PlantsList();

        try {
            Plant plant1 = new Plant("Fíkus");

            plantsList.add(plant1);

            Plant plant2 = new Plant("Bazalka", "na vaření", LocalDate.of(2022,01,12),
                    LocalDate.of(2022, 01,12), 3);

            plantsList.add(plant2);

        } catch (PlantException e) {
            System.err.println(e.getMessage());;
        }

        System.out.println("Watering info:");
        plantsList.forEach(p -> System.out.println(p.getWateringInfo()));

    }
}
