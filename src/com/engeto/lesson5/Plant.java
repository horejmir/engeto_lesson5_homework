package com.engeto.lesson5;

import java.time.LocalDate;

public class Plant {

    private static final int DEFAULT_WATERING_FREQUENCY = 7;

    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int wateringFrequency;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate lastWateringDate, int wateringFrequency) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        setLastWateringDate(lastWateringDate);
        setWateringFrequency(wateringFrequency);
    }

    public Plant(String name, LocalDate plantedDate, int wateringFrequency) throws PlantException {
        this(name, "", plantedDate, LocalDate.now(), wateringFrequency);
    }

    public Plant(String name) throws PlantException {
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

    public void setLastWateringDate(LocalDate lastWateringDate) throws PlantException {
        if(lastWateringDate.isBefore(this.plantedDate))
            throw new PlantException("Last watering date is not valid (must be after plated date)!");

        this.lastWateringDate = lastWateringDate;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) throws PlantException {

        if(wateringFrequency <= 0)
            throw new PlantException("Watering frequency is not valid (must be greater then 0)!");

        this.wateringFrequency = wateringFrequency;
    }
}
