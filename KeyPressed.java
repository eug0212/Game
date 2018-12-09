package Alien;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

public class KeyPressed implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 32) {
			MyCanvas.State = MyCanvas.STATE.GAME;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
