package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Graphics;

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
	    ballYloc = 200;
	    ballXdir = 2;
	    ballYdir = 2;
   }
    public void checkBound() {
    	
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
   
//	public void unmove()
//	{
//		if(ballXloc>=800-50|| ballXloc<=0)
//		{
//			ballXdir=-ballXdir;
//		}
//		
//		if(ballYloc>=800-80||ballYloc<=0)
//		{
//			ballYdir=-ballYdir;
//		}
//		ballXloc = ballXloc-ballXdir;
//		ballYloc = ballYloc-ballYdir;
//	}
	//Draws the Ball
	public void draw(Graphics g){
		g.setColor(Color.blue);
        g.fillOval(ballXloc, ballYloc, 30,30);
	}
}
