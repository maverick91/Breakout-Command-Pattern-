package edu.iu.P532.recieverclass;

public class Paddle {
	private int locX=0;
	
	private int speed = 5;
	
	public void move() 
	{
		locX=locX+speed;
	}

	public void unMove() 
	{
		locX=locX-speed;
	}
	
}
