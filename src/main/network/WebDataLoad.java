package network;

import com.google.gson.*;
import model.data.WeatherData;

import java.io.*;
import java.net.URL;

//Citation: lines 15-17 modeled after CPSC 210 edX Deliverable 10 instructions
//Citation: lines 19-35 taken from http://zetcode.com/articles/javareadwebpage/
//Citation: lines 39,41 taken from https://www.mkyong.com/java/how-to-parse-json-with-gson/

public class WebDataLoad {

    private String vancouverWeatherQuery = "http://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=";
    private String appID = "b48c1d205df319039c044bfb694f2930";
    private String vancouverWeatherURL = vancouverWeatherQuery + appID;

    private StringBuilder read() throws IOException {

        BufferedReader br = null;

        URL url = new URL(vancouverWeatherURL);
        br = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;

        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {

            sb.append(line);
            sb.append(System.lineSeparator());
        }
        return sb;
    }

    public WeatherData dataLoad() throws IOException {
        Gson gson = new Gson();
        String json = this.read().toString();
        return gson.fromJson(json, WeatherData.class);
    }
}