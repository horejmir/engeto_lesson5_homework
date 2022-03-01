package com.engeto.lesson5;

import java.time.LocalDate;

public class Plant {

    private static final int DEFAULT_WATERING_FREQUENCY = 7;

    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int wateringFrequency;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate lastWateringDate, int wateringFrequency) {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
        this.wateringFrequency = wateringFrequency;
    }

    public Plant(String name, LocalDate plantedDate, int wateringFrequency) {
        this(name, "", plantedDate, LocalDate.now(), wateringFrequency);
    }

    public Plant(String name) {
        this(name, LocalDate.now(), DEFAULT_WATERING_FREQUENCY);
    }

    public String getWateringInfo() {
        return "name: '" + this.name+ "', last watering: "
                + this.lastWateringDate + ", next watering: "
                + lastWateringDate.plusDays(wateringFrequency);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name +
                "', notes='" + notes +
                "', plantedDate=" + plantedDate +
                ", lastWateringDate=" + lastWateringDate +
                ", wateringFrequency=" + wateringFrequency +
                "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(LocalDate plantedDate) {
        this.plantedDate = plantedDate;
    }

    public LocalDate getLastWateringDate() {
        return lastWateringDate;
    }

    public void setLastWateringDate(LocalDate lastWateringDate) {
        this.lastWateringDate = lastWateringDate;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }
}
