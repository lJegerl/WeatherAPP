package org.example.src.main.prod.component;

public class PopulationType{
    private String name;
    private int id;
    private String language;
    private int count;

    public PopulationType(int id, String name, String language, int count) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "PopulationType{" +
                name + " " +
                language + " " +
                count +
                '}';
    }
}
