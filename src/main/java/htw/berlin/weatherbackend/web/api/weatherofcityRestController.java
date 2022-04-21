package htw.berlin.weatherbackend.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class weatherofcityRestController {

    private List<weatherofcity> citys;

    public weatherofcityRestController(){
        citys = new ArrayList<>();
        citys.add(new weatherofcity(1, "Berlin", 26, LocalDate.of(2020, 01, 01)));
        citys.add(new weatherofcity(2, "Potsdam", 29, LocalDate.of(2020, 02, 01)));
    }

    @GetMapping(path = "/api/v1/weatherofcity")
    public ResponseEntity<List<weatherofcity>> fetchCity(){
        return ResponseEntity.ok(citys);
    }
}
