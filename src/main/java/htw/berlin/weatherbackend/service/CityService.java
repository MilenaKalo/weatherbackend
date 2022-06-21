package htw.berlin.weatherbackend.service;

import htw.berlin.weatherbackend.controller.CityManipulationRequest;
import htw.berlin.weatherbackend.controller.WeatherOfCity;
import htw.berlin.weatherbackend.persistence.CityEntity;
import htw.berlin.weatherbackend.persistence.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository){

        this.cityRepository = cityRepository;
    }

    public List<WeatherOfCity> findAll(){
        List<CityEntity> city = cityRepository.findAll();
        return city.stream()
                .map( cityEntity -> transformEntity(cityEntity))
                .collect(Collectors.toList());
    }
    //optional konkretes Objekt oder null zurückgegeben
    public WeatherOfCity findById(Long id){
        var cityEntity = cityRepository.findById(id);
        // Handling für Optional
        //wenn es eine Entität gibt dann transformieren ansonsten null zurückgeben
        return cityEntity.isPresent() ? transformEntity(cityEntity.get()) : null;
    }

    public boolean deleteById(Long id){
        if (!cityRepository.existsById(id)){
            return false;
        }
        cityRepository.deleteById(id);
        return true;
    }

    public WeatherOfCity update(Long id, CityManipulationRequest request){
        var city = cityRepository.findById(id);
        if (city.isEmpty()){
            return null;
        }
        //hier wird alles einmal vom request aus geupdated und dann in der Datenbank (Repo) gespeichert
        var cityEntity = city.get();
        // ID ist schon vergeben deswegen weiß repo dass es hier nur updaten soll
        cityEntity.setName(request.getName());

        cityEntity= cityRepository.save(cityEntity);

        return transformEntity(cityEntity);

    }

    public WeatherOfCity create(CityManipulationRequest request){
        // wenn die stadt schon vorhanden ist dann soll es nicht gehen
        if(cityRepository.findAllByName(request.getName())!= null){
            var cityEntity = new CityEntity(request.getName());
            cityEntity= cityRepository.save(cityEntity);
            return transformEntity(cityEntity);
        }
        else return null;

    }

    public WeatherOfCity transformEntity (CityEntity cityEntity){
        return new WeatherOfCity(
                cityEntity.getId(),
                cityEntity.getName());

    }
}
