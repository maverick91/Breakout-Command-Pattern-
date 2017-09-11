package edu.iu.P532.recieverclass;

import java.util.Arrays;

import edu.iu.P532.commandclass.Command;
import edu.iu.P532.recieverclass.Brick;
import edu.iu.P532.recieverclass.GameConstants;

public class RemoveBrick implements Command {
	private Brick brick;
	public boolean brickflags[][]  ;
	//private static boolean flag=true;
   
	
	public RemoveBrick(Brick brick) {
		// TODO Auto-generated constructor stub
		this.brick=brick;
		this.brickflags	= new boolean[GameConstants.NUM_ROWS][GameConstants.NUM_COLUMNS];
		for(int i=0; i < GameConstants.NUM_ROWS; i++){
			for(int j=0; j < GameConstants.NUM_COLUMNS;j++){
				brickflags[i][j]=true;
			}
			
			}
		
	}
	public void execute() {
		/*if(flag){
			brick.setBrick();
			flag=false;
		}*/
			
		
		// TODO Auto-generated method stub
		/*System.out.print("before execute");
		System.out.println(Arrays.deepToString(brickflags));
		System.out.println(Arrays.deepToString(this.brick.bricks));*/
		
		for(int i=0; i < GameConstants.NUM_ROWS; i++){
			for(int j=0; j < GameConstants.NUM_COLUMNS;j++){
				if(this.brick.bricks[i][j]==false){
					System.out.println("DISASTER");
					brickflags[i][j]=false;		
					}
					else 
						brickflags[i][j]=true;
			}
		}
		brick.setBrick();
		
		
		/*
		System.out.print("updating execute:");
		System.out.println(Arrays.deepToString(brickflags));
		System.out.println(Arrays.deepToString(this.brick.bricks));

		*/
		
	}
	
	
	@Override
	public void unexecute() {
	      //execute();
		/*System.out.print("before unexcutexxxxxxxxx:");
		System.out.println(Arrays.deepToString(this.brickflags));*/
		
		for(int i=0; i < GameConstants.NUM_ROWS; i++){
			
			
			for(int j=0; j < GameConstants.NUM_COLUMNS;j++){
				
				if(this.brickflags[i][j]==true)
					brick.bricks[i][j]=true;		
					else brick.bricks[i][j]=false;
				
				
				
			}
		}
		
	/*	System.out.print("after unexcute:");
		System.out.println(Arrays.deepToString(brickflags));
		*/
		}
	
	
		
		
	}
	


