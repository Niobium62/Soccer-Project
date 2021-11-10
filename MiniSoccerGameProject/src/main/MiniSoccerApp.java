package main;
import controller.GameListener;
import controller.MenubarListener;
import view.GameMenuBar;
import view.GamePanel;

import javax.swing.*;

/**
 * The MiniSoccerApp class represents the entirety of the elements which make up
 * the Mini-Soccer Game in one runnable application.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class MiniSoccerApp {

	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("Mini Soccer");
		GamePanel gamePanel = new GamePanel();
		GameListener gameListener = new GameListener(gamePanel);
		MenubarListener menubarListener = new MenubarListener(gamePanel);
		GameMenuBar gameMenuBar = new GameMenuBar(menubarListener);
		gameFrame.add(gamePanel);
		gameFrame.addKeyListener(gameListener);
		gameFrame.setJMenuBar(gameMenuBar);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(600, 600);
		gameFrame.setLocationRelativeTo(null);
//		gameFrame.setResizable(false);
		gameFrame.setVisible(true);
	}
}
