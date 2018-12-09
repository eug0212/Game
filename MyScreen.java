package Alien;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;


public class MyScreen extends JFrame {
	
	private GraphicsDevice vc;
	
	public MyScreen() {
//		//give vc access to monitor screen
//		//in order to get rid of flickering and lag
//		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		vc = e.getDefaultScreenDevice();
		
		this.setSize(1440,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Alien Invaders");
		
	}
	
	//get all compatible display modes
//	public DisplayMode[] getCompatibleDisplayModes() {
//		return vc.getDisplayModes();
//	}
	
	public static void main(String[] args) {
		MyScreen mainScreen = new MyScreen();
		MyCanvas mainCanvas = new MyCanvas();
		mainScreen.getContentPane().add(mainCanvas);		
		}
}
