package edu.iu.P532.commandclass;

import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.GameConstants;
import edu.iu.P532.recieverclass.Paddle;

public class MoveBall implements Command {
	
	Ball ball;
	int initialX, initialY,initialXdir,initialYdir;
	
	
	public MoveBall(Ball ball) {
		this.ball = ball;
	}
	
	@Override
	public void execute() {
		GameConstants gm=new GameConstants();
		initialX = ball.getBallposX();
		initialY = ball.getBallposY();
		initialXdir = ball.getBallXdir();
		initialYdir = ball.getBallYdir();
		
		int ballposX = ball.getBallposX();
			// to accomodate for ball movement
			ball.setBallposX(initialX+initialXdir);
			ball.setBallposY(initialY+initialYdir);
			
			// changing the directions of ball depending on which corner it is hitting		
			// left border
			
			
		
	}

	@Override
	public void unexecute() {
		
		ball.setBallposX(initialX);
		ball.setBallposY(initialY);
	}


}
