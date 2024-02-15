package org.example.src.main.prod.comparators.sorting;

import org.example.src.main.prod.component.Weather;

import java.util.Comparator;

public class WeatherComparator implements Comparator<Weather> {
    @Override
    public int compare(Weather o1, Weather o2) {
        RegionComparator regionComparator = new RegionComparator();
        int regionComprasion = regionComparator.compare(o1.getRegion(), o2.getRegion());
        if (regionComprasion == 0) {
            int dateComprasion = o1.getDate().compareTo(o2.getDate());
            if (dateComprasion == 0) {
                int temperatureComprasion = Double.compare(o1.getTemperature(), o2.getTemperature());
                if (dateComprasion == 0) {
                    return o1.getPrecipitation().compareTo(o2.getPrecipitation());
                }
                return temperatureComprasion;
            }
            return dateComprasion;
        }
        return regionComprasion;
    }
}
