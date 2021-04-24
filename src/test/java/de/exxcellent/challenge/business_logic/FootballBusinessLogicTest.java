package de.exxcellent.challenge.business_logic;

import de.exxcellent.challenge.domain_model.football.FootballData;
import de.exxcellent.challenge.domain_model.football.FootballEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballBusinessLogicTest {

    FootballBusinessLogic footballBusinessLogic;

    @BeforeEach
    void setUp() {
        FootballData footballData = new FootballData();
        footballData.entries.add(new FootballEntry("a", 10, 5)); // absolute spread 5
        footballData.entries.add(new FootballEntry("b", 20, 30)); // absolute spread 10
        footballData.entries.add(new FootballEntry("c", 15, 8)); // absolute spread 7
        footballData.entries.add(new FootballEntry("d", 10, 12)); // absolute spread 2
        footballData.entries.add(new FootballEntry("e", -4, 10)); // absolute spread 14

        footballBusinessLogic = new FootballBusinessLogic(footballData);
    }

    @Test
    void footballBusinessLogicFindsMinimumSpread() {
        assertEquals(2, footballBusinessLogic.getMinimumGoalSpread());
    }

    @Test
    void footballBusinessLogicFindsDayWithMinimumSpread() {
        assertEquals("d", footballBusinessLogic.getTeamWithMinimumGoalSpread());
    }
}
