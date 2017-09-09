package edu.iu.P532.invokerclass;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.iu.P532.commandclass.Command;
import edu.iu.P532.commandclass.MoveBall;
import edu.iu.P532.recieverclass.Ball;



public class Main {

	public static final int WIDTH = 800, HEIGHT = 800;
	public static boolean play = true;	
	
	public static void main(String[] args) {
		Ball ball = new Ball();
		JFrame frame = new JFrame("Breakout");
		Command moveBallCommand = new MoveBall(ball);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		List<Command> listCommand = new ArrayList<Command>();
		GamePanel gamePanel = new GamePanel(ball);
		frame.add(gamePanel);
		frame.setVisible(true);
		JButton button = new JButton("undo");
		button.setPreferredSize(new Dimension(40, 40));
		
		button.setBackground(Color.blue);
		button.setBounds(900, 100, 40, 30);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Main.play=false;
				moveBallCommand.unexecute();
				gamePanel.repaint();
			}
		});
		frame.add(button);
	
		while (play) {
			moveBallCommand.execute();
			gamePanel.repaint();
		    gamePanel.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					//move paddle
					
				}
			});
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
