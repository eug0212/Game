package Alien;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 


public class MyCanvas extends Canvas implements KeyListener, MouseListener{
	 // global variables - accessible in all methods
	Goodguy fighter = new Goodguy(300, 400, 60, 60,"sprites/fighter.png");
	Background gameBackground = new Background (0,0,1440,900, "sprites/background.jpeg");
	Objects loseScreen = new Objects(0, 0, 1440, 900, "sprites/gameOver.jpeg");
	Objects winnerScreen = new Objects(0, 0, 1440, 900, "sprites/winnerScreen.jpeg");

	Objects heart = new Objects(20,800, 50, 50, "sprites/heart.png");
	Objects boss = new Objects(5000, 400, 500, 500, "sprites/boss.png");
	Objects powerup = new Objects(3000,400,100,100, "sprites/powerup.gif");
	Objects coins = new Objects(4000,400,100,100, "sprites/powerup1.png");
	LinkedList badguys = new LinkedList();
	LinkedList lasers = new LinkedList();
	boolean gameOver = false;
	boolean didHit = false;
	boolean didHit2 = false;
	boolean alive = true;
	boolean winner = false;
	public static int health = 200;
	public static int bossHealth = 500;
	public static int delay = 2500;
	public static long period = 80L;
	public static int bulletSizew = 15;
	public static int bulletSizeh = 15;
	public int points = 5;

//	public static enum DIFFICULTY {
//		EASY,
//		MEDIUM,
//		HARD;
//	};
//	public static DIFFICULTY Difficulty;
    
	
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
				this.addMouseListener(this);
				menu = new Menu();
				
//						playIt("music/Undertale.wav");
//						if (gameOver) {
//							playIt("music/GameOver.wav");
//						}
						Random rand = new Random();
						int winWidth = this.getWidth();
						int winHeight = this.getHeight();
						for (int i = 0; i < 30; i++) {
							int rx = rand.nextInt(winWidth);
							int ry = rand.nextInt(winHeight-200);
							Badguy bg = new Badguy(rx + delay, ry, 60, 60, "sprites/badguy1.png");
							Badguy bg2 = new Badguy(rx + delay*2, ry, 60, 60, "sprites/badguy2.png");
							Badguy bg3 = new Badguy(rx + delay*3, ry, 60, 60, "sprites/badguy3.png");
							
							Badguy bg4 = new Badguy(rx + delay*4, ry, 60, 60, "sprites/badguy1.png");
							Badguy bg5 = new Badguy(rx + delay*4, ry, 60, 60, "sprites/badguy2.png");
							Badguy bg6 = new Badguy(rx + delay*4, ry, 60, 60, "sprites/badguy3.png");
							
							Badguy bg7 = new Badguy(rx + delay*5, ry, 60, 60, "sprites/badguy1.png");
							Badguy bg8 = new Badguy(rx + delay*5, ry, 60, 60, "sprites/badguy2.png");
							Badguy bg9 = new Badguy(rx + delay*5, ry, 60, 60, "sprites/badguy3.png");
							
							Badguy bg10 = new Badguy(rx + delay*6, ry, 60, 60, "sprites/badguy1.png");
							Badguy bg11 = new Badguy(rx + delay*6, ry, 60, 60, "sprites/badguy2.png");
							Badguy bg12 = new Badguy(rx + delay*6, ry, 60, 60, "sprites/badguy3.png");
						
							Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),100,100);
							Rectangle r2 = new Rectangle(bg2.getxCoord(),bg2.getyCoord(),100,100);
							Rectangle r3 = new Rectangle(bg3.getxCoord(),bg3.getyCoord(),100,100);
							Rectangle r4 = new Rectangle(bg4.getxCoord(),bg4.getyCoord(),100,100);
							Rectangle r5 = new Rectangle(bg5.getxCoord(),bg5.getyCoord(),100,100);
							Rectangle r6 = new Rectangle(bg6.getxCoord(),bg6.getyCoord(),100,100);
							Rectangle r7 = new Rectangle(bg7.getxCoord(),bg7.getyCoord(),100,100);
							Rectangle r8 = new Rectangle(bg8.getxCoord(),bg8.getyCoord(),100,100);
							Rectangle r9 = new Rectangle(bg9.getxCoord(),bg9.getyCoord(),100,100);
							Rectangle r10 = new Rectangle(bg10.getxCoord(),bg10.getyCoord(),100,100);
							Rectangle r11 = new Rectangle(bg11.getxCoord(),bg11.getyCoord(),100,100);
							Rectangle r12 = new Rectangle(bg12.getxCoord(),bg12.getyCoord(),100,100);

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
							if (r4.intersects(gg)) {
								badguys.remove(i);
							}
							if (r5.intersects(gg)) {
								badguys.remove(i);
							}
							if (r6.intersects(gg)) {
								badguys.remove(i);
							}
							if (r7.intersects(gg)) {
								badguys.remove(i);
							}
							if (r8.intersects(gg)) {
								badguys.remove(i);
							}
							if (r9.intersects(gg)) {
								badguys.remove(i);
							}
							if (r10.intersects(gg)) {
								badguys.remove(i);
							}
							if (r11.intersects(gg)) {
								badguys.remove(i);
							}
							if (r12.intersects(gg)) {
								badguys.remove(i);
							}
							badguys.add(bg);
							badguys.add(bg2);
							badguys.add(bg3);
							badguys.add(bg4);
							badguys.add(bg5);
							badguys.add(bg5);
							badguys.add(bg6);
							badguys.add(bg8);
							badguys.add(bg9);
							badguys.add(bg10);
							badguys.add(bg11);
							badguys.add(bg12);


						}
						TimerTask wave1 = new TimerTask() {
							
							public void run() {
								if (!gameOver && !winner) {
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
				        
					TimerTask wave2 = new TimerTask() {

						public void run() {
							if (boss.getxCoord() >= 1440) {
								boss.setxCoord(boss.getxCoord() - 5);
							}
							if (boss.getxCoord() < 1440) {
								boss.setyCoord(boss.getyCoord() - 1);
								boss.setxCoord(boss.getxCoord() - 5);
							}
							if (boss.getxCoord() <= 300) {
								boss.setxCoord(boss.getxCoord() + 10);
								boss.setyCoord(boss.getyCoord() + 3);

							}
						}
						
					};
			        timer.scheduleAtFixedRate(wave2, delay, period);		 
			        
			        TimerTask wave3 = new TimerTask() {

						public void run() {
							if (powerup.getxCoord() >= 1440) {
								powerup.setxCoord(powerup.getxCoord() - 5);
							}
							if (powerup.getxCoord() < 1440) {
								powerup.setyCoord(powerup.getyCoord() -3);
								powerup.setxCoord(powerup.getxCoord() - 5);

							}
							if (powerup.getyCoord() <= 300) {
								powerup.setyCoord(powerup.getyCoord() + 3);
								powerup.setxCoord(powerup.getxCoord() - 5);
							}
							if (powerup.getyCoord() >= 600) {
								powerup.setyCoord(powerup.getyCoord() - 3);
								powerup.setxCoord(powerup.getxCoord() - 5);
							}
						}
						
					};
			        timer.scheduleAtFixedRate(wave3, delay, period);		
			        
			        TimerTask wave4 = new TimerTask() {

						public void run() {
							if (coins.getxCoord() >= 1440) {
								coins.setxCoord(coins.getxCoord() - 5);
							}
							if (coins.getxCoord() < 1440) {
								coins.setyCoord(coins.getyCoord() -3);
								coins.setxCoord(coins.getxCoord() - 5);

							}
							if (coins.getyCoord() <= 300) {
								coins.setyCoord(coins.getyCoord() + 3);
								coins.setxCoord(coins.getxCoord() - 5);
							}
							if (coins.getyCoord() >= 600) {
								coins.setyCoord(coins.getyCoord() - 3);
								coins.setxCoord(coins.getxCoord() - 5);
							}
						}
						
					};
			        timer.scheduleAtFixedRate(wave4, delay, period);		

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
					if (!gameOver && !winner)	{
						Rectangle ggr = new Rectangle(fighter.getxCoord(), fighter.getyCoord(), fighter.getWidth(), fighter.getHeight());
						Rectangle br = new Rectangle(boss.getxCoord(), boss.getyCoord(), boss.getWidth(), boss.getHeight());

						g.drawImage(gameBackground.getImg(), gameBackground.getxCoord(), gameBackground.getyCoord(), gameBackground.getWidth(),gameBackground.getHeight(), this );
						g.drawImage(fighter.getImg(), fighter.getxCoord(), fighter.getyCoord(),fighter.getWidth(), fighter.getHeight(), this);
						if (alive) {
							g.drawImage(boss.getImg(), boss.getxCoord(), boss.getyCoord(), boss.getWidth(), boss.getHeight(), this);
						}
						if (bossHealth <= 0) {
							alive = false;
							winner = true;
						}
						if (!didHit) {
							g.drawImage(powerup.getImg(), powerup.getxCoord(), powerup.getyCoord(), powerup.getWidth(), powerup.getHeight(), this);
						}
						if (!didHit2) {
							g.drawImage(coins.getImg(), coins.getxCoord(), coins.getyCoord(), coins.getWidth(), coins.getHeight(), this);
							Rectangle c = new Rectangle(coins.getxCoord(), coins.getyCoord(), coins.getWidth(), coins.getHeight());
						}
						Rectangle p2 = new Rectangle(powerup.getxCoord(), powerup.getyCoord(), powerup.getWidth(), powerup.getHeight());
						Rectangle c = new Rectangle(coins.getxCoord(), coins.getyCoord(), 1, coins.getHeight());

						if (br.intersects(ggr)) {
							health = 0;
							gameOver = true;
						}
						if (p2.intersects(ggr)) {
							health = 200;
							didHit = true;
							
						}
						if (c.intersects(ggr)) {
							points = points + 1;
							didHit2 = true;
							
						}
						repaint();
						
						
						for (int i = 0; i < badguys.size(); i++) {
							Badguy bg = (Badguy) badguys.get(i);
							g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
							Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
							
							if (ggr.intersects(r)) {
								badguys.remove(i);
								health = health - 20;
								if (health == 0) {
									gameOver = true;
								}
							}repaint();
								for (int j = 0; j < lasers.size(); j++) {
									Lasers k = (Lasers) lasers.get(j);								
									if (k.getxCoord() > this.getWidth()) { lasers.remove(k);}
										k.setxCoord(k.getxCoord() + 1);
										g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth() + bulletSizew, k.getHeight() + bulletSizeh, this);
										
										Rectangle kr = new Rectangle(k.getxCoord(), k.getyCoord(), k.getWidth() + 40 + bulletSizew, k.getHeight() + 90 + bulletSizeh);		
										if (k.getxCoord() > 1500) {
											lasers.remove(i);
										}
										if (kr.intersects(r)) {
											badguys.remove(i);
											lasers.remove(i);
											points++;
										}
										if (gameOver) {
											lasers.remove(i);
											badguys.remove(i);
										}
										if (kr.intersects(br)) {
											badguys.remove(i);
											lasers.remove(i);
											bossHealth = bossHealth - 10;
										}
//										if (bg.getxCoord() <= 0) {
//											badguys.remove(i);
//										}
								}repaint();
						
						}
						g.setColor(Color.gray);
						g.fillRect(30, 5, 200, 50);
	
						g.setColor(Color.green);
						g.fillRect(30, 5, health, 50);
						
						g.setColor(Color.gray);
						g.drawRect(30, 5, 200, 50);
						
						Font fnt1 = new Font("arial", Font.BOLD, 30);
						g.setFont(fnt1);
						g.drawString("HP", 5, 20);
						
						g.drawString("Points: " + points, 0, 80);
						
						g.drawString("Power Ups", 5, 800);
						
						g.drawString("Boss health: " + bossHealth, 800, 50);
						
						g.drawImage(heart.getImg(), heart.getxCoord(), heart.getyCoord(), heart.getWidth(), heart.getHeight(), this);
						repaint();	
						}
		
						if(gameOver) {
						g.drawImage(loseScreen.getImg(), loseScreen.getxCoord(), loseScreen.getyCoord(), loseScreen.getWidth(), loseScreen.getHeight(), this);
						}
						if(winner) {
							g.drawImage(winnerScreen.getImg(), winnerScreen.getxCoord(), winnerScreen.getyCoord(), winnerScreen.getWidth(), winnerScreen.getHeight(), this);
						}
					}else if (State == STATE.MENU) {
						menu.paint(g);
					}			
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void keyPressed(KeyEvent e) {
				if (State == STATE.GAME) {	 
					fighter.moveIt(e.getKeyCode(), 1350,850);

					repaint();
					
					if (e.getKeyCode() == 32) {
							Lasers laser = new Lasers(fighter.getxCoord(), fighter.getyCoord() + 25, bulletSizew, bulletSizeh, "sprites/laser.png");
							lasers.add(laser);
					}
					
					Rectangle ggrect = new Rectangle(fighter.getxCoord(),fighter.getyCoord(),fighter.getWidth(),fighter.getHeight()); 
					for (int i = 0; i < badguys.size(); i++) {
						Badguy bg = (Badguy) badguys.get(i);
						
						Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth() + 50, bg.getHeight() + 50);
						if (ggrect.intersects(r)) {
							badguys.remove(i);
							health = health - 20;
							if (health == 0) {
								gameOver = true;
							}
						}
					}	
					repaint();
				} 
				
			}
		
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getY() >= heart.getyCoord() && e.getY() <= heart.getyCoord() + heart.getHeight() && e.getX() >= heart.getxCoord() && e.getX() <= heart.getxCoord() + heart.getWidth() && points >= 2) {
					points = points - 2;
					health = 200;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
}



	
