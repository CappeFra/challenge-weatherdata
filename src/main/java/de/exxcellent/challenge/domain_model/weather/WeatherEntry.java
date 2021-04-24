package de.exxcellent.challenge.domain_model.weather;

import de.exxcellent.challenge.domain_model.MinMaxEntry;

public class WeatherEntry implements MinMaxEntry {
    private final int day;
    private final double maxTemperature;
    private final double minTemperature;
    private final double avgTemperature;
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

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    @Override
    public double calculateSpread() {
        return maxTemperature - minTemperature;
    }
}
