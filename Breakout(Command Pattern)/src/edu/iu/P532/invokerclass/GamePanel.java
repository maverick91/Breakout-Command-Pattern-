package edu.iu.P532.invokerclass;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;

import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.Brick;
import edu.iu.P532.recieverclass.Paddle;

public class GamePanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Ball ball;
	Paddle paddle;
	Brick brick;
	public GamePanel(Ball ball,Paddle paddle,Brick brick) {
		this.ball = ball;
		this.paddle= paddle;
		this.brick=brick;
	}
	
	@Override
	public void paint(Graphics g) {
		ball.draw(g);
		paddle.draw(g);
		brick.draw((Graphics2D)g);
	}

}
