package model.players;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerCollection implements Iterable<GamePlayer> {

    private int size;
    private List<GamePlayer> players;

    public PlayerCollection() {
        this.players = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public Iterator<GamePlayer> iterator() {
        return new PlayerCollectionIterator();
    }

    public void add(GamePlayer player) {
        players.add(player);
        ++size;
    }


    public GamePlayer get(String name) {
        for (int i = 0; i < size; i++) {
            GamePlayer player = players.get(i);
            if (player.getPlayerName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void sort() {
        players.sort(GamePlayer::compareTo);
    }


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
