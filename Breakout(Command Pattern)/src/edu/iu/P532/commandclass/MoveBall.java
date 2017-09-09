package edu.iu.P532.commandclass;

import edu.iu.P532.recieverclass.Ball;


public class MoveBall implements Command {
	
	Ball ball;
	
	
	
	public MoveBall(Ball ball) {
		this.ball = ball;
	}
	
	@Override
	public void execute() {
		
		ball.move();	
		
	}

	@Override
	public void unexecute() {
		
		ball.unmove();
	}


}
