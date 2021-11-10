package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

/**
 * The SoccerGame class represents the key functionality of our Mini-Soccer Game and the implementation of this class is
 * what allows for the game as well as the roles of the players to function as intended.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class SoccerGame {

	private Integer timeRemaining;

	private Integer goal;

	private Boolean isPaused;

	private Boolean isOver;

	private final PlayerCollection gamePlayers;

	/**
	 * Creates the SoccerGame with the set attributes that every SoccerGame should start with.
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = false;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("striker"));
		gamePlayers.add(playerFactory.getPlayer("goalkeeper"));
		startGame();
	}

	/**
	 * Starts the SoccerGame.
	 */
	private void startGame() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	/**
	 * Gets the time remaining in the soccer game.
	 * 
	 * @return	</code>Integer</code>	the time remaining in the game
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Sets the time remaining in the soccer game to the given time.
	 * 
	 * @param timeRemaining	the new time which the game's time will be set to
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Gets the number of goals which have been scored.
	 * 
	 * @return	<code>Integer</code>	the number of goals
	 */
	public Integer getGoal() {
		return goal;
	}

	/**
	 * Sets the number of goals which have been scored to the given value.
	 * 
	 * @param newGoal	the desired number of goals which to set the goals to
	 */
	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}

	/**
	 * Determines whether the game is currently paused.
	 * 
	 * @return	<code>true</code>	if the game is paused
	 * 			<code>false</code>	if the game is not paused
	 */
	public Boolean isPaused() {
		return isPaused;
	}

	/**
	 * Sets the game to pause or unpause status depending on the given boolean value.
	 * 
	 * @param paused	the value which determines if the game will be paused or not
	 */
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}

	/**
	 * Tells us whether or not the game is over.
	 * 
	 * @return	<code>true</code>	if the game is over
	 * 			<code>false</code>	if the game is not over
	 */
	public Boolean isOver() {
		return isOver;
	}

	/**
	 * Sets the game to over or restarts the game based based on the given boolean value.
	 * 
	 * @param over	the given boolean which determines whether the game is over or restarting
	 */
	public void setOver(Boolean over) {
		isOver = over;
	}

	/**
	 * Gets the collection of the players.
	 * 
	 * @return	<code>PlayerCollection</code>	the collection of the players
	 */
	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}

	/**
	 * Determines what the goalkeeper in the game is doing. If there is no ball he/she can save, he/she will continue
	 * moving side to side randomly. If there is a ball he/she can save, he/she will save it.
	 */
	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}

	/**
	 * Determines whether the soccer ball has been scored. It is scored when it is in the net.
	 * 
	 * @return	<code>true</code>	if the ball is scored
	 * 			<code>false</code>	if the ball has not been scored
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}

	/**
	 * Gets the striker from the collection.
	 * 
	 * @return	<code>GamePlayer</code>	the striker
	 */
	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
