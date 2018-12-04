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
		if (e.getKeyCode() == 49) {
			MyCanvas.State = MyCanvas.STATE.GAME;
			MyCanvas.period = 100L;
		} else if ( e.getKeyCode() == 50) {
			MyCanvas.State = MyCanvas.STATE.GAME;
			MyCanvas.period = 75L;
		} else if (e.getKeyCode() == 51){
			MyCanvas.State = MyCanvas.STATE.GAME;
			MyCanvas.period = 50L;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
