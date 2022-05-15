package htw.berlin.weatherbackend.service;


import htw.berlin.weatherbackend.controller.WeatherOfCity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class WeatherService {

/*
   private WeatherOfCity city;
    private OkHttpClient client;
    private Response response;
    private String cityName;
    private String unit;
    private final String APIkey = "8f72af7c99ac2ff422253044302e41c7";



    public JSONObject getWeather(){
        client = new OkHttpClient();  //using OKHTTP dependency . You have to add this mannually form OKHTTP website
        Request request = new Request.Builder()
            .url("http://api.openweathermap.org/data/2.5/weather?q="+city.getName()+"&units="+city.getUnit()+"&appid="+APIkey)
            .build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }


    public JSONArray returnWeatherArray() throws JSONException {
        JSONArray weatherJsonArray = getWeather().getJSONArray("weather");
        return weatherJsonArray;
    }

    public JSONObject returnMainObject() throws JSONException {
        JSONObject mainObject = getWeather().getJSONObject("main");
        return mainObject;
    }


    public JSONObject returnWindObject() throws JSONException {
        JSONObject wind = getWeather().getJSONObject("wind");
        return wind;
    }

    public JSONObject returnSysObject() throws JSONException{
        JSONObject sys = getWeather().getJSONObject("sys");
        return sys;
    }

*/
}
