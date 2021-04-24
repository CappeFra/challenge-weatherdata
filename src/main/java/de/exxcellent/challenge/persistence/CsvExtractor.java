package de.exxcellent.challenge.persistence;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CsvExtractor {
    String filename;

    protected List<String[]> getCsvDataRows(String filename) throws IOException, CsvException {
        FileReader fileReader = getFileReader(filename);
        CSVReader csvReader = new CSVReader(fileReader);
        return csvReader.readAll();
    }

    private FileReader getFileReader(String filename) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        String filePath = Objects.requireNonNull(classLoader.getResource(filename), "Weather report file not found").getFile();
        return new FileReader(filePath);
    }
}
