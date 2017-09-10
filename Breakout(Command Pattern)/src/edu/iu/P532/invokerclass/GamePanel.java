package edu.iu.P532.invokerclass;
import edu.iu.P532.recieverclass.Brick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import edu.iu.P532.recieverclass.GameConstants;
import edu.iu.P532.recieverclass.Paddle;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.iu.P532.commandclass.Command;
import edu.iu.P532.commandclass.MoveBall;
import edu.iu.P532.commandclass.MovePaddle;
import edu.iu.P532.recieverclass.Ball;

public class GamePanel extends JPanel  implements ActionListener{

	/**
	 * 
	 */
	private Brick brick;
	private Paddle paddle;
	private static final long serialVersionUID = 1L;
	MovePaddle movePaddleCommand;
	MoveBall moveBallCommand;
	Ball ball;
	public static boolean play = true;	

	
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
		 ball = new Ball();
		 brick = new Brick(GameConstants.NUM_ROWS,GameConstants.NUM_COLUMNS,GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT);
		 paddle = new Paddle(GameConstants.PADDLE_INITIAL_POSITION_X, GameConstants.PADDLE_INITIAL_POSITION_Y, GameConstants.PADDLE_WIDTH,GameConstants.PADDLE_HEIGHT);
		this.addKeyListener( paddle);
		 moveBallCommand = new MoveBall(ball);
		 movePaddleCommand = new MovePaddle(paddle);
	}

	@Override
	public void paint(Graphics g) {
		ball.draw(g);
		paddle.draw(g);
		brick.draw((Graphics2D)g);
		
	}
	
	
	public void startGame(){
		
		JButton start = new JButton("Start");
		start.setVisible(true);
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {}
		});
		
		JButton undo = new JButton("undo");
		
		undo.setPreferredSize(new Dimension(40, 40));
		
		
		undo.setBackground(Color.blue);
		undo.setBounds(100, 100, 40, 30);
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		JButton replay = new JButton("Start");
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {}
		});
		
		
		this.add(start);
		this.add(undo);
		this.add(replay);
		List<Command> listCommand = new ArrayList<Command>();

		while (play) {
			moveBallCommand.execute();
			movePaddleCommand.execute();
			this.repaint();
			
			 
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
