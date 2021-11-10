package model.players;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PlayerCollection implements the interface Iterable. It allows for the storage of the players participating
 * in the game in an iterable collection for ease of access later.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class PlayerCollection implements Iterable<GamePlayer> {

    private int size;
    private List<GamePlayer> players;

    /**
     * Creates a new PlayerCollection for storing players in.
     */
    public PlayerCollection() {
        this.players = new ArrayList<>();
        this.size = 0;
    }

    /**
     * Creates a new PlayerCollectionIterator which can be used to iterate through a PlayerCollection.
     * 
     * @return	<code>Iterator</code>	the new PlayerCollectionIterator created
     */
    @Override
    public Iterator<GamePlayer> iterator() {
        return new PlayerCollectionIterator();
    }

    /**
     * Adds the given player to the collection.
     * 
     * @param player	the player to be added to the collection
     */
    public void add(GamePlayer player) {
        players.add(player);
        ++size;
    }

    /**
     * Returns the player with the specified name from the collection, if it exists.
     * 
     * @param name					the name of the desired player
     * @return	<code>player</code>	if the player of the given name exists
     * 			<code>null</code> 	if the player of the given name does not exist
     */
    public GamePlayer get(String name) {
        for (int i = 0; i < size; i++) {
            GamePlayer player = players.get(i);
            if (player.getPlayerName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Sorts the players in the collection based on their statistics.
     */
    public void sort() {
        players.sort(GamePlayer::compareTo);
    }

    /**
     * PlayerCollectionIterator implements Iterator, and is used to iterate through a PlayerCollection.
     * 
     * @author Roberto Shino
     * @author Arian Mohamad Hosaini
     * @author Wenjing Qu
     */
    class PlayerCollectionIterator implements Iterator<GamePlayer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public GamePlayer next() {
            return players.get(index++);
        }
    }

}
