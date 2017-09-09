package edu.iu.P532.invokerclass;
import edu.iu.P532.recieverclass.Brick;
import java.awt.Graphics;
import java.awt.Graphics2D;

import edu.iu.P532.recieverclass.GameConstants;
import edu.iu.P532.recieverclass.Paddle;

import java.awt.Panel;

import edu.iu.P532.recieverclass.Ball;

public class GamePanel extends Panel {

	/**
	 * 
	 */
	private Brick brick;
	private Paddle paddle;
	private static final long serialVersionUID = 1L;
	Ball ball;
	public GamePanel(Ball ball) {
		this.ball = ball;
		brick = new Brick(GameConstants.NUM_ROWS,GameConstants.NUM_COLUMNS,GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT);
		paddle = new Paddle(GameConstants.PADDLE_INITIAL_POSITION_X, GameConstants.PADDLE_INITIAL_POSITION_Y, GameConstants.PADDLE_WIDTH,GameConstants.PADDLE_HEIGHT);
	}
	
	@Override
	public void paint(Graphics g) {
		ball.draw(g);
		paddle.draw(g);
		brick.draw((Graphics2D)g);
		
	}

}
