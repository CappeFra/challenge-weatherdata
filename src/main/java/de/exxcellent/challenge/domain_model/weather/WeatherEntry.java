package de.exxcellent.challenge.domain_model.weather;

import de.exxcellent.challenge.domain_model.MinMaxEntry;

public class WeatherEntry implements MinMaxEntry {
    private final String day;
    private final double maxTemperature;
    private final double minTemperature;
    // [...]

    public WeatherEntry(String day, int maxTemperature, int minTemperature) {
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }

    public String getDay() {
        return day;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }


    @Override
    public double calculateSpread() {
        return maxTemperature - minTemperature;
    }
}
