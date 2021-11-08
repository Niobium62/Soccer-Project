package model.players;

import model.players.GamePlayer;
import model.players.PlayerCollection;
import model.players.PlayerFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PlayerCollectionTest {

    private PlayerFactory factory;
    private PlayerCollection players;

    @Before
    public void setUp() {
        factory = new PlayerFactory();
        players = new PlayerCollection();
        players.add(factory.getPlayer("striker"));
        players.add(factory.getPlayer("goalkeeper"));
    }

    @Test
    public void iterator() {
        Iterator<GamePlayer> iterator = players.iterator();
        assertTrue(iterator.hasNext());
        assertNotNull(iterator.next());
        assertTrue(iterator.hasNext());
        assertNotNull(iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void sort() {
        int i = 0;
        for (GamePlayer player : players) {
            player.setPlayerStatistics(i + 1);
            i++;
        }
        i = 0;
        for (GamePlayer player : players) {
            assertEquals(i + 1, player.getPlayerStatistics().intValue());
            i++;
        }

        players.sort();
        i = 0;
        for (GamePlayer player : players) {
            assertEquals(2 - i, player.getPlayerStatistics().intValue());
            i++;
        }
    }

    @Test
    public void get() {
        assertNull(players.get("null"));
        assertNull(factory.getPlayer("null"));
    }
}