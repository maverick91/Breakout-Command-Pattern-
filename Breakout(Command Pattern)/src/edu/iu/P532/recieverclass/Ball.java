package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import edu.iu.P532.recieverclass.GameConstants;



public class Ball {

	  public int getBallXloc() {
	return ballXloc;
	}
	public void setBallXloc(int ballXloc) {
	this.ballXloc = ballXloc;
	}
	public int getBallYloc() {
	return ballYloc;
	}
	public void setBallYloc(int ballYloc) {
	this.ballYloc = ballYloc;
	}
	public int getBallXdir() {
	return ballXdir;
	}
	public void setBallXdir(int ballXdir) {
	this.ballXdir = ballXdir;
	}
	public int getBallYdir() {
	return ballYdir;
	}
	public void setBallYdir(int ballYdir) {
	this.ballYdir = ballYdir;
	}
	  private int ballXloc ;
	  private int ballYloc ;
	  private int ballXdir ;
	  private int ballYdir ;
	  
	  
	  public Ball(){
	   ballXloc = 400;
	   ballYloc = 600;
	   ballXdir = 5;
	   ballYdir = 5;
	  }
		public void reset() {
			ballXloc = GameConstants.BALL_INITIAL_POSITION_X;
			ballYloc = GameConstants.BALL_INITIAL_POSITION_Y;
			ballXdir = GameConstants.BALL_SPEED_XDIR;
			ballYdir = GameConstants.BALL_SPEED_YDIR;
		}

	public void move()
	{
	if(ballXloc>=800-50|| ballXloc<=0)
	{
	ballXdir=-ballXdir;
	}

	if(ballYloc>=800-80||ballYloc<=0)
	{
	ballYdir=-ballYdir;
	}

	ballXloc = ballXloc+ballXdir;
	ballYloc = ballYloc+ballYdir;
	}
	  
     public Rectangle getBound()
     {
       return new Rectangle(ballXloc,ballYloc, 30, 30);
     }
	//Draws the Ball
	public void draw(Graphics g){
	g.setColor(Color.blue);
	       g.fillOval(ballXloc, ballYloc, 30,30);
	}
	}