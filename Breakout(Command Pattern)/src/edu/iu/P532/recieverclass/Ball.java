package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Graphics;

import edu.iu.P532.recieverclass.GameConstants;

public class Ball {
	
   private int ballXloc = 400;
   private int ballYloc = 200;
   private int ballXdir = 2;
   private int ballYdir = 2;
   
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
   
	public void unmove()
	{
		if(ballXloc>=800-50|| ballXloc<=0)
		{
			ballXdir=-ballXdir;
		}
		
		if(ballYloc>=800-80||ballYloc<=0)
		{
			ballYdir=-ballYdir;
		}
		ballXloc = ballXloc-ballXdir;
		ballYloc = ballYloc-ballYdir;
	}
	//Draws the Ball
	public void draw(Graphics g){
		g.setColor(Color.blue);
        g.fillOval(ballXloc, ballYloc, 30,30);
	}
}
