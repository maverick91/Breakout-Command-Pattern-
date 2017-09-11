package com.breakout;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.iu.P532.commandclass.MoveBall;
import edu.iu.P532.commandclass.MovePaddle;
import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.GameConstants;
import edu.iu.P532.recieverclass.Paddle;

public class TestBreakout {

	Ball ball;
	Paddle paddle;

	@Before
	public void setParameter() {
		ball = new Ball();
		paddle = new Paddle(GameConstants.PADDLE_INITIAL_POSITION_X,
				GameConstants.PADDLE_INITIAL_POSITION_Y,
				GameConstants.PADDLE_WIDTH, GameConstants.PADDLE_HEIGHT);
	}
	
	@Test
	public void testMovePaddleExecute() {
		MovePaddle tester = new MovePaddle(paddle);
		assertEquals(0, tester.getInitX());
		// testing execute of MoveBall
		tester.execute();
		// assert statements
		assertEquals(360, tester.getInitX());
		
	}
	
	@Test
	public void testMovePaddleUnexecute() {
		MovePaddle tester = new MovePaddle(paddle);
		assertEquals(360, paddle.getPaddleXPos());
		// testing execute of MoveBall
		tester.unexecute();
		// assert statements
		assertEquals(0, paddle.getPaddleXPos());
		
	}

	@Test
	public void testMoveBallExecute() {
		MoveBall tester = new MoveBall(ball); // MyClass is tested
		assertEquals(0, tester.getInitX());
		// testing execute of MoveBall
		tester.execute();
		// assert statements
		assertEquals(400, tester.getInitX());
		assertEquals(600, tester.getInitY());
		assertEquals(5, tester.getInitXdir());
		assertEquals(5, tester.getInitYdir());
	}

	@Test
	public void testMoveBallUnexecute() {
		MoveBall tester = new MoveBall(ball);
		assertEquals(5, ball.getBallXdir());
		// testing execute of MoveBall
		tester.unexecute();
		// assert statements
		assertEquals(0, ball.getBallXdir());
		assertEquals(0, ball.getBallYdir());
		assertEquals(0, ball.getBallXloc());
		assertEquals(0, ball.getBallYloc());
	}

}
