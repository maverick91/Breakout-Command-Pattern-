package edu.iu.P532.commandclass;

import org.apache.log4j.Logger;

import edu.iu.P532.recieverclass.Ball;

public class MoveBall implements Command {
	final static Logger logger = Logger.getLogger(MoveBall.class);
	Ball ball;
	public int initX, initY, initXdir, initYdir;

	public MoveBall(Ball ball) {
		this.ball = ball;
	}

	@Override
	public void execute() {
		logger.debug("MoveBall execute");
		initX = ball.getBallXloc();
		initY = ball.getBallYloc();
		initXdir = ball.getBallXdir();
		initYdir = ball.getBallYdir();

		ball.move();

	}

	@Override
	public void unexecute() {
		logger.debug("MoveBall unexecute");
		ball.setBallXdir(initXdir);
		ball.setBallYdir(initYdir);
		ball.setBallXloc(initX);
		ball.setBallYloc(initY);

	}

}