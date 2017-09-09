package edu.iu.P532.recieverclass;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import edu.iu.P532.recieverclass.GameConstants;


public class Paddle  {


private int paddleXPos;
private int paddleDir;

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

}
