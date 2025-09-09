package com.weatherapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/weatherdb";
    private static final String USER = "postgres";
    private static final String PASS = "123456";

    public static void saveWeather(Weather weather) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO weather_history (city, temperature, description) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, weather.getCity());
            ps.setDouble(2, weather.getTemperature());
            ps.setString(3, weather.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
