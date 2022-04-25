package htw.berlin.weatherbackend.controller;

public class CityManipulationRequest {

    private String name;
    private String unit;
    private int temp;

    public CityManipulationRequest(String name, String unit, int temp) {
        this.name = name;
        this.unit = unit;
        this.temp = temp;
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
