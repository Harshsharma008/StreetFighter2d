package com.Project.Game.Sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.Project.Game.utils.GameConstants;
import com.Project.Game.utils.PlayerConstants;

// this class is for common feature of both the player 
public  abstract class Sprite implements GameConstants,PlayerConstants {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int force;
	protected boolean isJump;                                  
	protected int speed;
	protected BufferedImage image;
	protected int currentMove;
	protected int health;
	// generate the getter and setter for health for accessing and setting
	public int getHealth() {
		return health;
	}
	public void setHealth() {
		this.health = health;
	}

	protected boolean isAttacking;// for this we will generate the getter and setter also
	public boolean isAttacking() { // here at the place of get , it is isAttacking----
		return isAttacking;
	}
	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	protected boolean isCollide; // this helps to see the plyer is colliding or not
	
	public boolean isCollide() {
		return isCollide;
	}
	public void setCollide(boolean isCollide) {
		this.isCollide = isCollide;
	}
	
	
	public Sprite() {
		h=200;
		w=200;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getCurrentMove() {
		return currentMove;
	}
	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}
	//this is abstract because it is used to declare in the kenPlayer and RyuPlayer
	//for this the Player class also is abstract
	public abstract BufferedImage defaultImage();
	
	protected int imageIndex;
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void move() {
		x=x+speed;
	}
	public void printPlayer(Graphics pen)
	{
		pen.drawImage(defaultImage(),x,y,w,h,null);
	}
}
