package htw.berlin.weatherbackend.persistence;

import javax.persistence.*;

@Entity(name = "favourites")
public class CityEntity {
//Datenbank mit den Spalten aufgebaut
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "cityname", nullable = false)
    private String name;

    public CityEntity() {
    }

    public CityEntity(String name) {
        this.name = name;
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

}
