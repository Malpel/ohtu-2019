package ohtuesimerkki;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void returnsExistingPlayer() {
        Player searched = stats.search("Kurri");
        assertNotNull(searched);
    }

    @Test
    public void returnsNullForNonexistingPlayers() {
        Player searched = stats.search("Selanne");
        assertNull(searched);
    }

    @Test
    public void returnsPlayersForExistingTeam() {
        List<Player> team = stats.team("EDM");
        assertEquals(3, team.size());
    }

    @Test
    public void returnCorrectTopScoreres() {
        List<Player> topScorers = new ArrayList<Player>();
        topScorers.add(stats.search("Gretzky"));
        topScorers.add(stats.search("Yzerman"));
        topScorers.add(stats.search("Lemieux"));

        Collections.sort(topScorers);

        List<Player> topThree = stats.topScorers(3);

        assertEquals(topScorers, topThree);
    }
}
