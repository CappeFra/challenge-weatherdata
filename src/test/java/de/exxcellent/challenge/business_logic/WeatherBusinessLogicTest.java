package de.exxcellent.challenge.business_logic;

import de.exxcellent.challenge.domain_model.weather.WeatherData;
import de.exxcellent.challenge.domain_model.weather.WeatherEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherBusinessLogicTest {

    WeatherBusinessLogic weatherBusinessLogic;

    @BeforeEach
    void setUp() {
        WeatherData weatherData = new WeatherData();
        weatherData.entries.add(new WeatherEntry(1, 10, 5, 7)); // spread 5
        weatherData.entries.add(new WeatherEntry(5, 30, 20, 24)); // spread 10
        weatherData.entries.add(new WeatherEntry(3, 15, 8, 12)); // spread 7
        weatherData.entries.add(new WeatherEntry(8, 12, 10, 11)); // spread 2
        weatherData.entries.add(new WeatherEntry(17, 10, -4, 7)); // spread 14

        weatherBusinessLogic = new WeatherBusinessLogic(weatherData);
    }

    @Test
    void weatherBusinessLogicFindsMinimumSpread() {
        assertEquals(2, weatherBusinessLogic.getMinimumTemperatureSpread());
    }

    @Test
    void weatherBusinessLogicFindsDayWithMinimumSpread() {
        assertEquals(8, weatherBusinessLogic.getDayWithMinimumTemperatureSpread());
    }
}