package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Graphics;

import edu.iu.P532.recieverclass.GameConstants;

public class Ball {
	protected int ballposX ;
	protected int ballposY ;
	private int ballRadius;
	protected int ballXdir = GameConstants.BALL_SPEED_XDIR;
	protected int ballYdir = GameConstants.BALL_SPEED_XDIR;

	
	//Constructor for the Ball
	public Ball(int ballInitialPositionX, int ballInitialPositionY, int ballRadius) {
		this.ballposX = ballInitialPositionX;
		this.ballposY = ballInitialPositionY;
		this.ballRadius = ballRadius;
	}
	
	
	public int getBallposX() {
		return ballposX;
	}


	public void setBallposX(int ballposX) {
		this.ballposX = ballposX;
	}
	
	public int getBallposY() {
		return ballposY;
	}


	public void setBallposY(int ballposY) {
		this.ballposY = ballposY;
	}


	//Draws the Ball
	public void draw(Graphics g){
		g.setColor(Color.RED);
        g.fillOval(ballposX, ballposY, ballRadius, ballRadius);
	}
}
