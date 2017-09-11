package edu.iu.P532.invokerclass;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;

import org.apache.log4j.Logger;

import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.Brick;
import edu.iu.P532.recieverclass.Paddle;
import edu.iu.P532.recieverclass.Timer;

public class GamePanel extends Panel {

	/**
	 * 
	 */
	final static Logger logger = Logger.getLogger(GamePanel.class);
	private static final long serialVersionUID = 1L;
	Ball ball;
	Paddle paddle;
	Brick brick;
	Timer timer;
	public GamePanel(Ball ball,Paddle paddle,Brick brick,Timer timer) {
		this.ball = ball;
		this.paddle= paddle;
		this.brick=brick;
		this.timer=timer;
	}
	
	@Override
	public void paint(Graphics g) {
		logger.info("Painting the components");
		ball.draw(g);
		paddle.draw(g);
		brick.draw((Graphics2D)g);
		timer.draw(g);
	}

}
