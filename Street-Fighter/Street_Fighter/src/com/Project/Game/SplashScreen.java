package com.Project.Game;

import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import jaco.mp3.player.MP3Player;
//import java.io.File;

// here we extend with JWindow because it comes without any close,minimize and maximize icon 

public class SplashScreen extends JWindow {
private JLabel label = new JLabel();
private MP3Player player;
private void  playSound() {
  player = new MP3Player(SplashScreen.class.getResource("FightSong.mp3"));
}
public SplashScreen() throws IOException {
	setSize(1001,728);
	Icon icon = new ImageIcon(SplashScreen.class.getResource("SplashSec.jpg"));
    label.setIcon(icon);
    this.add(label);
    setLocationRelativeTo(null);
    setVisible(true);
   
    try {
		Thread.sleep(5000);
		setVisible(false);
		dispose();
		GameFrame obj = new GameFrame();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void main(String[] args) {
	try {
		SplashScreen screen = new SplashScreen();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
