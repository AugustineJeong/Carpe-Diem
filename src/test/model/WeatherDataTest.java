package model;

import model.data.WeatherData;
import network.WebDataLoad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class WeatherDataTest {
    private WebDataLoad webDataLoad;
    WeatherData weatherData;

    @BeforeEach
    void setup() throws IOException {
        webDataLoad = new WebDataLoad();
        weatherData = webDataLoad.dataLoad();
    }

    @Test
    void parseStringTest() {
        String temperature = weatherData.getMain().getTempInCelsius();
        String weather = weatherData.getWeather().get(0).getDescription();

        assertTrue(temperature.length() > 0);
        assertTrue(weather.length() > 0);
    }
}
