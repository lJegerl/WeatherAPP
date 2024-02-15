package org.example.src.main.prod.builders;

import org.example.src.main.prod.component.PopulationType;
import org.example.src.main.prod.component.Region;

public class RegionBuilder {
    private String name;
    private int square;
    private PopulationType type;
    private int id;

    public RegionBuilder() {
    }

    public RegionBuilder(Region region) {
        this.id = region.getId();
        this.name = region.getName();
        this.square = region.getSquare();
        this.type = region.getType();
    }

    public void setId(int id) {
        this.id = id;
    }

    public RegionBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RegionBuilder setSquare(int square) {
        this.square = square;
        return this;
    }

    public RegionBuilder setType(PopulationType type) {
        this.type = type;
        return this;
    }


    public Region getRegion() {
        return new Region(id, name, square, type);
    }
}
