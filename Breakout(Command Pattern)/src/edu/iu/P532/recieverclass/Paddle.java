package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Graphics;
import edu.iu.P532.recieverclass.GameConstants;


public class Paddle  {


protected int paddleXPos;
protected int paddleYPos;
private int paddleWidth;
private int paddleHeight;
private int speed=5;

public void moveRight() {
	paddleXPos  = paddleXPos +speed;
}

public void unmoveRignt() {
	paddleXPos  = paddleXPos -speed;
}
   
public void moveLeft() {
	paddleXPos  = paddleXPos - speed;
}

public void unmoveLeft() {
	paddleXPos  = paddleXPos +speed;
}
}
