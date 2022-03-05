package com.engeto.lesson5;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Plant {

    private static final int DEFAULT_WATERING_FREQUENCY = 7;

    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int wateringFrequency;

    public Plant(String name) {
        this.name = name;
        this.notes = "";
        this.plantedDate = LocalDate.now();
        this.lastWateringDate = LocalDate.now();
        this.wateringFrequency = DEFAULT_WATERING_FREQUENCY;
    }

    public Plant(String name, LocalDate plantedDate, int wateringFrequency) throws PlantException {
        this(name, "", plantedDate, LocalDate.now(), wateringFrequency);
    }

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate lastWateringDate, int wateringFrequency) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        setLastWateringDate(lastWateringDate);
        setWateringFrequency(wateringFrequency);
    }

    public Plant(String inputLine, String delimiter) throws PlantException {

        String[] parts = inputLine.split(delimiter);

        if(parts.length != 5) throw new PlantException("Wrong number of items on the row.");

        LocalDate plantedDate, lastWateringDate;
        int wateringFrequency;

        try {
            plantedDate = LocalDate.parse(parts[4]);
            wateringFrequency = Integer.parseInt(parts[2]);
            lastWateringDate = LocalDate.parse(parts[3]);
        } catch (DateTimeParseException | NumberFormatException e) {
            throw new PlantException("Wrong format: " + e.getMessage());
        }

        this.name = parts[0];
        this.notes = parts[1];
        this.plantedDate = plantedDate;
        setLastWateringDate(lastWateringDate);
        setWateringFrequency(wateringFrequency);

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
            throw new PlantException("plant name: '" + this.name + "' - last watering date is not valid (must be equal or after plated date)!");

        this.lastWateringDate = lastWateringDate;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) throws PlantException {

        if(wateringFrequency <= 0)
            throw new PlantException("plant name: '" + this.name + "' - watering frequency is not valid (must be greater then 0)!");

        this.wateringFrequency = wateringFrequency;
    }
}
