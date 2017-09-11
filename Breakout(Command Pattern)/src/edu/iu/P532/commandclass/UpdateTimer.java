package edu.iu.P532.commandclass;
import edu.iu.P532.recieverclass.*;


public class UpdateTimer implements Command{
	int initCount;
	Timer timer;
	public UpdateTimer(Timer timer) {
		this.timer = timer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		initCount=timer.getCount();
		timer.doTimer();
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		timer.setCount(initCount);
	}

}
