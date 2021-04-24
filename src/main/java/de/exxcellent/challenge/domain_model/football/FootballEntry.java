package de.exxcellent.challenge.domain_model.football;

import de.exxcellent.challenge.domain_model.MinMaxEntry;

public class FootballEntry implements MinMaxEntry {
    private final String team;
    private final int goals;
    private final int goalsAllowed;
    // [...]

    public FootballEntry(String team, int goals, int goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    public String getTeam() {
        return team;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    @Override
    public double calculateSpread() {
        return Math.abs(goals - goalsAllowed);
    }
}
