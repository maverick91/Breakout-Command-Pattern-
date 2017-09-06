package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Graphics;
import edu.iu.P532.recieverclass.GameConstants;


public class Paddle  {
//private int xSpeed;

protected int paddleXPos;
protected int paddleYPos;
private int paddleWidth;
private int paddleHeight;

   // Constructor
   public Paddle(int paddleInitialPositionX, int paddleInitialPositionY, int paddleWidth, int paddleHeight) {
   	    this.paddleXPos = paddleInitialPositionX;
		this.paddleYPos = paddleInitialPositionY;
		this.paddleWidth = paddleWidth;
		this.paddleHeight = paddleHeight;			
   }

   // Draws the paddle
   public void draw(Graphics g) {
       g.setColor(Color.GREEN);
       g.fillRect(paddleXPos,paddleYPos,paddleWidth,paddleHeight);
   }
   
}
