package model.players;


import java.awt.*;

/**
 * Player factory to create different kinds of players
 */
public class PlayerFactory {

    public GamePlayer getPlayer(String type) {
        if ("striker".equalsIgnoreCase(type)) {
            return new Striker("Striker", Color.BLUE);
        } else if ("goalkeeper".equalsIgnoreCase(type)) {
            return new Goalkeeper("Goalkeeper", Color.ORANGE);
        } else {
            return null;
        }
    }
}
