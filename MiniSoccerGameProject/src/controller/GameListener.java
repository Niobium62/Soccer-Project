package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The GameListener class implements the interface KeyListener, and is responsible for
 * hearing the user's game inputs for the striker in our Mini-Soccer Game.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class GameListener implements KeyListener {

	private final GamePanel gamePanel;

	/**
	 * Creates the new GameListener required for hearing user inputs during the soccer game.
	 * 
	 * @param panel	the panel which will be used for the game
	 */
	public GameListener(GamePanel panel) {
		gamePanel = panel;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		if (!soccerGame.isPaused() && !soccerGame.isOver()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					soccerGame.getActivePlayer().moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					soccerGame.getActivePlayer().moveRight();
					break;
				case KeyEvent.VK_UP:
					soccerGame.getActivePlayer().moveUp();
					break;
				case KeyEvent.VK_DOWN:
					soccerGame.getActivePlayer().moveDown();
					break;
				case KeyEvent.VK_SPACE:
					if (soccerGame.getActivePlayer().isPlayerHasBall()) {
						soccerGame.getActivePlayer().shootBall();
					}
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
