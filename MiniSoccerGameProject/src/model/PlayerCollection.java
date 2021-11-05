package model;

import java.util.ArrayList;
import java.util.List;

import model.players.GamePlayer;

public class PlayerCollection {

	private List<GamePlayer> playerList;
	
	public PlayerCollection() {
		playerList = new ArrayList<GamePlayer>();
	}
	
	//adds the player to the collection
	public void add(GamePlayer player) {
		playerList.add(player);
	}
	
	//returns the player that has the matching playerName
	public GamePlayer get(String playerName) {
		for (GamePlayer i : playerList) {
			if (i.getPlayerName().equals(playerName)) {
				return i;
			}
		}
		return null;
	}
}
