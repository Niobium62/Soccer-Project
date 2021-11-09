package model.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PlayerCollection implements Iterable<GamePlayer>{

	private List<GamePlayer> playerList;
	
	public PlayerCollection() {
		playerList = new ArrayList<GamePlayer>();
	}
	
	//adds the player to the collection
	public void add(GamePlayer player) {
		playerList.add(player);
	}
	
	//returns the player that has the matching playerName. otherwise, returns null
	public GamePlayer get(String playerName) {
		for (GamePlayer i : playerList) {
			if (i.getPlayerName().equals(playerName)) {
				return i;
			}
		}
		return null;
	}
	
	//sort based on player
	public void sort() {
		Collections.sort(playerList);
	}

	@Override
	public Iterator<GamePlayer> iterator() {
		// TODO Auto-generated method stub
		return playerList.iterator();
	}
	
	
}
