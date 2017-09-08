package edu.iu.P532.recieverclass;

import javax.swing.JFrame;



public class Main {

	public static final int WIDTH = 800, HEIGHT = 800;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Breakout");
		
		
		GamePanel panel = new GamePanel();
		
		
		//For Centering the window on the screen
		frame.setLocationRelativeTo(null);
		
		//setting the size of the frame
		frame.setSize(WIDTH, HEIGHT);
		
		//adding the Jpanel to the Frame
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		
	}
	
}
