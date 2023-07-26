package com.Project.Game.utils;

// interface is used because it helps to set the fix things 
//
public interface GameConstants {
  int GHEIGHT=900; // public static final int GHEIGHT=900
  int GWIDTH=1500;
  String TITLE="Game_Street-Fighter";
  String imageBg = "bg.jpeg";
  int FLOOR = GHEIGHT-150;
  
  String RYU_IMAGE="player-sprite.gif";
  String Ken_Image = "kenimage.png";
  int SPEED =80;
  int DEFAULT_FORCE = -10;
  int GRAVITY=10;
  int MAX_HEALTH=500; // equals	 the width of the power bar
  // for moves , keyCodes
  int OppLeft = 100;
  int OppRight = 102;
  int OppJump = 104;
  int OppKick =97;
  int OppPunch=98;
}
