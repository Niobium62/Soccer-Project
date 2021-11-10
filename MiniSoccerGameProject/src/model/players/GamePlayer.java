package model.players;

import model.SoccerBall;

import java.awt.*;

/**
 * GamePlayer is the abstract base class for all players involved in the Mini-Soccer Game.
 * A GamePlayer has a position, and is able to hold and shoot the ball. GamePlayer is allowed
 * movement, however those methods are abstract and implemented by its children.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public abstract class GamePlayer implements Comparable<GamePlayer> {

	protected final String playerName;

	protected final Color playerColor;

	protected Point playerPosition;

	protected final PlayerStatistics playerStatistics;

	/**
	 * Constructor which creates GamePlayer with the given name, color.
	 * It initializes the PlayerStatistics for the player and
	 * sets its position to the initial position. 
	 * 
	 * @param name		the desired name of the player
	 * @param color		the desired color of the player
	 */
	public GamePlayer(String name, Color color) {
		playerName = name;
		playerColor = color;
		playerStatistics = new PlayerStatistics();
		setInitialPosition();
	}

	/**
	 * Checks whether the player has the ball.
	 * 
	 * @return	<code>true</code> if the player has the ball
	 *			<code>false</code> if the player does not have the ball
	 */
	public boolean isPlayerHasBall() {
		Point playerPositionCenter = new Point(getPlayerPosition().x + 15, getPlayerPosition().y + 30);
		return playerPositionCenter.distance(SoccerBall.getSoccerBall().getPosition()) < 55;
	}

	/**
	 * The player grabs the ball.
	 */
	public void grabsBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		if (getPlayerPosition().x + 15 > ball.getPosition().x) {
			ball.setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		} else {
			ball.setPosition(new Point(getPlayerPosition().x + 20, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Player moves left.
	 */
	public abstract void moveLeft();

	/**
	 * Player moves right.
	 */
	public abstract void moveRight();

	/**
	 * Player moves up.
	 */
	public abstract void moveUp();

	/**
	 * Player moves down.
	 */
	public abstract void moveDown();

	/**
	 * Player shoots the ball.
	 */
	public abstract void shootBall();

	/**
	 * Gets the player's name.
	 * 
	 * @return	<code>String</code> name of the GamePlayer
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Gets the player's color.
	 * 
	 * @return	<code>Color</code> color of the GamePlayer
	 */
	public Color getPlayerColor() {
		return playerColor;
	}

	/**
	 * Gets the player's position.
	 * 
	 * @return	<code>Point</code> position of the GamePlayer
	 */
	public Point getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * Sets the player position to the correct initial position corresponding to the player type.
	 */
	public abstract void setInitialPosition();

	/**
	 * Sets the player position to the given new position.
	 * 
	 * @param newPosition	the new desired position of the player
	 */
	public void setPlayerPosition(Point newPosition) {
		playerPosition = newPosition;
		if (isPlayerHasBall()) {
			grabsBall();
		}
	}

	/**
	 * Gets the number representing the player statistics.
	 * 
	 * @return	<code>Integer</code> the player's statistics
	 */
	public Integer getPlayerStatistics() {
		return playerStatistics.getStatistics();
	}

	/**
	 * Sets the number representing the player statistics to the given value.
	 * 
	 * @param newStatistics		the new desired statistic
	 */
	public void setPlayerStatistics(Integer newStatistics) {
		playerStatistics.setStatistics(newStatistics);
	}

	/**
	 * Compares the given player statistics to the player statistics and returns an int which
	 * represents the result of the comparison.
	 * 
	 * @return 	<code>0</code>						if the statistics are equal
	 * 			<code>a value less than 0</code> 	if the given player's statistic is less than the player's statistic
	 * 			<code>a value greater than 0</code>	if the given player's statistic is greater than the player's statistic 
	 */
	@Override
	public int compareTo(GamePlayer otherPlayer) {
		return otherPlayer.getPlayerStatistics().compareTo(this.getPlayerStatistics());
	}

	/**
	 * Describes the player to us and what the player has accomplished during the game.
	 * 
	 * @return	<code>String</code> made up of the player's name as well as how much of its important statistic it accumulated.
	 */
	@Override
	public abstract String toString();
}
