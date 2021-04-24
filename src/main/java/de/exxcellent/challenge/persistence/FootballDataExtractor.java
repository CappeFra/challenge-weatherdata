package de.exxcellent.challenge.persistence;

import com.opencsv.exceptions.CsvException;
import de.exxcellent.challenge.domain_model.football.FootballData;

import java.io.IOException;

public interface FootballDataExtractor {
    FootballData extractFootballData() throws IOException, CsvException;
}
