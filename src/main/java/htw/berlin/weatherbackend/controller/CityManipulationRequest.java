package htw.berlin.weatherbackend.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CityManipulationRequest {
//Test for Heroku deployment

    // city name darf nicht leer sein und muss eine Länge von mindestens 3 Zeichen haben
    @NotBlank
    @Size(min= 3, message = "Please provide a cityname with 3 characters or more")
    private String name;


    public CityManipulationRequest(String name, String unit, int temp) {
        this.name = name;

    }

    public CityManipulationRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
