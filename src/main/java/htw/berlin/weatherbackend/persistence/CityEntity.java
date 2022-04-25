package htw.berlin.weatherbackend.persistence;

import javax.persistence.*;

@Entity(name = "favourites")
public class CityEntity {
//Datenbank mit den Spalten aufgebaut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "cityname", nullable = false)
    private String name;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "temprature")
    private int temp;

    public CityEntity() {
    }

    public CityEntity(String name, String unit, int temp) {
        this.name = name;
        this.unit = unit;
        this.temp = temp;
    }

    public long getId() {
        return id;
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
