package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import edu.iu.P532.recieverclass.GameConstants;


public class Paddle{


private int paddleXPos;
private int paddleDir;
private int paddleYPos;
private int paddleWidth;
private int paddleHeight;

public Paddle(int paddleInitialPositionX, int paddleInitialPositionY, int paddleWidth, int paddleHeight) 
{
		this.paddleXPos = paddleInitialPositionX;
		this.paddleYPos = paddleInitialPositionY;
		this.paddleWidth = paddleWidth;
		this.paddleHeight = paddleHeight;	
}

public void setDirection(Event e) {
	if(e.equals(Event.LEFT))
		paddleDir=-5;
	if(e.equals(Event.RIGHT))
		paddleDir=5;	
}

public void move() {
	
	paddleXPos  = paddleXPos +paddleDir;
}

public void unmove() {
	
	paddleXPos  = paddleXPos -paddleDir;
}

public void draw(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(paddleXPos,paddleYPos,paddleWidth,paddleHeight);
}




}
