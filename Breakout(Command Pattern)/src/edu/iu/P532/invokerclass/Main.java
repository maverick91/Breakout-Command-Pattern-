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
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		List<Command> listCommand = new ArrayList<Command>();
		GamePanel gamePanel = new GamePanel(ball);
		frame.add(gamePanel);
		frame.setVisible(true);
		JButton button = new JButton("replay");
		button.setPreferredSize(new Dimension(40, 40));
		
		button.setBackground(Color.blue);
		button.setBounds(900, 100, 40, 30);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Main.play=false;
				//ball.setBallXloc(400);
				//ball.setBallYloc(200);
				
				
			}
		});
		frame.add(button);
	
		while (true) {
			if(play)
			{	
			Command moveBallCommand = new MoveBall(ball);
			moveBallCommand.execute();
			listCommand.add(moveBallCommand);
			gamePanel.repaint();
			}
			else
			{
				for (int i =0;i<=listCommand.size()-1;i++) 
				{
				  listCommand.get(i).unexecute();
				  gamePanel.repaint();
				  
				  try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
