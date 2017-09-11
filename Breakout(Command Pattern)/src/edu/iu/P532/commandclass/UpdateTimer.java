package edu.iu.P532.commandclass;
import org.apache.log4j.Logger;

import edu.iu.P532.recieverclass.*;


public class UpdateTimer implements Command{
	final static Logger logger = Logger.getLogger(UpdateTimer.class);
	int initCount;
	Timer timer;
	public UpdateTimer(Timer timer) {
		this.timer = timer;
	}
	
	@Override
	public void execute() {
		logger.debug("UpdateTimer execute");
		// TODO Auto-generated method stub
		initCount=timer.getCount();
		timer.doTimer();
	}

	@Override
	public void unexecute() {
		logger.debug("UpdateTimer unexecute");
		// TODO Auto-generated method stub
		timer.setCount(initCount);
	}

}
