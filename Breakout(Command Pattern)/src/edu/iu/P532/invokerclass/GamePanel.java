package edu.iu.P532.invokerclass;

import java.awt.Graphics;
import java.awt.Panel;

import edu.iu.P532.recieverclass.Ball;

public class GamePanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Ball ball;
	public GamePanel(Ball ball) {
		this.ball = ball;
	}
	
	@Override
	public void paint(Graphics g) {
		ball.draw(g);
	}

}
