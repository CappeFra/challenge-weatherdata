package de.exxcellent.challenge.use_cases;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherDataAnalysisTest {

    @Test
    void constructorWithRightParameterWorks() throws DataFormatException {
        WeatherDataAnalysis weatherDataAnalysis = new WeatherDataAnalysis("test.csv");

        assertEquals("test", weatherDataAnalysis.getFilename());
        assertEquals("csv", weatherDataAnalysis.getFileType());
    }

    @Test
    void constructorWithNoExtensionThrowsException() {
        assertThrows(DataFormatException.class, () -> new WeatherDataAnalysis("test."));
    }

    @Test
    void getMinimumSpreadThrowsNotImplementedExceptionForFutureMethod() throws DataFormatException {
        WeatherDataAnalysis weatherDataAnalysis = new WeatherDataAnalysis("test.json");
        assertThrows(NotImplementedException.class, weatherDataAnalysis::getDayWithMinimumTemperatureSpread);
    }

    @Test
    void getDayWithMinimumSpreadTest() throws DataFormatException {
        WeatherDataAnalysis weatherDataAnalysis = new WeatherDataAnalysis("test_data/weatherTest.csv");
        assertEquals(14, weatherDataAnalysis.getDayWithMinimumTemperatureSpread());
    }
}