package de.exxcellent.challenge.business_logic;

import de.exxcellent.challenge.domain_model.football.FootballData;
import de.exxcellent.challenge.domain_model.football.FootballEntry;

import java.util.List;
import java.util.stream.Collectors;

public class FootballBusinessLogic {
    private final FootballData footballData;

    public FootballBusinessLogic(FootballData footballData) {
        this.footballData = footballData;
    }

    public double getMinimumGoalSpread() {
        List<Double> spreads = footballData.entries
                .stream()
                .map(FootballEntry::calculateSpread)
                .sorted()
                .collect(Collectors.toList());
        return spreads.get(0);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    // suppressing this because calling getMinimumSpread makes sure that there will be at least one result
    public String getTeamWithMinimumGoalSpread() {
        double minimumSpread = getMinimumGoalSpread();
        return footballData.entries.stream().filter(entry ->
                entry.calculateSpread() == minimumSpread
        ).findFirst().get().getTeam();
    }
}
