package edu.iu.P532.recieverclass;

import java.awt.Graphics;

import org.apache.log4j.Logger;

public class Timer {
	final static Logger logger = Logger.getLogger(Timer.class);
	private int count;
	private int min;
	private int sec;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Timer() {
		this.count = 0;
		this.min = 0;
		this.sec = 0;
	}

	public void doTimer() {
		count++;
		System.out.println(sec);
	}

	public void unDoTimer() {
		count--;
	}

	public void draw(Graphics g) {

	}

	public void reset() {
		min = 0;
		sec = 0;
	}
}
