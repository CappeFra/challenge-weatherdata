package de.exxcellent.challenge.persistence;

import com.opencsv.exceptions.CsvException;
import de.exxcellent.challenge.domain_model.weather.WeatherData;
import de.exxcellent.challenge.domain_model.weather.WeatherEntry;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvWeatherExtractor extends CsvExtractor implements WeatherDataExtractor {

    String filename;

    public CsvWeatherExtractor(String filename) {
        this.filename = filename;
    }

    @Override
    public WeatherData extractWeatherData() throws IOException, CsvException {
        List<String[]> dataRows = getCsvDataRows(filename);
        String[] entryMapping = dataRows.get(0);
        int[] entryMappingIndexes = {
                ArrayUtils.indexOf(entryMapping, "Day"),
                ArrayUtils.indexOf(entryMapping, "MxT"),
                ArrayUtils.indexOf(entryMapping, "MnT"),
                ArrayUtils.indexOf(entryMapping, "AvT"),
        };
        dataRows.remove(0);
        List<WeatherEntry> weatherEntries = dataRows.stream().map(
                row -> mapDataRowToWeatherEntry(row, entryMappingIndexes)).collect(Collectors.toList()
        );

        WeatherData extractedWeatherData = new WeatherData();
        extractedWeatherData.entries = weatherEntries;

        return extractedWeatherData;
    }

    private WeatherEntry mapDataRowToWeatherEntry(String[] row, int[] indexes) {
        int day = Integer.parseInt(row[indexes[0]]);
        int mxT = Integer.parseInt(row[indexes[1]]);
        int mnT = Integer.parseInt(row[indexes[2]]);
        int avT = Integer.parseInt(row[indexes[3]]);
        return new WeatherEntry(day, mxT, mnT, avT);
    }
}
