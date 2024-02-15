package org.example.src.main.prod.builders;

import org.example.src.main.prod.component.Region;
import org.example.src.main.prod.component.Weather;

import java.time.LocalDate;

public class WeatherBuilder {
    private int id;
    private Region region;
    private LocalDate date;
    private double temperature;
    private String precipitation;

    public WeatherBuilder(Weather findWeather) {
        this.id = id;
        this.region = findWeather.getRegion();
        this.date = findWeather.getDate();
        this.temperature = findWeather.getTemperature();
        this.precipitation = findWeather.getPrecipitation();
    }

    public WeatherBuilder() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public WeatherBuilder setRegion(Region region) {
        this.region = region;
        return this;
    }

    public WeatherBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public WeatherBuilder setTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    public WeatherBuilder  setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
        return this;
    }
    public Weather getWeather() {
        return new Weather(id, region, date, temperature, precipitation);
    }
}
