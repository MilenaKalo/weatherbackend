package htw.berlin.weatherbackend.controller;

import org.springframework.stereotype.Component;

//@Component
public class WeatherOfCity {

    private long id;
    private String name;
    private String unit;
    private int temp;

    public WeatherOfCity(long id, String name, String unit, int temp) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.temp = temp;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
