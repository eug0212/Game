package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;



public class MyMainCanvas extends Canvas implements KeyListener {
	Objects ground = new Objects(-450, 320, 2000, 900,"sprites/ground.png");
	Badguys	goomba = new Badguys(1280,567,120,150, "sprites/goomba.png");	
	
	public MyMainCanvas() {
		this.setSize(1440,900); // set same size as MyScreen
		this.addKeyListener(this); // add the listener to your canvas
		this.setBackground(VERY_LIGHT_BLUE);
	}
	public static final Color VERY_LIGHT_BLUE = new Color(80,200,255);
	
	public void paint (Graphics g) {
		
		g.drawImage(ground.getImg(), ground.getxCoord(), ground.getyCoord(),ground.getWidth(), ground.getHeight(), this);
		g.drawImage(goomba.getImg(), goomba.getxCoord(), goomba.getyCoord(), goomba.getWidth(), goomba.getHeight(), this);
		goomba.willactuallymove();
		repaint();
		if(this.getxCoord() > 0) {
			System.out.println("You lost a life!");
		}
		repaint();
	}
	
	public void playIt(String filename) {	
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("File/meglovania.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	long currentTime = System.nanoTime();
	long lastTimestamp = currentTime;	
	
	private void setImg(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setxCoord(int x) {
		// TODO Auto-generated method stub
		
	}

	private int getxCoord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}
