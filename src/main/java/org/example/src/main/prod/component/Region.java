package org.example.src.main.prod.component;

public class Region {
    private String name;
    private int id;
    private int square;
    private PopulationType type;

    public Region(int id, String name, int square, PopulationType type) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSquare() {
        return square;
    }

    public PopulationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Region{" +
                name + " " +
                square + " " +
                type +
                '}';
    }
}
