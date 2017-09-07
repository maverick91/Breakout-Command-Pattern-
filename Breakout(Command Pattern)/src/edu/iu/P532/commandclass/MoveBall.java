package edu.iu.P532.commandclass;

import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.Paddle;

public class MoveBall implements Command {
	
Ball ball;
	
	public MoveBall(Ball ball) {
		this.ball = ball;
	}
	
	@Override
	public void execute() {
		int ballposX=ball.getBallposX();
		int ballposY = ball.getBallposY();
			// to accomodate for ball movement
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			// changing the directions of ball depending on which corner it is hitting		
			// left border
			if(ballposX <= 0 ){
				ballXdir = -ballXdir;
			}
						
			//top border
			if(ballposY <= 0 ){
				ballYdir = -ballYdir;
			}
						
			// right border
			if(ballposX >=780 ){
				ballXdir = -ballXdir;
			}	
			
		
	}

	@Override
	public void unexecute() {
		
		ball.unMove();
	}


}
