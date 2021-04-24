package de.exxcellent.challenge.use_cases;

import com.opencsv.exceptions.CsvException;
import de.exxcellent.challenge.business_logic.WeatherBusinessLogic;
import de.exxcellent.challenge.domain_model.weather.WeatherData;
import de.exxcellent.challenge.persistence.CsvWeatherExtractor;
import org.apache.commons.lang3.NotImplementedException;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class WeatherDataAnalysis extends DataAnalysisUseCase {
    public WeatherDataAnalysis() {
        this.filename = "weather";
        this.fileType = "csv";
    }

    public WeatherDataAnalysis(String filename) throws DataFormatException {
        super(filename);
    }

    public String getDayWithMinimumTemperatureSpread() {
        try {
            String file = filename + "." + this.fileType;
            WeatherData weatherData = new WeatherData();
            switch (this.fileType) {
                case "csv":
                    weatherData = new CsvWeatherExtractor(file).extractWeatherData();
                    break;
                case "json":
                    throw new NotImplementedException();
            }

            if (weatherData == null) {
                throw new DataFormatException();
            }

            WeatherBusinessLogic weatherBusinessLogic = new WeatherBusinessLogic(weatherData);
            return weatherBusinessLogic.getDayWithMinimumTemperatureSpread();

        } catch (CsvException | IOException | DataFormatException e) {
            e.printStackTrace();
        }
        return "";
    }
}
