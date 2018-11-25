package Alien;
import javax.swing.JFrame;

public class MyScreen extends JFrame {
	
	public MyScreen() {
		//This is the current instance, setters are mutators methods which change properties
		
		this.setSize(1440,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Alien Math Invaders");
		
	}
	
	public static void main(String[] args) {
		MyScreen mainScreen = new MyScreen();
		MyCanvas mainCanvas = new MyCanvas();
		mainScreen.getContentPane().add(mainCanvas);		
		}
}
