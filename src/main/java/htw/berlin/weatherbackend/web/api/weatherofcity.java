package htw.berlin.weatherbackend.web.api;

import java.time.LocalDate;

public class weatherofcity {

    private long id;
    private String name;
    private int celsius;
    private LocalDate date;

    public weatherofcity(long id, String name, int celsius, LocalDate date) {
        this.id = id;
        this.name = name;
        this.celsius = celsius;
        this.date = date;
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

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
