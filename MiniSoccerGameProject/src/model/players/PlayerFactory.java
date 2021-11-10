package model.players;


import java.awt.*;

/**
 * Player factory which creates different kinds of players.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class PlayerFactory {

	/**
	 * Creates either a Striker or a Goalkeeper based on the given type, and returns it.
	 * Returns nothing if the type given does not match one of the types allowed.
	 * 
	 * @param type						the desired type of player to be created
	 * @return	<code>Striker</code>	if the given type is striker (not case sensitive)
	 * 			<code>Goalkeeper</code>	if the given type is goalkeeper (not case sensitive)
	 * 			<code>null</code>		if the given type does not match one of the allowed types
	 */
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
