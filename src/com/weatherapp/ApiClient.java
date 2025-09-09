package com.weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiClient {
	private static final String API_KEY = "913e33189f69ef7babc176a916b3ba15";
    public static Weather getWeather(String city) throws Exception {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" 
                            + city + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();

        JSONObject json = new JSONObject(response.toString());

        double temp = json.getJSONObject("main").getDouble("temp");
        String desc = json.getJSONArray("weather").getJSONObject(0).getString("description");

        return new Weather(city, temp, desc);
    }
}
