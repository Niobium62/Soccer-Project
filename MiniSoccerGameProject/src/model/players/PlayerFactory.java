package model.players;

import java.awt.*;

public class PlayerFactory {

	// instantiate and return a new player
	public GamePlayer getPlayer(String playerType) {
		//create striker
		if (playerType.equals("striker")) {
			Color myColor = new Color(255, 0, 0);
			return new Striker("Striker", myColor);
		// create goalkeeper
		} else if (playerType.equals("goalkeeper")) {
			Color myColor = new Color(0, 0, 255);
			return new Goalkeeper("Goalkeeper", myColor);
		} else {
			return null;
		}
	}

}
