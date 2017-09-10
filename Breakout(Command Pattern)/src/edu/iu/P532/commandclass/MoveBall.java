package edu.iu.P532.commandclass;

import edu.iu.P532.recieverclass.Ball;

/*
public class MoveBall implements Command {
	
	Ball ball;
    public int ballXdir;
    public int ballYdir;
	
	
	public MoveBall(Ball ball) {
		this.ball=ball;
		this.ballXdir=ball.ballXdir;
		this.ballYdir=ball.ballYdir;
	}
	
	@Override
	public void execute() {
		if(ball.getBallXloc()>=800-50|| ball.getBallXloc()<=0)
		{
			ballXdir=-ballXdir;
		}
		
		if(ball.getBallYloc()>=800-80||ball.getBallYloc()<=0)
		{
			ballYdir=-ballYdir;
		}
		ball.move(ballXdir,ballYdir);	
		
	}

	@Override
	public void unexecute() {
		
		ball.unmove(ballXdir,ballYdir);
	}


}
*/
public class MoveBall implements Command {

Ball ball;
public int initX, initY,initXdir,initYdir;


public MoveBall(Ball ball) {
this.ball = ball;
}

@Override
public void execute() {
initX = ball.getBallXloc();
initY = ball.getBallYloc();
initXdir = ball.getBallXdir();
initYdir = ball.getBallYdir();


ball.move();	

}

@Override
public void unexecute() {
ball.setBallXdir(initXdir);
ball.setBallYdir(initYdir);
ball.setBallXloc(initX);
ball.setBallYloc(initY);

}


}