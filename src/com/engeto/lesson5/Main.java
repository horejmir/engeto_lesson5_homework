package com.engeto.lesson5;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Plant plant1 = null;
        Plant plant2 = null;

        try {
            plant1 = new Plant("Fíkus");
            plant2 = new Plant("Bazalka", "na vaření", LocalDate.of(2022,01,12),
                    LocalDate.of(2022, 01,12), 0);

        } catch (PlantException e) {
            System.err.println(e.getMessage());;
        }

        if(plant1 != null){
            System.out.println(plant1);
            System.out.println(plant1.getWateringInfo());
        }


        if(plant2 != null){
            System.out.println(plant2);
            System.out.println(plant2.getWateringInfo());
        }


    }
}
