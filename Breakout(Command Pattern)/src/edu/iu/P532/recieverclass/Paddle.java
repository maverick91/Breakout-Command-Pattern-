package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
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
public void move() {
	
	if (paddleXPos+paddleDir > 0 && paddleXPos+paddleDir < GameConstants.WINDOW_WIDTH-paddleWidth-20) {
		
		paddleXPos=paddleDir+paddleXPos;
	}
	
	
}


public void draw(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(paddleXPos,paddleYPos,paddleWidth,paddleHeight);
}

public int getPaddleXPos() {
		return paddleXPos;
	}

	public void setPaddleXPos(int paddleXPos) {
		this.paddleXPos = paddleXPos;
	}

	public int getPaddleDir() {
		return paddleDir;
	}

	public void setPaddleDir(int paddleDir) {
		this.paddleDir = paddleDir;
	}

	public int getPaddleYPos() {
		return paddleYPos;
	}

	public void setPaddleYPos(int paddleYPos) {
		this.paddleYPos = paddleYPos;
	}

	public int getPaddleWidth() {
		return paddleWidth;
	}

	public void setPaddleWidth(int paddleWidth) {
		this.paddleWidth = paddleWidth;
	}

	public int getPaddleHeight() {
		return paddleHeight;
	}

	public void setPaddleHeight(int paddleHeight) {
		this.paddleHeight = paddleHeight;
	}
    
	public Rectangle getBound() {
		return new Rectangle(paddleXPos, paddleYPos, paddleWidth, paddleHeight);
	}


}
