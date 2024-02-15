package org.example.src.main.prod.comparators.sorting;

import org.example.src.main.prod.component.Region;

import java.util.Comparator;

public class RegionComparator implements Comparator<Region> {
    @Override
    public int compare(Region o1, Region o2) {
        int nameComprasion = o1.getName().compareTo(o2.getName());
        if (nameComprasion == 0) {
            int squareComprasion = Integer.compare(o1.getSquare(), o2.getSquare());
            if (squareComprasion == 0) {
                PopulationTypeComparator populationTypeComparator = new PopulationTypeComparator();
                return populationTypeComparator.compare(o1.getType(), o2.getType());
            }
            return squareComprasion;
        }
        return nameComprasion;
    }
}
