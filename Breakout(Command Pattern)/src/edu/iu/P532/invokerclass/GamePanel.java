package edu.iu.P532.invokerclass;

import java.awt.Graphics;
import java.awt.Panel;

import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.Paddle;

public class GamePanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Ball ball;
	Paddle paddle;
	public GamePanel(Ball ball,Paddle paddle) {
		this.ball = ball;
		this.paddle= paddle;
	}
	
	@Override
	public void paint(Graphics g) {
		ball.draw(g);
		paddle.draw(g);
	}

}
