package edu.iu.P532.commandclass;

import edu.iu.P532.recieverclass.Paddle;

public class MovePaddle implements Command{
	
	Paddle paddle;
	
	public MovePaddle(Paddle paddle) {
		this.paddle = paddle;
	}
	
	@Override
	public void execute() {
		
		paddle.move();
	}

	@Override
	public void unexecute() {
		
		paddle.unMove();
	}

}
