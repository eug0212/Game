package Alien;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Menu extends Canvas{
	Background gameBackground = new Background (0,0,1440,900, "sprites/background.jpeg");
	
	public Menu() {
		this.setSize(1440,900); // set same size as MyScreen
		this.setBackground(Color.BLACK);
	}

	public void paint(Graphics g) {
		
		g.drawImage(gameBackground.getImg(), gameBackground.getxCoord(), gameBackground.getyCoord(), gameBackground.getWidth(),gameBackground.getHeight(), this );
		Font fnt0 =  new Font("8bitoperator", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Alien Invaders!", 770, 450);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Press the Spacebar to play!", 100, 400);

	}
}
