package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements KeyListener, ActionListener{
	
	private boolean play = false;
	private Ball ball;
	private Paddle paddle;
	private Timer timer;
	private int delay = 8;
	//private Brick brick;
	//the constructor 
	public GamePanel()
	{
		init();
		addKeyListener(this);
		setFocusable(true);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	
	//for initializing variables
	public void init()
	{
		//play = true;
		ball = new Ball(GameConstants.BALL_INITIAL_POSITION_X, GameConstants.BALL_INITIAL_POSITION_Y, GameConstants.BALL_RADIUS);
		//paddle = new Paddle(GameConstants.PADDLE_INITIAL_POSITION_X, GameConstants.PADDLE_INITIAL_POSITION_Y, GameConstants.PADDLE_WIDTH,GameConstants.PADDLE_HEIGHT);
	}

	
	
	public void paint(Graphics g)
	{
		
		//background color for the panel
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 800);
		
		
		//drawing ball
		ball.draw(g);
		
		//drawing paddle
		paddle.draw(g);
		
		g.dispose();
		
	}
	
	
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		        
		        // if player hits the Right key
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					//Making sure the paddle doesn't go outside the panel
					if(paddle.paddleXPos >= 660){
						paddle.paddleXPos = 683;
					}else {
						movePaddleRight();
					}
					
				}
				
				// if player hits the Left key
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					//Making sure the paddle doesn't go outside the panel
					if(paddle.paddleXPos <= 30){
						paddle.paddleXPos = 3;
					}else {
						movePaddleLeft();
					}
					
				}	
		
	}
	
	



    // Implementations for the functions movePaddleLeft() & movePaddleRight()
    //to move the paddle right
	public void movePaddleRight() {
		play = true;
		paddle.paddleXPos += 25;
	}

	//to move the paddle left
	public void movePaddleLeft() {
		play = true;
		paddle.paddleXPos -= 25;
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
	timer.start();
	
	if(play) {
		//To accomodate for the ball moment
		
	}
	
	
	
	
	
	//repaint() is called everytime to re-draw the GUI everytime the paddle moves to a new place
	repaint();
		
	}
	
	
	
}