package com.Project.Game;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.Project.Game.utils.GameConstants;

public class GameFrame  extends JFrame implements GameConstants{
	 public GameFrame() throws IOException {
	     setTitle(TITLE);
	     
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		 setExtendedState(JFrame.MAXIMIZED_BOTH);
		 setSize(GWIDTH,GHEIGHT);
		 
		 Board board = new Board();
		 add(board);
		 setLocationRelativeTo(null);
		 setVisible(true);
		 
	 }
//	 public static void main(String[]args) {
//		 GameFrame obj=null;
//		 try {
//		 obj = new GameFrame();
//	 }
//		catch(IOException ex) {
//			JOptionPane.showMessageDialog(obj, "Something went wrong");
//		  ex.printStackTrace(); // it helps to show the error in which stack like in frame,in board,etc...
//		  
//		}
//	 }
}
