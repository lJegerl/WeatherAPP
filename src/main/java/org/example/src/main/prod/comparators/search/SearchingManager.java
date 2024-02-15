package org.example.src.main.prod.comparators.search;


import org.example.src.main.prod.builders.WeatherBuilder;
import org.example.src.main.prod.component.Region;
import org.example.src.main.prod.component.Weather;

import java.time.LocalDate;
import java.util.ArrayList;

public class SearchingManager {
    public Weather searchWeatherWithRegion(Region region, ArrayList<Weather> weatherArrayList) {
        for (int i = 0; i < weatherArrayList.size(); i++) {
            if (weatherArrayList.get(i).getRegion().equals(region)) {
                return weatherArrayList.get(i);
            }
        }
        return null;
    }

    public LocalDate searchingSnowAndMinusTemperature(Region region, ArrayList<Weather> weatherArrayList) {
        ArrayList<Weather> arrayListWithThisRegion = new ArrayList<>();
        for (int i = 0; i < weatherArrayList.size(); i++) {
            arrayListWithThisRegion.add(weatherArrayList.get(i));
        }

        for (int i = 0; i < arrayListWithThisRegion.size(); i++) {
            if (arrayListWithThisRegion.get(i).getPrecipitation().equals("Snow")
                    & arrayListWithThisRegion.get(i).getTemperature() < 0) {
                return arrayListWithThisRegion.get(i).getDate();
            }
        }
        return null;
    }

    public void replaceRegion(Region oldRegion, Region newRegion, ArrayList<Weather> weatherArrayList) {
        Weather findWeather = searchWeatherWithRegion(oldRegion, weatherArrayList);
        weatherArrayList.remove(findWeather);
        Weather updatedWeather = new WeatherBuilder(findWeather)
                .setRegion(newRegion)
                .getWeather();
        weatherArrayList.add(updatedWeather);
    }
}
