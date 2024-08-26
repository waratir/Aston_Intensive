package com.example.homework3.models;

import java.util.Date;

public class Airport {
    private int id;
    private String name;
    private String city;
    private int airplaneId;
    private int workerId;

    public Airport(int id, String name, String city, int airplaneId, int workerId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.airplaneId = airplaneId;
        this.workerId = workerId;
    }

    public int getId() {
        return id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }


    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
