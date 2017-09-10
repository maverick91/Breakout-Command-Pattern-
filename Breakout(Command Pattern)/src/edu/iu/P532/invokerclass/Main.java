package edu.iu.P532.invokerclass;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.iu.P532.commandclass.Command;
import edu.iu.P532.commandclass.MoveBall;
import edu.iu.P532.commandclass.MovePaddle;
import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.Brick;
import edu.iu.P532.recieverclass.GameConstants;
import edu.iu.P532.recieverclass.Paddle;



public class Main {

	public static final int WIDTH = 800, HEIGHT = 800;
	public static boolean play = true;	
	//Ball ball;
	/*int totalBricks= GameConstants.NUM_ROWS * GameConstants.NUM_COLUMNS;
	Brick brick = new Brick(GameConstants.NUM_ROWS,GameConstants.NUM_COLUMNS,GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT);
void checkCollision(){
		
	checkBrickCollision();
	}
	
	void checkBrickCollision(){
		A:for(int i=0; i < brick.getNumRows(); i++){
			for(int j=0; j< brick.getNumCols(); j++){
				if(brick.bricks[i][j] == true ){
					int brickX = j*brick.getBrickWidth() + 50;
					int brickY = i*brick.getBrickHeight() + 70;
					int brickWidth = brick.getBrickWidth();
					int brickHeight = brick.getBrickHeight();
					
					Rectangle rect = new Rectangle(brickX,brickY, brickWidth, brickHeight);
					Rectangle ballRect = new Rectangle(ball.getBallXloc(),ball.getBallYloc(),40,40);
					Rectangle brickRect = rect;
					
					if(ballRect.intersects(brickRect)){
					
						brick.setXbrick(i);
						brick.setYbrick(j);
						totalBricks--;
						//score += 5;
					
					
						if(ball.getBallXloc()+39 <= brickRect.x || ball.getBallXloc()+1 >=( brickRect.x + brickRect.width) ){
							ball.setBallXdir(-ball.getBallXdir());
						}
						else{
							ball.setBallYdir(-ball.getBallYdir());						}
						break A;
					}
					
				}
			}
			
		}
	}*/
	public static void main(String[] args) {
		Ball ball = new Ball();
		Paddle paddle = new Paddle(GameConstants.PADDLE_INITIAL_POSITION_X, GameConstants.PADDLE_INITIAL_POSITION_Y, GameConstants.PADDLE_WIDTH, GameConstants.PADDLE_HEIGHT);
		JFrame frame = new JFrame("Breakout");
		Brick brick = new Brick(GameConstants.NUM_ROWS,GameConstants.NUM_COLUMNS,GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		List<Command> listCommand = new ArrayList<Command>();
		GamePanel gamePanel = new GamePanel(ball,paddle,brick);
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
				Command movePaddleCommand = new MovePaddle(paddle);
				if(e.getKeyCode()==37)
				{	
				 paddle.setPaddleDir(-5);
				 movePaddleCommand.execute();
				 System.out.println(paddle.getPaddleDir());
				}
				else if(e.getKeyCode()==39) 
				{
					paddle.setPaddleDir(5);
					movePaddleCommand.execute();
					System.out.println(paddle.getPaddleDir());
				}
			}
		});
		while (true) {
			if(play)
			{	
			Command moveBallCommand = new MoveBall(ball);
			moveBallCommand.execute();
			listCommand.add(moveBallCommand);
			
			if(paddle.getBound().intersects(ball.getBound()))
			{
				
				ball.setBallYdir(-ball.getBallYdir());
			}
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
