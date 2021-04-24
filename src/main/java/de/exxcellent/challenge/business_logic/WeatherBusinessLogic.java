package de.exxcellent.challenge.business_logic;

import de.exxcellent.challenge.domain_model.weather.WeatherData;
import de.exxcellent.challenge.domain_model.weather.WeatherEntry;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherBusinessLogic {
    private final WeatherData weatherData;

    public WeatherBusinessLogic(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public double getMinimumTemperatureSpread() {
        List<Double> spreads = weatherData.entries
                .stream()
                .map(WeatherEntry::calculateSpread)
                .sorted()
                .collect(Collectors.toList());
        return spreads.get(0);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    // suppressing this because calling getMinimumSpread makes sure that there will be at least one result
    public String getDayWithMinimumTemperatureSpread() {
        double minimumSpread = getMinimumTemperatureSpread();
        return weatherData.entries.stream().filter(entry ->
            entry.calculateSpread() == minimumSpread
        ).findFirst().get().getDay();
    }
}
