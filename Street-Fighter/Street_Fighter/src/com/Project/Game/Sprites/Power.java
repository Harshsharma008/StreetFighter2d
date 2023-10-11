package com.Project.Game.Sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Power extends Sprite{
private String playerName;
public Power(int x, String playerName) {
	this.x= x;
	y=50;
	h=50;
	health=w=MAX_HEALTH;
	
	this.playerName=playerName;
}
public void setHealth() {
	health = health-(int)(MAX_HEALTH*0.01);
	
}
@Override
public BufferedImage defaultImage() {
	// TODO Auto-generated method stub
	return null;
}
public void printBox(Graphics pen) {
	pen.setColor(Color.RED); // first set the color for the pen and then use it
	pen.fillRect(x, y, w, h); 
	pen.setColor(Color.GREEN);
	pen.fillRect(x, y, health, h);
	pen.setColor(Color.WHITE);
	pen.setFont(new Font("times",Font.BOLD,40));
	pen.drawString(playerName,x,y+h+40);
	
}
}
