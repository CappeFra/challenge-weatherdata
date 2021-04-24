package de.exxcellent.challenge.persistence;

import com.opencsv.exceptions.CsvException;
import de.exxcellent.challenge.domain_model.football.FootballData;
import de.exxcellent.challenge.domain_model.football.FootballEntry;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFootballExtractor extends CsvExtractor implements FootballDataExtractor {

    public CsvFootballExtractor(String filename) {
        this.filename = filename;
    }

    @Override
    public FootballData extractFootballData() throws IOException, CsvException {
        List<String[]> dataRows = getCsvDataRows(filename);
        String[] entryMapping = dataRows.get(0);
        int[] entryMappingIndexes = {
                ArrayUtils.indexOf(entryMapping, "Team"),
                ArrayUtils.indexOf(entryMapping, "Goals"),
                ArrayUtils.indexOf(entryMapping, "Goals Allowed"),
        };
        dataRows.remove(0);
        List<FootballEntry> footballEntries = dataRows.stream().map(
                row -> mapDataRowToFootballEntry(row, entryMappingIndexes)).collect(Collectors.toList()
        );

        FootballData extractedFootballData = new FootballData();
        extractedFootballData.entries = footballEntries;

        return extractedFootballData;
    }

    private FootballEntry mapDataRowToFootballEntry(String[] row, int[] indexes) {
        String team = row[indexes[0]];
        int goals = Integer.parseInt(row[indexes[1]]);
        int goalsAllowed = Integer.parseInt(row[indexes[2]]);
        return new FootballEntry(team, goals, goalsAllowed);
    }
}
