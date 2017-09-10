package edu.iu.P532.recieverclass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick {
	
	
	public int getXbrick() {
		return Xbrick;
	}
	public void setXbrick(int xbrick) {
		Xbrick = xbrick;
	}
	public int getYbrick() {
		return Ybrick;
	}
	public void setYbrick(int ybrick) {
		Ybrick = ybrick;
	}
	public int getBrickWidth() {
		return brickWidth;
	}
	public void setBrickWidth(int brickWidth) {
		this.brickWidth = brickWidth;
	}
	public int getBrickHeight() {
		return brickHeight;
	}
	public void setBrickHeight(int brickHeight) {
		this.brickHeight = brickHeight;
	}
	public int getNumRows() {
		return numRows;
	}
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}
	public int getNumCols() {
		return numCols;
	}
	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	public boolean bricks[][];
	private int Xbrick;
	private int Ybrick;
	protected int brickWidth;
	protected int brickHeight;
	protected int numRows;
	protected int numCols;
	
	public Brick(int num_row, int num_col,int width, int height){
		
		this.brickWidth = width;
		this.brickHeight = height;
		this.numRows = num_row;
		this.numCols = num_col;
			
		bricks = new boolean[numRows][numCols];
		for(int i=0; i < numRows; i++){
			for(int j=0; j < numCols;j++){
				
				bricks[i][j] = true; //1 if brick is not yet touched and zero otherwise
			}
		}
		
	}
	void makebricks(){
		for(int i=0; i < numRows; i++){
			for(int j=0; j < numCols;j++){
				if(bricks[i][j]){
				bricks[i][j] = true; //1 if brick is not yet touched and zero otherwise
				
			}
		}
	}}
	
	public void setBrick(){
		bricks[Xbrick][Ybrick]= false;
	}
	
	public void draw(Graphics2D g){
		for(int i=0; i < numRows; i++){
			for(int j=0; j <numCols;j++){
			if(bricks[i][j] ==true){
				
				// drawing bricks
				g.setColor(Color.CYAN);
				g.fillRect(j*brickWidth+50, i*brickHeight+70, brickWidth, brickHeight);
				
				// drawing borders between bricks
				g.setStroke(new BasicStroke(4));
				g.setColor(Color.black);
				g.drawRect(j*brickWidth+50, i*brickHeight+70, brickWidth, brickHeight);
							
			}
				
			}
}
}
}