package com.example.homework3.models;

import java.util.Date;

public class Airplane {

    private int id;
    private String name;
    private String type;

    public int getId() {
        return id;
    }

    public Airplane(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
