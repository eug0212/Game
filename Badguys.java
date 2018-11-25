package Alien;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class Badguy {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	
		/**
	 * Goodguy default constructor
	 */
	public Badguy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg(".../File/spongebob.jpg");
	
	}
	
	/**
	 * Goodguy overloaded constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial height 
	 */
	public Badguy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
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
