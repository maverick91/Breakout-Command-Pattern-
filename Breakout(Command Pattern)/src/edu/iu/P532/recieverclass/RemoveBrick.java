package edu.iu.P532.recieverclass;



import edu.iu.P532.commandclass.Command;
import edu.iu.P532.recieverclass.Brick;
import edu.iu.P532.recieverclass.GameConstants;

public class RemoveBrick implements Command {
	private Brick brick;
	public boolean brickflags[][] =new boolean[GameConstants.NUM_ROWS][GameConstants.NUM_COLUMNS] ;
	@Override
	public void execute() {
		
		// TODO Auto-generated method stub
		for(int i=0; i < GameConstants.NUM_ROWS; i++){
			for(int j=0; j < GameConstants.NUM_COLUMNS;j++){
				if(this.brick.bricks[i][j]==true)
					brickflags[i][j]=true;		
					else brickflags[i][j]=false;
			}
		}
		
		brick.setBrick();
		
		
		
		
		
	}
	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		for(int i=0; i < GameConstants.NUM_ROWS; i++){
			for(int j=0; j < GameConstants.NUM_COLUMNS;j++){
				if(this.brickflags[i][j]==true)
					brick.bricks[i][j]=true;		
					else brick.bricks[i][j]=false;
			}
		}
		
		
	}
	

}
