package de.exxcellent.challenge.domain_model.weather;

import de.exxcellent.challenge.domain_model.MinMaxEntry;

public class WeatherEntry implements MinMaxEntry {
    private final int day;
    private final int maxTemperature;
    private final int minTemperature;
    private final int avgTemperature;
    // [...]

    public WeatherEntry(int day, int maxTemperature, int minTemperature, int avgTemperature) {
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.avgTemperature = avgTemperature;
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemperature() {
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
