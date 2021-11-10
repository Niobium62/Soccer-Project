package model.players;

import model.SoccerBall;

import java.awt.*;

/**
 * Striker is a child class of GamePlayer, and is a player. It inherits the methods from GamePlayer and implements
 * the abstract methods in order to fulfill the role of the striker in our Mini-Soccer Game.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class Striker extends GamePlayer {
	
	/**
	 * Creates a Striker with the given name and color.
	 * 
	 * @param name	desired name of the Striker
	 * @param color	desired color of the Striker
	 */
	public Striker(String name, Color color) {
		super(name, color);
	}

	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 10 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - 5, getPlayerPosition().y));
		}
	}

	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + 5, getPlayerPosition().y));
		}
	}

	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 200) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 500) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(60, 5.0, 0.05);
	}

	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(500, 450));
	}

	@Override
	public String toString() {
		return playerName + " scored " + playerStatistics.toString() + " goals";
	}
}
