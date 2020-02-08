package ohtuesimerkki;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class StatisticsTest {

	Player player;
	List<Player> team;
	List<Player> players;
	Reader readerStub;
	Statistics stats;

	public StatisticsTest() {
		player = new Player("Kurri", "EDM", 37, 53);
		team = new ArrayList<>();
		team.add(player);
		team.add(new Player("Semenko", "EDM", 4, 12));
		team.add(new Player("Gretzky", "EDM", 35, 89));

		readerStub = new Reader() {

			public List<Player> getPlayers() {
				players = new ArrayList<>();

				players.addAll(team);
				players.add(new Player("Lemieux", "PIT", 45, 54));
				players.add(new Player("Yzerman", "DET", 42, 56));

				return players;
			}
		};
		stats = new Statistics(readerStub);
	}

	@Test
	public void existingPlayerCanBeFound() {
		Player player2 = stats.search("Kurri");
		assertEquals(player, player2);
	}

	@Test
	public void nonExistingPlayerCantBeFound() {
		Player player2 = stats.search("Curry");
		assertEquals(null, player2);
	}

	@Test
	public void teamCanBeFound() {
		List<Player> team2 = stats.team("EDM");
		assertEquals(team, team2);
	}

	@Test
	public void topScoresWorks() {
		List<Player> topScorers = stats.topScorers(4);
		Collections.sort(players);
		assertEquals(players, topScorers);

		players.remove(players.size() - 1);
		topScorers = stats.topScorers(3);
		assertEquals(players, topScorers);
	}
}
