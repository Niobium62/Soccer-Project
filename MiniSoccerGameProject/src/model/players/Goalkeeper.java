package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;

/**
 * Goalkeeper is a child class of GamePlayer, and is a player. It inherits the methods from GamePlayer and implements
 * the abstract methods in order to fulfill the role of the goalkeeper in our Mini-Soccer Game.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class Goalkeeper extends GamePlayer {

	private int movementStep;

	/**
	 * Creates the Goalkeeper with the given name and color.
	 * 
	 * @param name	desired name of the Goalkeeper
	 * @param color	desired color of the Goalkeeper
	 */
	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}

	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
	}

	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
	}

	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
	}

	/**
	 * Determines whether the player will move left or right, then moves the player in that direction.
	 */
	public void moveRandomly() {
		Random random = new Random();
		double playerCurrentXPosition = (double) getPlayerPosition().x + 15;
		double chanceOfMovingLeft = (playerCurrentXPosition - 300) / 100 - (random.nextGaussian());
		movementStep = (int) Math.abs(30 * chanceOfMovingLeft);
		if (chanceOfMovingLeft > 0) {
			moveLeft();
		} else {
			moveRight();
		}
	}

	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}

	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
