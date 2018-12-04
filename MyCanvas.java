package Alien;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 


public class MyCanvas extends Canvas implements KeyListener{
	 // global variables - accessible in all methods
	Goodguy fighter = new Goodguy(300, 400, 60, 60,"sprites/fighter.png");
	Background gameBackground = new Background (0,0,1440,900, "sprites/background.jpeg");
	Objects life1 = new Objects (20, 800, 40, 40, "sprites/fighter.png");
	Objects life2 = new Objects (65, 800, 40, 40, "sprites/fighter.png");
	Objects loseScreen = new Objects(0, 0, 1440, 900, "sprites/gameOver.jpeg");
	LinkedList badguys = new LinkedList();
	LinkedList lasers = new LinkedList();
	boolean gameOver = false;
	public static int health = 100;
	public static long period = 100L;
	public static int bulletSizew = 5;
	public static int bulletSizeh = 30;
	public static int points = 0;


    
	public static enum STATE {
		MENU,
		GAME;
	};
	
	public static STATE State = STATE.MENU;	
	private Menu menu;

		
			public MyCanvas() {
				this.setSize(1440,900); 
				this.addKeyListener(this); 
				this.addKeyListener(new KeyPressed());
				menu = new Menu();
				
				
					if (!gameOver) {	
						playIt("music/Undertale.wav");
					} else if (gameOver) {
						playIt("music/GameOver.wav");
					}
						Random rand = new Random();
						int winWidth = this.getWidth();
						int winHeight = this.getHeight();
						for (int i = 0; i < 70; i++) {
							int rx = rand.nextInt(winWidth);
							int ry = rand.nextInt(winHeight);
							Badguy bg = new Badguy(rx + 2500, ry, 60, 60, "sprites/badguy1.png");
							Badguy bgx = new Badguy(rx + 10000, ry, 60, 60, "sprites/badguy1.png");
							Badguy bg2x = new Badguy(rx + 10000, ry, 60, 60, "sprites/badguy2.png");
							Badguy bg3x = new Badguy(rx + 10000, ry, 60, 60, "sprites/badguy3.png");

							Badguy bg2 = new Badguy(rx + 5000, ry, 60, 60, "sprites/badguy2.png");
							Badguy bg3 = new Badguy(rx + 7500, ry, 60, 60, "sprites/badguy3.png");

							
							Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),100,100);
							Rectangle r2 = new Rectangle(bg.getxCoord(),bg.getyCoord(),100,100);
							Rectangle r3 = new Rectangle(bg.getxCoord(),bg.getyCoord(),100,100);

							Rectangle gg = new Rectangle(fighter.getxCoord(),fighter.getyCoord(),fighter.getWidth(),fighter.getHeight());	
							if (r.intersects(gg)) {
								badguys.remove(i);
							}
							if (r2.intersects(gg)) {
								badguys.remove(i);
							}
							if (r3.intersects(gg)) {
								badguys.remove(i);
							}
							badguys.add(bg);
							badguys.add(bg2);
							badguys.add(bg3);
							badguys.add(bgx);
							badguys.add(bg2x);
							badguys.add(bg3x);

						}
						TimerTask wave1 = new TimerTask() {
							
							public void run() {
								if (!gameOver) {
									for(int i = 0; i < badguys.size(); i++) {// draw bad guys
					                    Badguy bg = (Badguy) badguys.get(i);
					        			Random rand = new Random();
					        			int flightPattern = rand.nextInt(6);
					                   
					        			if (bg.getxCoord() >= 1440) {
					        				bg.setxCoord(bg.getxCoord() - 20);
					        			}
					        			if (bg.getxCoord() <= 1440) {
					                    	if (flightPattern == 0) {
					                    	bg.setxCoord(bg.getxCoord() - 20);	
					                    	} else if (flightPattern == 1) {
						                    	bg.setxCoord(bg.getxCoord() - 20);	
						                    	bg.setyCoord(bg.getyCoord() + 20);
					                    	}  else if (flightPattern == 2) {
						                    	bg.setxCoord(bg.getxCoord() - 20);	
						                    	bg.setyCoord(bg.getyCoord() + 10);
					                    	}
					                    	else if (flightPattern == 3) {
						                    	bg.setxCoord(bg.getxCoord() - 20);	
						                    	bg.setyCoord(bg.getyCoord() + 20);
						                    	if(bg.getxCoord() <= 0) {
						                    		bg.setxCoord(bg.getxCoord()+20);
						                    	}
					                    	}
						                 	else if (flightPattern == 4) {
						                    	bg.setxCoord(bg.getxCoord() - 20);	
						                    	bg.setyCoord(bg.getyCoord() - 20);
						                    	if(bg.getxCoord() <= 0) {
						                    		bg.setxCoord(bg.getxCoord()+7);
						                    	}
					                    	}else if (flightPattern == 5) {
						                    	bg.setxCoord(bg.getxCoord() - 20);	
						                    	bg.setyCoord(bg.getyCoord() - 20);
						                    	if(bg.getxCoord() <= 0) {
						                    		bg.setxCoord(bg.getxCoord()+10);
						                    	}
					                    	}
					                    }	
					                repaint();
									} 
								}
							}
			        };
			        	Timer timer = new Timer("Timer"); 
				        long delay  = 10L;
				        timer.scheduleAtFixedRate(wave1, delay, period);		
				        
				        
				    	
						//TimerTask wave2 = new TimerTask() {
//							
//							public void run() {
//								if (!gameOver) {
//									for(int i = 0; i < badguys2.size(); i++) {// draw bad guys
//					                    Badguy bg = (Badguy) badguys2.get(i);
//					        			Random rand = new Random();
//					        			int flightPattern = rand.nextInt(6);
//					                   
//					        			if (bg.getxCoord() >= 1440) {
//					        				bg.setxCoord(bg.getxCoord() - 20);
//					        			}
//					        			if (bg.getxCoord() <= 1440) {
//					                    	if (flightPattern == 0) {
//					                    	bg.setxCoord(bg.getxCoord() - 20);	
//					                    	} else if (flightPattern == 1) {
//						                    	bg.setxCoord(bg.getxCoord() - 20);	
//						                    	bg.setyCoord(bg.getyCoord() + 20);
//					                    	}  else if (flightPattern == 2) {
//						                    	bg.setxCoord(bg.getxCoord() - 20);	
//						                    	bg.setyCoord(bg.getyCoord() + 10);
//					                    	}
//					                    	else if (flightPattern == 3) {
//						                    	bg.setxCoord(bg.getxCoord() - 20);	
//						                    	bg.setyCoord(bg.getyCoord() + 20);
//						                    	if(bg.getxCoord() <= 0) {
//						                    		bg.setxCoord(bg.getxCoord()+20);
//						                    	}
//					                    	}
//						                 	else if (flightPattern == 4) {
//						                    	bg.setxCoord(bg.getxCoord() - 20);	
//						                    	bg.setyCoord(bg.getyCoord() - 20);
//						                    	if(bg.getxCoord() <= 0) {
//						                    		bg.setxCoord(bg.getxCoord()+7);
//						                    	}
//					                    	}else if (flightPattern == 5) {
//						                    	bg.setxCoord(bg.getxCoord() - 20);	
//						                    	bg.setyCoord(bg.getyCoord() - 20);
//						                    	if(bg.getxCoord() <= 0) {
//						                    		bg.setxCoord(bg.getxCoord()+10);
//						                    	}
//					                    	}
//					                    }	
//					                repaint();
//									} 
//								}
//							}
//			        };
//			        	Timer timer2 = new Timer("Timer"); 
//				        timer2.scheduleAtFixedRate(wave1, delay, period);	
			}		
						
				
			
			 
			 
			
			public void playIt(String musicPath) {
					try {
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicPath).getAbsoluteFile());
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
					} catch(Exception ex) {
						System.out.println("Error with playing sound.");
						ex.printStackTrace();
					}
			}
			
			@Override
			public void paint (Graphics g) {
				if (State == STATE.GAME) {
					g.drawImage(gameBackground.getImg(), gameBackground.getxCoord(), gameBackground.getyCoord(), gameBackground.getWidth(),gameBackground.getHeight(), this );
					g.drawImage(fighter.getImg(), fighter.getxCoord(), fighter.getyCoord(),fighter.getWidth(), fighter.getHeight(), this);
					
					for (int i = 0; i < badguys.size(); i++) {
						Badguy bg = (Badguy) badguys.get(i);
						g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
						Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
						
						for (int j = 0; j < lasers.size(); j++) {
							Lasers k = (Lasers) lasers.get(j);
							if (k.getxCoord() > this.getWidth()) { lasers.remove(k);}
								k.setxCoord(k.getxCoord() + 1);
								g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth() + 10, k.getHeight() + 10, this);
								
								Rectangle kr = new Rectangle(k.getxCoord(), k.getyCoord(), k.getWidth() + 50, k.getHeight() + 50);		
								if (k.getxCoord() > 1500) {
									lasers.remove(i);
								}
								if (kr.intersects(r)) {
									badguys.remove(i);
									lasers.remove(i);
									points = points + 1;
								}
								if (gameOver) {
									lasers.remove(i);
									badguys.remove(i);
								}
							repaint();
						}
					}
					g.setColor(Color.gray);
					g.fillRect(30, 5, 100, 50);

					g.setColor(Color.green);
					g.fillRect(30, 5, health, 50);
					
					g.setColor(Color.gray);
					g.drawRect(30, 5, 100, 50);
					
					Font fnt1 = new Font("arial", Font.BOLD, 30);
					g.setFont(fnt1);
					g.drawString("HP", 5, 20);
					
					g.drawString(String.valueOf(points), 5, 50);
					
					g.drawString("Power Ups", 5, 800);

		
					if(gameOver) {
						g.drawImage(loseScreen.getImg(), loseScreen.getxCoord(), loseScreen.getyCoord(), loseScreen.getWidth(), loseScreen.getHeight(), this);
					}
				} else if (State == STATE.MENU) {
					menu.paint(g);
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
				if (State == STATE.GAME) {	
					fighter.moveIt(e.getKeyCode(), 1440,900);
					repaint();
					
					if (e.getKeyCode() == 32) {
						Lasers laser = new Lasers(fighter.getxCoord(), fighter.getyCoord() + 25, bulletSizew, bulletSizeh, "sprites/laser.png");
						lasers.add(laser);
					}
					
					Rectangle ggrect = new Rectangle(fighter.getxCoord(),fighter.getyCoord(),fighter.getWidth(),fighter.getHeight()); 
					for (int i = 0; i < 1000; i++) {
						Badguy bg = (Badguy) badguys.get(i);
						
						Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
						if (r.intersects(ggrect)) {
							badguys.remove(i);
							health = health - 20;
							if (health == 0) {
								gameOver = true;
							}
						repaint();
						}
					repaint();
					}	
				} 
				
			}
		
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
}



	
