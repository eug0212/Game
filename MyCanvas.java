package Alien;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MyCanvas extends Canvas implements KeyListener,ActionListener{
	 // global variables - accessible in all methods
	Goodguy fighter = new Goodguy(680, 800, 60, 60,"sprites/fighter.png");
	Background gameBackground = new Background (0,0,1440,900, "sprites/background.jpeg");
	Objects life1 = new Objects (20, 800, 40, 40, "sprites/fighter.png");
	Objects life2 = new Objects (65, 800, 40, 40, "sprites/fighter.png");
	LinkedList badguys = new LinkedList();
	LinkedList lasers = new LinkedList();
	Timer t = new Timer(5, this);
	int x1 = 1600;
	int x2 = 1700;
	int x3 = 1800;
	int y1 = 70;
	int y2 = 200;
	int vel = 1;

	public MyCanvas() {
		this.setSize(1440,900); // set same size as MyScreen
		this.addKeyListener(this); // add the listener to your canvas
//		playIt("meglovania.wav");

		Random rand = new Random();
		int winWidth = this.getWidth();
		int winHeight = this.getHeight();
		for (int i = 0; i < 2; i++) {
			int rx = rand.nextInt(winWidth);
			int ry = rand.nextInt(winHeight);
			Badguy bg = new Badguy (rand.nextInt(1500), rand.nextInt(900), 70, 70, "sprites/badguy1.png");
			Rectangle r = new Rectangle(100,100,30,30);
			if (r.contains(fighter.getxCoord(), fighter.getyCoord())) {
				continue;
			}
			badguys.add(bg);
		}
	}
	
	 
	
//	public void playIt(String filename) {
//		
//		try {
//	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("File/meglovania.wav").getAbsoluteFile());
//	        Clip clip = AudioSystem.getClip();
//	        clip.open(audioInputStream);
//	        clip.start();
//	    } catch(Exception ex) {
//	        System.out.println("Error with playing sound.");
//	        ex.printStackTrace();
//	    }
//		
//	}
	
	@Override
	public void paint (Graphics g) {
		//g.fillOval(100,100,10,10);
		//draw good guy
		g.drawImage(gameBackground.getImg(), gameBackground.getxCoord(), gameBackground.getyCoord(), gameBackground.getWidth(),gameBackground.getHeight(), this );
		g.drawImage(fighter.getImg(), fighter.getxCoord(), fighter.getyCoord(),fighter.getWidth(), fighter.getHeight(), this);
		g.drawImage(life1.getImg(), life1.getxCoord(), life1.getyCoord(),life1.getWidth(), life1.getHeight(), this);
		g.drawImage(life2.getImg(), life2.getxCoord(), life2.getyCoord(),life2.getWidth(), life2.getHeight(), this);
		//g.fillRect(x, 30, 50, 50);
		t.start();

		for (int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			g.drawImage(bg.getImg(), x1, y1, bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(x1, y1, bg.getWidth(), bg.getHeight());
			t.start();
			
			for (int j = 0; j < 1000000000; j++) {
				Lasers k = (Lasers) lasers.get(j);
				if (k.getxCoord() > this.getWidth()) { lasers.remove(k);}
					k.setxCoord(k.getxCoord() + 1);
					g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
					
					Rectangle kr = new Rectangle(k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());		
					if (kr.intersects(r)) {
						badguys.remove(i);
						lasers.remove(i);
					}
				repaint();
			}
		}
		for (int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			g.drawImage(bg.getImg(), x1, y2, bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(x1, y2, bg.getWidth(), bg.getHeight());
			t.start();
			
			for (int j = 0; j < 1000000000; j++) {
				Lasers k = (Lasers) lasers.get(j);
				if (k.getxCoord() > this.getWidth()) { lasers.remove(k);}
					k.setxCoord(k.getxCoord() + 1);
					g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
									
					Rectangle kr = new Rectangle(k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());		
					if (kr.intersects(r)) {
						badguys.remove(i);
						lasers.remove(i);
					}
				repaint();
			}
		}
		for (int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			g.drawImage(bg.getImg(), x2, y1, bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(x2, y1, bg.getWidth(), bg.getHeight());
			t.start();
			
			for (int j = 0; j < 1000000000; j++) {
				Lasers k = (Lasers) lasers.get(j);
				if (k.getxCoord() > this.getWidth()) { lasers.remove(k);}
					k.setxCoord(k.getxCoord() + 1);
					g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
									
					Rectangle kr = new Rectangle(k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());		
					if (kr.intersects(r)) {
						badguys.remove(i);
						lasers.remove(i);
					}
				repaint();
			}
		}
		for (int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			g.drawImage(bg.getImg(), x2, y2, bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(x2, y2, bg.getWidth(), bg.getHeight());
			t.start();
			
			for (int j = 0; j < 1000000000; j++) {
				Lasers k = (Lasers) lasers.get(j);
				if (k.getxCoord() > this.getWidth()) { lasers.remove(k);}
					k.setxCoord(k.getxCoord() + 1);
					g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
									
					Rectangle kr = new Rectangle(k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());		
					if (kr.intersects(r)) {
						badguys.remove(i);
						lasers.remove(i);
					}
				repaint();
			}
		}
	}
	
	public void actionPerformed (ActionEvent e) {
		if (x1 >= 500 && x2 >= 500 && x3 >= 500)
			x1 = x1 - vel;
			x2 = x2 - vel;
			x3 = x3 - vel;
			repaint();
		if (((x1 < 500) &&(x2 < 500) && (x3 < 500)) && ((y1 > 0 && y2 > 0)  && (y1 < 900 && y2 < 900))) {
			y1 = y1 - vel;
			y2 = y2 - vel;
		}
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//sans.moveIt(e.getKeyCode(), 600, 400);
		fighter.moveIt(e.getKeyCode(), 1440,900);
		repaint();
		
		if (e.getKeyCode() == 32) {
			Lasers laser = new Lasers(fighter.getxCoord(), fighter.getyCoord(), 20, 20, "sprites/laser.png");
			lasers.add(laser);
		}
		
		Rectangle ggrect = new Rectangle(fighter.getxCoord(),fighter.getyCoord(),fighter.getWidth(),fighter.getHeight()); 
		for (int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
			if (r.intersects(ggrect)) {
				badguys.remove(i);

			repaint();
			}
		repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
