package com.Project.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.Project.Game.Sprites.Power;
import com.Project.Game.Sprites.PowerEffect;
import com.Project.Game.Sprites.RyuPlayer;
import com.Project.Game.Sprites.kenPlayer;
import com.Project.Game.utils.GameConstants;
import com.Project.Game.utils.PlayerConstants;

public class Board  extends JPanel implements GameConstants,PlayerConstants
//this comes in the component and it helps to painting
/// we cannot have to call it , it calls automatically
{
	private BufferedImage imageBg;
	private RyuPlayer ryuplayer;
	private kenPlayer kenplayer;
	private Timer timer;
	private Power ryuPower;
	private Power kenPower;
	private boolean isGameOver;
	private void loadPower() {
		ryuPower = new Power(20,"Ryu".toUpperCase());
		kenPower = new Power(GWIDTH/2+100,"Ken".toUpperCase());
	}
	// for printing the power of both the player
	private void paintPower(Graphics pen) {
		ryuPower.printBox(pen);
		kenPower.printBox(pen);
		
	}
	public Board() throws IOException{
		loadBackgroundImage();
		ryuplayer = new RyuPlayer();
		kenplayer = new kenPlayer();
		 setFocusable(true);
		    bindEvents();
		    gameLoop(); 
		    loadPower();
	}
	public void collision() {
		
		if(isCollide()) {
			if(ryuplayer.isAttacking()) {
				kenplayer.setCurrentMove(DAMAGE);
				kenPower.setHealth();
			}
			if(kenPower.getHealth()<=0 || ryuPower.getHealth()<=0) {
				isGameOver=true;
			}
			if(kenplayer.isAttacking()) {
				ryuplayer.setCurrentMove(DAMAGE);
				ryuPower.setHealth();
			}
			
		   ryuplayer.setCollide(true);
		   kenplayer.setCollide(true);
//		   System.out.println("collide");
		   ryuplayer.setSpeed(0);
		   kenplayer.setSpeed(0);
		}
		else {
	 		ryuplayer.setAttacking(false); 
	 		kenplayer.setAttacking(false);
			ryuplayer.setSpeed(SPEED);
			kenplayer.setSpeed(SPEED);
		}
	}
	// for winning the match
	private void printMessageWIN(Graphics pen) {
		pen.setColor(Color.ORANGE);
        pen.setFont(new Font("times",Font.BOLD,40));
        if(kenPower.getHealth()<=0) {
        pen.drawString("RYU wins",GWIDTH/2-60,GHEIGHT/3);
        }
        else  pen.drawString("KEN wins",GWIDTH/2-60,GHEIGHT/3);
	}
	
	private void printMessage(Graphics pen) {
		pen.setColor(Color.RED);
        pen.setFont(new Font("times",Font.BOLD,40));
        pen.drawString("Game Over",GWIDTH/2-60,GHEIGHT/2);
	}
	private boolean isCollide() {
		int xDistance = Math.abs(ryuplayer.getX()-kenplayer.getX());
		int yDistance = Math.abs(ryuplayer.getY()-kenplayer.getY());
		int maxW = Math.max(ryuplayer.getW(),kenplayer.getW());
		int maxH = Math.max(ryuplayer.getH(),kenplayer.getH());
		return xDistance<=maxW-60 && yDistance<=maxH;
	}
	private void gameLoop() {
		//Thread Triggered
		timer = new Timer(100,(ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint(); // it play the paintComponent()and the paintComponent plays the printPlayer
				ryuplayer.fall();
				kenplayer.fall();
				collision();
			}
		});
		timer.start();// it is compulsory to start the timer
		
	}
	private void loadBackgroundImage() throws IOException{
		imageBg = ImageIO.read(Board.class.getResource("bg.jpeg"));
		
	}
	
	@Override
    public void paintComponent(Graphics pen) {
   super.paintComponent(pen); 
   // the above statement helps to empty the screen, start the parent paint component
    	// all game printing will be there
    printBackgroundImage(pen);
    ryuplayer.printPlayer(pen);
    kenplayer.printPlayer(pen);
    paintPower(pen);// it paints the power at time of print the player
    printPower(pen);
//    printPowerken(pen); // ken ki power
    if(isGameOver) {
    	printMessage(pen);
    	printMessageWIN(pen);
    	timer.stop();
    }
      
   
//     g.player.printPlayer(g);
 //    	g.setColor(Color.RED);
//    	g.fillRect(100, 100, 300, 300);
   
    }
	 
	private void printPower(Graphics pen) {
		for(PowerEffect power : ryuplayer.getPowers()) {
			
					power.printPower(pen);
			}
		
	}
	
//	// for  ken ................
//	private void printPowerken(Graphics pen) {
//		for(PowerEffect power : kenplayer.getPowers()) {
//			power.printPower(pen); 
//		}
//	}
//	// .......................
	private void bindEvents() {
		this.addKeyListener(new KeyAdapter(){
	
@Override
public void keyReleased(KeyEvent e) {
	ryuplayer.setSpeed(0);
	kenplayer.setSpeed(0);
	
}
@Override
public void keyPressed(KeyEvent e) {
	System.out.println("Typed"+e.getKeyCode()+" "+e.getKeyChar());
	if(e.getKeyCode()==KeyEvent.VK_A) {
		ryuplayer.setSpeed(-SPEED);
		ryuplayer.setCurrentMove(WALK);
		ryuplayer.move();
		ryuplayer.setCollide(false);
//		repaint(); // it recall the paint component
	}
	else if(e.getKeyCode()==KeyEvent.VK_D) {
		if(ryuplayer.isCollide()) {
			ryuplayer.setSpeed(0);
		}
		else {
			ryuplayer.setCollide(false);
		ryuplayer.setSpeed(SPEED);
		}
		ryuplayer.setCurrentMove(WALK);
		ryuplayer.move();
//		repaint();
	
		}
	else if(e.getKeyCode()==KeyEvent.VK_X) {
		ryuplayer.setAttacking(true);// ryu is attacking to the ken player 
		ryuplayer.setCurrentMove(KICK);
	}
	else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
		ryuplayer.jump();
		ryuplayer.setCurrentMove(JUMP);
	}
	else if(e.getKeyCode()==KeyEvent.VK_Z) {
		ryuplayer.setAttacking(true);// ryu is attacking to the ken player
		ryuplayer.setCurrentMove(PUNCH);
	}
	// it shows only the action 
	else if(e.getKeyCode()==KeyEvent.VK_Q) {
		ryuplayer.setAttacking(true);// ryu is attacking to the ken player
		ryuplayer.setCurrentMove(POWEREFFECT);
//		ryuplayer.setCurrentMove(STANDING);
		ryuplayer.setAttacking(false);
//	    ryuplayer.addPower();
	    
	}
	// for giving power only on the key W
	else if(e.getKeyCode()==KeyEvent.VK_W) {
		ryuplayer.setAttacking(true);// ryu is attacking to the ken player
		ryuplayer.setCurrentMove(POWEREFFECT);
	    ryuplayer.addPower();
	    
	}
	
	else if(e.getKeyCode()==OppLeft) {
//		kenplayer.setSpeed(-SPEED);
//		kenplayer.setCurrentMove(WALK);
//		kenplayer.move();
		// ken's collid condition ..........
		if(kenplayer.isCollide()) {
			kenplayer.setSpeed(0);
		}
		else {
			kenplayer.setCollide(false);
		kenplayer.setSpeed(-SPEED);
		}
		kenplayer.setCurrentMove(WALK);
		kenplayer.move();
	// till here................
		
//		repaint();
	}
	else if(e.getKeyCode()==OppRight) {
		kenplayer.setSpeed(SPEED);
		kenplayer.setCurrentMove(WALK);
		kenplayer.move();
		kenplayer.setCollide(false);// y vala
//		repaint();
	}
	else if(e.getKeyCode()==OppKick) {
		kenplayer.setAttacking(true);
		kenplayer.setCurrentMove(KICK);
		
	}
	else if(e.getKeyCode()==OppPunch) {
		kenplayer.setAttacking(true);
		kenplayer.setCurrentMove(PUNCH);
	}
	else if(e.getKeyCode()==OppJump) {
		kenplayer.jump();
	}
//	else if (e.getKeyCode()==KeyEvent.VK_I){
//		kenplayer.setAttacking(true);// KEN is attacking to the RYU player
//		kenplayer.setCurrentMove(POWEREFFECT);
//	    kenplayer.addPower();	
//	}
	
	
}
			
		});
		}
	
    private void printBackgroundImage(Graphics pen) {
    	pen.drawImage(imageBg,0,0,1600,900, null);
    }
}
