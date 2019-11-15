package network;

import com.google.gson.*;
import jdk.nashorn.internal.parser.JSONParser;
import model.data.WeatherData;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

import java.io.*;
import java.net.URL;

//Citation: lines 21-38 taken from http://zetcode.com/articles/javareadwebpage/
//Citation: lines 42, 44 taken from https://www.mkyong.com/java/how-to-parse-json-with-gson/

public class WebDataLoad {

    String vancouverWeatherQuery = "http://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=";
    String appID = "b48c1d205df319039c044bfb694f2930";
    String vancouverWeatherURL = vancouverWeatherQuery + appID;

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

    public WeatherData dataLoad() throws IOException, JSONException {
        Gson gson = new Gson();
        String json = this.read().toString();
        WeatherData weatherData = gson.fromJson(json, WeatherData.class);
        return weatherData;
    }
}