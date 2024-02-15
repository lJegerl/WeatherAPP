package org.example.src.main.prod.component;

import java.time.LocalDate;

public class Weather {
    private int id;
    private Region region;
    private LocalDate date;
    private double temperature;
    private String precipitation;

    public Weather(int id, Region region, LocalDate date, double temperature, String precipitation) {
        this.id = id;
        this.region = region;
        this.date = date;
        this.temperature = temperature;
        this.precipitation = precipitation;
    }

    public int getId() {
        return id;
    }

    public Region getRegion() {
        return region;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    @Override
    public String toString() {
        return "Weather{" +
                region + " " +
                date + " " +
                temperature + " " +
                precipitation +
                '}';
    }
}
