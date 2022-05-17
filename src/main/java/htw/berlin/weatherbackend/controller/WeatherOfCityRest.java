package htw.berlin.weatherbackend.controller;

import htw.berlin.weatherbackend.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin
public class WeatherOfCityRest {

   private final CityService cityService;

    public WeatherOfCityRest(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping(path = "/api/v1/weatherofcity")
    public ResponseEntity<List<WeatherOfCity>> fetchCity(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping(path = "/api/v1/weatherofcity/{id}")
    public ResponseEntity<WeatherOfCity> fetchCityById(@PathVariable Long id){
        var city = cityService.findById(id);
        //wenn city nicht null dann ok sonst not Found
        return city!= null ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/weatherofcity")
    public ResponseEntity<Void> createCity(@RequestBody CityManipulationRequest request) throws URISyntaxException {
         var city = cityService.create(request);
        URI uri = new URI("/api/v1/weatherofcity/" + city.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path= "/api/v1/weatherofcity/{id}")
    public ResponseEntity<WeatherOfCity> updateCity (@PathVariable Long id, @RequestBody CityManipulationRequest request ){
        var city = cityService.update(id, request);
        return city!= null ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path= "/api/v1/weatherofcity/{id}")
        public ResponseEntity<Void> deleteCity(@PathVariable Long id){
            boolean successful = cityService.deleteById(id);
            return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        }


}
