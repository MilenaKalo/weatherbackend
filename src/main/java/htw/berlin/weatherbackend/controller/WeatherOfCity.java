package htw.berlin.weatherbackend.controller;

import org.springframework.stereotype.Component;


public class WeatherOfCity {

    private long id;
    private String name;


    public WeatherOfCity(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
