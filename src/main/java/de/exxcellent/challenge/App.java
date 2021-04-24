package de.exxcellent.challenge;

import de.exxcellent.challenge.use_cases.FootballDataAnalysis;
import de.exxcellent.challenge.use_cases.WeatherDataAnalysis;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        WeatherDataAnalysis weatherDataAnalysisUseCase = new WeatherDataAnalysis();

        String dayWithSmallestTempSpread = weatherDataAnalysisUseCase.getDayWithMinimumTemperatureSpread();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        FootballDataAnalysis footballDataAnalysisUseCase = new FootballDataAnalysis();

        String teamWithSmallestGoalSpread = footballDataAnalysisUseCase.getTeamWithMinimumGoalSpread();
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
