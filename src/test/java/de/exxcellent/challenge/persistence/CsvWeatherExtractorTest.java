package de.exxcellent.challenge.persistence;

import com.opencsv.exceptions.CsvException;
import de.exxcellent.challenge.domain_model.weather.WeatherData;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvWeatherExtractorTest {

    private final CsvWeatherExtractor extractor = new CsvWeatherExtractor();

    @Test
    void canExtractWeatherData() throws IOException, CsvException {
        WeatherData weatherData = extractWeatherData();

        assertEquals(30, weatherData.entries.size());
    }

    @Test
    void extractedDataIsConsistent() throws IOException, CsvException {
        WeatherData weatherData = extractWeatherData();

        for (int i = 0; i < weatherData.entries.size(); i++) {
            assertEquals(i + 1, weatherData.entries.get(i).getDay());
        }
    }

    private WeatherData extractWeatherData() throws IOException, CsvException {
        String defaultWeatherTestFile = "test_data/weatherTest.csv";
        return extractor.extractWeatherData(defaultWeatherTestFile);
    }
}