package de.exxcellent.challenge.use_cases;

import com.opencsv.exceptions.CsvException;
import de.exxcellent.challenge.business_logic.FootballBusinessLogic;
import de.exxcellent.challenge.domain_model.football.FootballData;
import de.exxcellent.challenge.persistence.CsvFootballExtractor;
import org.apache.commons.lang3.NotImplementedException;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class FootballDataAnalysis extends MinMaxDataAnalysis {
    public FootballDataAnalysis() {
        this.filename = "football";
        this.fileType = "csv";
    }

    public FootballDataAnalysis(String filename) throws DataFormatException {
        super(filename);
    }

    public String getTeamWithMinimumGoalSpread() {
        try {
            String file = filename + "." + this.fileType;
            FootballData footballData = new FootballData();
            switch (this.fileType) {
                case "csv":
                    footballData = new CsvFootballExtractor(file).extractFootballData();
                    break;
                case "json":
                    throw new NotImplementedException();
            }

            if (footballData == null) {
                throw new DataFormatException();
            }

            FootballBusinessLogic footballBusinessLogic = new FootballBusinessLogic(footballData);
            return footballBusinessLogic.getTeamWithMinimumGoalSpread();

        } catch (CsvException | IOException | DataFormatException e) {
            e.printStackTrace();
        }
        return "";
    }
}
