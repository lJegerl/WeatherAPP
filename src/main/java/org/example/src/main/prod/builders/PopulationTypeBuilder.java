package org.example.src.main.prod.builders;

import org.example.src.main.prod.component.PopulationType;

public class PopulationTypeBuilder {
    private String name;
    private int id;
    private String language;
    private int count;

    public PopulationTypeBuilder() {

    }

    public PopulationTypeBuilder(PopulationType type) {
        this.id = type.getId();
        this.name = type.getName();
        this.language = type.getLanguage();
        this.count = type.getCount();
    }

    public PopulationTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PopulationTypeBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    public PopulationTypeBuilder setCount(int count) {
        this.count = count;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PopulationType getPopulationType() {
        return new PopulationType(id, name,language, count);
    }
}
