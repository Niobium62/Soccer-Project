package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * SoccerBall is the class which represents the soccer ball in our Mini-Soccer Game.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class SoccerBall {

	private static final SoccerBall soccerBall = new SoccerBall();

	private Point position;

	private double velocity;

	private final Color color;

	/**
	 * Creates a new SoccerBall and sets its position to the initial position for use in the soccer game.
	 */
	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}

	/**
	 * Gets the SoccerBall.
	 * 
	 * @return	<code>SoccerBall</code>	the object SoccerBall
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}

	/**
	 * Moves the ball based on the given parameters.
	 * 
	 * @param initialDistance	the initial distance the ball will move
	 * @param initialVelocity	the initial velocity of the ball
	 * @param acceleration		the acceleration of the ball
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/**
	 * Moves the ball by the given distance in the y direction.
	 * 
	 * @param distance	the distance the ball will move
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}

	/**
	 * Sets the soccer ball's position to the initial position required to play.
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}

	/**
	 * Determines whether the ball is on the goalkeeper's side.
	 * 
	 * @return	<code>true</code>	if the ball is on the goalkeeper's side
	 * 			<code>false</code>	if the ball is not on the goalkeeper's side
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}

	/**
	 * Determines whether the ball is in the net.
	 * 
	 * @return	<code>true</code>	if the ball is in the net
	 * 			<code>false</code> 	if the ball is not in the net
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}

	/**
	 * Sets the ball's velocity to the given value.
	 * 
	 * @param velocity	the desired velocity of the ball
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	/**
	 * Gets the current position of the ball.
	 * 
	 * @return	<code>Point</code>	the position of the ball
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Sets the ball's position to the given position.
	 * 
	 * @param position	the new desired position of the ball
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Gets the color of the ball.
	 * 
	 * @return	<code>Color</code>	the color of the ball
	 */
	public Color getColor() {
		return color;
	}
}
