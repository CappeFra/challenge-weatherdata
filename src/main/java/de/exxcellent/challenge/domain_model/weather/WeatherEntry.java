package de.exxcellent.challenge.domain_model.weather;

import de.exxcellent.challenge.domain_model.MinMaxEntry;

public class WeatherEntry implements MinMaxEntry {
    private int day;
    private int maxTemperature;
    private int minTemperature;
    private int avgTemperature;
    // [...]

    public int getDay() {
        return day;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getAvgTemperature() {
        return avgTemperature;
    }

    @Override
    public double calculateSpread() {
        return maxTemperature - minTemperature;
    }
}
