package model.data;

import java.util.List;

//Citation: Created a java class structure that represents data in JSON using guidance from MikO's answer on
//https://stackoverflow.com/questions/19169754/parsing-nested-json-data-using-gson

public class WeatherData {
    private List<Weather> weather;
    private MainInfo main;

    //EFFECTS: returns weather
    public List<Weather> getWeather() {
        return weather;
    }

    //EFFECTS: returns main
    public MainInfo getMain() {
        return main;
    }
}
