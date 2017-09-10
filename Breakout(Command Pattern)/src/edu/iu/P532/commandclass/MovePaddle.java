package edu.iu.P532.commandclass;

import java.awt.event.KeyAdapter;

import edu.iu.P532.recieverclass.Paddle;

public class MovePaddle implements Command{
	
	Paddle paddle;
	public int initX, initY,initPdir;
	
	public MovePaddle(Paddle paddle) {
		this.paddle = paddle;
	}
	
	@Override
	public void execute() {
		
		initX = paddle.getPaddleXPos();
		initY = paddle.getPaddleYPos();
		initPdir = paddle.getPaddleDir();
		paddle.setPaddleXPos(initX+5*paddle.getPaddleDir());
	}
		
	
	@Override
	public void unexecute() {
	
		paddle.setPaddleDir(initPdir);
		paddle.setPaddleXPos(initX);
		paddle.setPaddleYPos(initY);
		
	}
	

}
