package htw.berlin.weatherbackend.web;

import htw.berlin.weatherbackend.controller.WeatherOfCity;
import htw.berlin.weatherbackend.controller.WeatherOfCityRest;
import htw.berlin.weatherbackend.service.CityService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WeatherOfCityRest.class)
public class CityRestController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService cityService;


    @Test
    @DisplayName("should return found citys from city service")
    void should_return_found_city_from_citys_service() throws Exception {
        // given
        var citys = List.of(
                new WeatherOfCity(1, "Istanbul"),
                new WeatherOfCity(2, "Dresden")
        );
        doReturn(citys).when(cityService).findAll();

        // when
        mockMvc.perform(get("/api/v1/weatherofcity"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Istanbul"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Dresden"));
    }

    @Test
    @DisplayName("should return 404 if city is not found")
    void should_return_404_if_city_is_not_found() throws Exception {
        // given
        doReturn(null).when(cityService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/weatherofcity/123"))
                // then
                .andExpect(status().isNotFound());
    }

    //der funktioniert noch nicht
    @Test
    @DisplayName("should return 201 http status and Location header when creating a city")
    void should_return_201_http_status_and_location_header_when_creating_a_city() throws Exception {
        // given
        String cityToCreateAsJson = "{\"name\": \"Potsdam\"}";
        var city = new WeatherOfCity(1, null);
        doReturn(city).when(cityService).create(any());

        // when
        mockMvc.perform(
                       post("/api/v1/weatherofcity")
                               .contentType(MediaType.APPLICATION_JSON)
                               .content(cityToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/weatherofcity/" + city.getId()))));

    }


    @Test
    @DisplayName("should validate create city request")
    void should_validate_create_city_request() throws Exception {
        // given
        String cityToCreateAsJson = "{\"name\": \"a\"}";

        // when
        mockMvc.perform(
                        post("/api/v1/weatherofcity")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(cityToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
