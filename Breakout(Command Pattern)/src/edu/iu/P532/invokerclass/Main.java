package edu.iu.P532.invokerclass;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import edu.iu.P532.commandclass.Command;
import edu.iu.P532.commandclass.MoveBall;
import edu.iu.P532.commandclass.MovePaddle;
import edu.iu.P532.commandclass.UpdateTimer;
import edu.iu.P532.recieverclass.Ball;
import edu.iu.P532.recieverclass.Brick;
import edu.iu.P532.recieverclass.GameConstants;
import edu.iu.P532.recieverclass.Paddle;
import edu.iu.P532.recieverclass.RemoveBrick;
import edu.iu.P532.recieverclass.Timer;



public class Main {

	public static final int WIDTH = 800, HEIGHT = 800;
	public static boolean play = false;
	public static boolean replay = false;
	public static boolean start = false;
	static ListIterator li;

	//Ball ball;
	static List<Command> listCommand;

	static int totalBricks= GameConstants.NUM_ROWS * GameConstants.NUM_COLUMNS;
	//Brick brick = new Brick(GameConstants.NUM_ROWS,GameConstants.NUM_COLUMNS,GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT);

	
	static void checkBrickCollision(Brick brick,Ball ball){
		A:for(int i=0; i < brick.getNumRows(); i++){
			for(int j=0; j< brick.getNumCols(); j++){
				if(brick.bricks[i][j] == true ){
					int brickX = j*brick.getBrickWidth() + 50;
					int brickY = i*brick.getBrickHeight() + 70;
					int brickWidth = brick.getBrickWidth();
					int brickHeight = brick.getBrickHeight();
					
					Rectangle rect = new Rectangle(brickX,brickY, brickWidth, brickHeight);
					Rectangle ballRect = new Rectangle(ball.getBallXloc(),ball.getBallYloc(),40,40);
					Rectangle brickRect = rect;
					
					if(ballRect.intersects(brickRect)){
					
						brick.setXbrick(i);
						brick.setYbrick(j);
						Command RemoveBrickCommand = new RemoveBrick(brick);
						listCommand.add(RemoveBrickCommand);
						RemoveBrickCommand.execute();
						
						
						totalBricks--;
						//score += 5;
					
					
						if(ball.getBallXloc()+39 <= brickRect.x || ball.getBallXloc()+1 >=( brickRect.x + brickRect.width) ){
							ball.setBallXdir(-ball.getBallXdir());
						}
						else{
							ball.setBallYdir(-ball.getBallYdir());						}
						break A;
					}
					
				}
			}
			
		}
	}
	
	static void checkGame(){
		
	}
	public static void main(String[] args) {
		Ball ball = new Ball();
		Paddle paddle = new Paddle(GameConstants.PADDLE_INITIAL_POSITION_X, GameConstants.PADDLE_INITIAL_POSITION_Y, GameConstants.PADDLE_WIDTH, GameConstants.PADDLE_HEIGHT);
		Timer timer = new Timer();
		JFrame frame = new JFrame("Breakout");
		Brick brick = new Brick(GameConstants.NUM_ROWS,GameConstants.NUM_COLUMNS,GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		 listCommand = new ArrayList<Command>();
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(Color.DARK_GRAY);
		GamePanel gamePanel = new GamePanel(ball,paddle,brick,timer);
		frame.add(gamePanel);
		frame.setVisible(true);
		gamePanel.setFocusable(true);
		gamePanel.requestFocus();
		//JButton button = new JButton("replay");
		//button.setPreferredSize(new Dimension(40, 40));
		
		
		
	
		JButton button = new JButton("replay");
		JButton button1 = new JButton("undo");
		JButton button2 = new JButton("start");
		JButton button3 = new JButton("pause");
		JTextField timeField = new JTextField(5);
		timeField.setEditable(false);
		timeField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		
		controlPanel.add(button);
		controlPanel.add(button1);
		controlPanel.add(button2);
		controlPanel.add(button3);
		controlPanel.add(timeField);
		
		frame.add(gamePanel,BorderLayout.CENTER);
		frame.add(controlPanel,BorderLayout.PAGE_END);  




button.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*li = listCommand.listIterator();
		new Thread(){
			public void run(){
				while (li.hasNext()){
					Command replayMove =  (Command) li.next();
					//System.out.println(replayMove.initX + " " +replayMove.initY);
//					replayMove.execute();
//					at.repaint();
					replayMove.unexecute();
					try {
						SwingUtilities.invokeAndWait(new Runnable(){
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gamePanel.repaint();
								try {
									java.lang.Thread.sleep(30, 0);
								} catch (InterruptedException e11) {
									// TODO Auto-generated catch block
									e11.printStackTrace();
								}
							}	
						});
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();		
		*/

		replay=true;
		
	}
});

button1.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		play=false;
		Command undoCommand=listCommand.remove(listCommand.size()-1);
		undoCommand.unexecute();
		button3.setText("resume");
		//button2.setText("nn");
		//button2.setVisible(true);
		gamePanel.repaint();
		 /* try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	}
});

button2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(start==false){
			start=true;
			play=true;
			button2.setText("restart");
		}else{
			ball.reset();
			paddle.reset();
			brick.makebricks();
			timer.reset();
			play=true;
			replay=false;
			listCommand = new ArrayList<Command>();
			 totalBricks= GameConstants.NUM_ROWS * GameConstants.NUM_COLUMNS;
		}
		
		
		
	}
});

button3.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		play = !play;
		if(button3.getText()=="pause")
			button3.setText("resume");
		else button3.setText("pause");
		
	}
});
		
		
		
		
		
		
		/*
		
		button.setBackground(Color.blue);
		button.setBounds(900, 100, 40, 30);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Main.play=false;
				//ball.setBallXloc(400);
				//ball.setBallYloc(200);
				
				
			}
		});*/
		//frame.add(button);
	  
		gamePanel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				 
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==37)
				{	
				 paddle.setPaddleDir(-20);
				Command movePaddleCommand = new MovePaddle(paddle);
				 movePaddleCommand.execute();
					listCommand.add(movePaddleCommand);

				// System.out.println(paddle.getPaddleDir());
				}
				else if(e.getKeyCode()==39) 
				{
					paddle.setPaddleDir(20);
					Command movePaddleCommand = new MovePaddle(paddle);
					listCommand.add(movePaddleCommand);

					movePaddleCommand.execute();
				//	System.out.println(paddle.getPaddleDir());
				}
			}
		});
		long previousTime= System.currentTimeMillis();
		int sec=0;
		int min=0;
		while (true) {
			if(play)
			{
				 
				
			
			Command moveBallCommand = new MoveBall(ball);
			moveBallCommand.execute();
			min = timer.getCount() / 60;
			
			sec = timer.getCount() % 60;
			timeField.setText(min+":"+sec);
			listCommand.add(moveBallCommand);
			checkBrickCollision(brick, ball);
			checkGame();
			if(ball.getBallYloc()>paddle.getPaddleYPos()+paddle.getPaddleHeight()) {
				System.out.println(ball.getBallYloc());
				System.out.println(paddle.getPaddleYPos());
				System.out.println("game over" + paddle.getPaddleHeight());
				JOptionPane.showMessageDialog(null, "Game Over");
				play = false;
			}
			/*
			 * game win logic
			 */
			if(totalBricks <= 0) {
				System.out.println("game win");
				JOptionPane.showMessageDialog(null, "Game Won");
			}
			UpdateTimer updateTimerCommand = new UpdateTimer(timer); 
			if(paddle.getBound().intersects(ball.getBound()))
			{
				
				ball.setBallYdir(-ball.getBallYdir());
			}
			if((System.currentTimeMillis()-previousTime)>1000)
			{
				previousTime = System.currentTimeMillis();
				updateTimerCommand.execute();
				listCommand.add(updateTimerCommand);
			}
			gamePanel.repaint();
			}
			
			if (replay){
				play= false;
				ball.reset();
				paddle.reset();
				brick.makebricks();
				timer.reset();
				for (int i =0;i<=listCommand.size()-1;i++) 
				{
					/*ball.reset();
					paddle.reset();
					brick.makebricks();*/
				  listCommand.get(i).unexecute();
				  
				  gamePanel.repaint();
				  
				  try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				replay=false;
			}
		/*	else{

				for (int i =0;i<=listCommand.size()-1;i++) 
				{
					ball.reset();
					paddle.reset();
					brick.makebricks();
				  listCommand.get(i).unexecute();
				  gamePanel.repaint();
				  
				  try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				play= true;
				
			}*/
			
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
