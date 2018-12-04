package Alien;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class Badguy implements ActionListener {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	
		/**
	 * Goodguy default constructor
		 * @param imgpath 
	 */
	
	/**
	 * Goodguy overloaded constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial height 
	 */
	
	public Badguy(int x, int y, int width, int height, String imgpath) {
		Random rand = new Random();
		int winWidth = this.getWidth();
		int winHeight = this.getHeight();
		int rx = rand.nextInt(winWidth);
		int ry = rand.nextInt(winHeight);
		setxCoord(x);
		setyCoord(y);
		setWidth(width);
		setHeight(height);
		setImg(imgpath);
	}
	public void willactuallymove() {
		Timer t = new Timer(5, this);
		if(this.getxCoord() > 500) {
			int speed = 1;
			int x = getxCoord();
			x = x - speed;
			setxCoord(x);
			setImg("sprites/badguy1.png");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(this.getxCoord() > 500) {
			int speed = 1;
			int x = getxCoord();
			x = x - speed;
			setxCoord(x);
			setImg("sprites/badguy1.png");
		}
		
	}

	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
}
