package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public double temperature;
    public double windSpeed;
    public int pressure;

    public int beaufort;
    public double fahrenheit;
    public String weather;


    public Reading(int code, double temperature, double windSpeed, int pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }


    // helper methods//

    public int calcBeaufort() {
        if (windSpeed <= 1.0) {
            beaufort = 0;
        } else if ((windSpeed > 1.0) && (windSpeed <= 5.0)) {
            beaufort = 1;
        } else if ((windSpeed >= 6.0) && (windSpeed <= 11.0)) {
            beaufort = 2;
        } else if ((windSpeed >= 12.0) && (windSpeed <= 19.0)) {
            beaufort = 3;
        } else if ((windSpeed >= 20.0) && (windSpeed <= 28.0)) {
            beaufort = 4;
        } else if ((windSpeed >= 29.0) && (windSpeed <= 38.0)) {
            beaufort = 5;
        } else if ((windSpeed >= 39.0) && (windSpeed <= 49.0)) {
            beaufort = 6;
        } else if ((windSpeed >= 50.0) && (windSpeed <= 61.0)) {
            beaufort = 7;
        } else if ((windSpeed >= 62.0) && (windSpeed <= 74.0)) {
            beaufort = 8;
        } else if ((windSpeed >= 75.0) && (windSpeed <= 88.0)) {
            beaufort = 9;
        } else if ((windSpeed >= 89.0) && (windSpeed <= 102.0)) {
            beaufort = 10;
        } else if ((windSpeed >= 103.0) && (windSpeed <= 117.0)) {
            beaufort = 11;
        }
        return beaufort;

    }

    public double calcFahrenheit() {

        fahrenheit = (temperature * 1.8) + 32;
        return fahrenheit;
    }

    public String codeWeather() {
        if (code == 100) {
            weather = "Clear";
        } else if (code == 200) {
            weather = "Partial Clouds";
        } else if (code == 300) {
            weather = "Cloudy";
        } else if (code == 400) {
            weather = "Light Showers";
        } else if (code == 500) {
            weather = "Heavy Showers";
        } else if (code == 600) {
            weather = "Rain";
        } else if (code == 700) {
            weather = "Snow";
        } else if (code == 800) {
            weather = "Thunder";
        }
        return weather;

    }

}
