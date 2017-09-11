package edu.iu.P532.commandclass;
import org.apache.log4j.Logger;

import edu.iu.P532.recieverclass.Paddle;

public class MovePaddle implements Command{
	final static Logger logger = Logger.getLogger(MovePaddle.class);
	Paddle paddle;
	public int initX, initY,initPdir;
	
	public MovePaddle(Paddle paddle) {
		this.paddle = paddle;
	}
	
	@Override
	public void execute() {
		logger.debug("MovePaddle execute");
		initX = paddle.getPaddleXPos();
		initY = paddle.getPaddleYPos();
		initPdir = paddle.getPaddleDir();
		paddle.move();
	}
		

		
	@Override
	public void unexecute() {
		logger.debug("MovePaddle unexecute");
		paddle.setPaddleDir(initPdir);
		paddle.setPaddleXPos(initX);
		paddle.setPaddleYPos(initY);
		
	}
	
  
}
