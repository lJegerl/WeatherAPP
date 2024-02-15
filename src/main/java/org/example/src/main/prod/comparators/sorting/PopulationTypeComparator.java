package org.example.src.main.prod.comparators.sorting;

import org.example.src.main.prod.component.PopulationType;

import java.util.Comparator;

public class PopulationTypeComparator implements Comparator<PopulationType> {
    @Override
    public int compare(PopulationType o1, PopulationType o2) {
        int nameComparison = o1.getName().compareTo(o2.getName());
        if (nameComparison == 0) {
            int languageComparison = o1.getLanguage().compareTo(o2.getLanguage());
            if (languageComparison == 0) {
                return Integer.compare(o1.getCount(), o2.getCount());
            }
            return languageComparison;
        }
        return nameComparison;
    }
}
