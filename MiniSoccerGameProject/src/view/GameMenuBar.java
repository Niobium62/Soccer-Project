package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * The GameMenuBar class is a child of JMenuBar, and contains all of the elements and controls in the menu bar
 * which help our Mini-Soccer Game function correctly.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class GameMenuBar extends JMenuBar {

	/**
	 * Creates the GameMenuBar with the given ActionListener.
	 * 
	 * @param menubarListener	the given ActionListener
	 */
	public GameMenuBar(ActionListener menubarListener) {
		super();
		JMenu gameMenu = new JMenu("Game");
		gameMenu.add(createMenuItem("New game", "NEW", KeyEvent.VK_N, menubarListener));
		gameMenu.addSeparator();
		gameMenu.add(createMenuItem("Exit", "EXIT", KeyEvent.VK_Q, menubarListener));
		super.add(gameMenu);
		JMenu controlMenu = new JMenu("Control");
		controlMenu.add(createMenuItem("Pause", "PAUSE", KeyEvent.VK_P, menubarListener));
		controlMenu.add(createMenuItem("Resume", "RESUME", KeyEvent.VK_R, menubarListener));
		super.add(controlMenu);
	}

	/**
	 * Creates a JMenuItem for the GameMenuBar using the given parameters.
	 * 
	 * @param text						what is written on the item
	 * @param actionCommand				the command for the item
	 * @param accelerator				the accelerator for the item
	 * @param listener					the ActionListener for the item
	 * @return	<code>JMenuItem</code>	the new JMenuItem
	 */
	private JMenuItem createMenuItem(String text, String actionCommand, int accelerator, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.setActionCommand(actionCommand);
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator, 0));
		return menuItem;
	}

}
