package de.exxcellent.challenge.persistence;

import com.opencsv.exceptions.CsvException;
import de.exxcellent.challenge.domain_model.weather.WeatherData;

import java.io.IOException;

public interface WeatherDataExtractor {
    WeatherData extractWeatherData(String filename) throws IOException, CsvException;
}
