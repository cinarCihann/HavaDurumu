package com.weatherapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Şehir adı giriniz: ");
        String city = sc.nextLine();

        try {
            Weather weather = ApiClient.getWeather(city);
            System.out.println("Şehir: " + weather.getCity());
            System.out.println("Sıcaklık: " + weather.getTemperature() + " °C");
            System.out.println("Durum: " + weather.getDescription());

            Database.saveWeather(weather);
            System.out.println("Veri veritabanına kaydedildi ✅");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
