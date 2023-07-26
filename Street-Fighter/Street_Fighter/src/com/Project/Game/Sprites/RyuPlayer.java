package com.Project.Game.Sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class RyuPlayer extends Sprite  {
private BufferedImage walkImages[]=new BufferedImage[6];
private BufferedImage standingImage[]=new BufferedImage[8];
private BufferedImage punchImages[]=new BufferedImage[6];
private BufferedImage kickImages[]=new BufferedImage[12];
private BufferedImage damageImages[] = new BufferedImage[8];
private BufferedImage powerEffectImages[]=new BufferedImage[10];
public RyuPlayer() throws IOException {
	x=100;
	
	y=FLOOR-h;
	speed =0;
	currentMove= STANDING;
	image=ImageIO.read(RyuPlayer.class.getResource(RYU_IMAGE));
	loadWalkImages();
	loadStandingImage();
	loadPunchImage();
	loadKickImage();
	loadDamageImage();
	loadpowerEffectImages();
}
public void jump() {
	if(!isJump) {
	force = DEFAULT_FORCE;
	y=y+force;
	isJump = true;
}
}
public void fall() {
	if(y>=(FLOOR-h)) {
		isJump = false;
		return;	
	}
	force = force+GRAVITY;
    y=y+force;
}


private void loadWalkImages() {
	walkImages[0] = image.getSubimage(60, 236,77,98);
	walkImages[1] = image.getSubimage(142,235,77,98);
	walkImages[2] = image.getSubimage(225,236,60,98);
	walkImages[3] = image.getSubimage(304,233,58,98);
	walkImages[4] = image.getSubimage(377,234,59,99);
	walkImages[5] = image.getSubimage(453,239,65,96);
}
private void loadStandingImage() {
	standingImage[0] = image.getSubimage(68,344,60,96);
	standingImage[1] = image.getSubimage(144,344,56,92);
	standingImage[2] = image.getSubimage(217,342,60,98);
	standingImage[3] = image.getSubimage(289,340,65,97);
	standingImage[4] = image.getSubimage(369,340,65,107);
	standingImage[5] = image.getSubimage(452,343,68,97);
	standingImage[6] = image.getSubimage(217,342,60,98);
	standingImage[7] = image.getSubimage(289,340,65,97);
	
}
private void loadKickImage() {
	kickImages[0] = image.getSubimage(120,1043,70,96);
	kickImages[1] = image.getSubimage(199,1044,119,97);
	kickImages[2] = image.getSubimage(331,1044,64,95);
	kickImages[3] = image.getSubimage(408,1043,66,98);
	kickImages[4] = image.getSubimage(480,1044,91,101);
	kickImages[5] = image.getSubimage(4,1160,110,98);
	kickImages[6] = image.getSubimage(124,1160,94,96);
	kickImages[7] = image.getSubimage(232,1159,54,100);
	kickImages[8] = image.getSubimage(120,1458,62,122);
	kickImages[9] = image.getSubimage(270,1481,114,101);
	kickImages[10] = image.getSubimage(391,1481,101,100);
	kickImages[11] = image.getSubimage(572,1480,57,100);
	
	
	
}
private void loadPunchImage() {
	punchImages[0] = image.getSubimage(26,819,70,102);
	punchImages[1] = image.getSubimage(106,821,72,100);
	punchImages[2] = image.getSubimage(187,821,115,100);
	punchImages[3] = image.getSubimage(310,819,78,99);
	punchImages[4] = image.getSubimage(402,816,108,102);
	punchImages[5] = image.getSubimage(517,821,79,100);
}

private void loadDamageImage() {
	damageImages[0] = image.getSubimage(321,2528,78,96);
	damageImages[1] = image.getSubimage(238,2528,82,99);
	damageImages[2] = image.getSubimage(396,2338,88,71);
	damageImages[3] = image.getSubimage(396,2338,88,71);
	damageImages[4] = image.getSubimage(507,2330,121,75);
	damageImages[5] = image.getSubimage(399,2344,80,64);
	damageImages[6] = image.getSubimage(304,2324,79,80);
	damageImages[7] = image.getSubimage(431,2214,89,86);
	
}
private void loadpowerEffectImages() {
	powerEffectImages[0] = image.getSubimage(26,1704,106,88);
	powerEffectImages[1] = image.getSubimage(147,1702,94,96);
	powerEffectImages[2] = image.getSubimage(248,1698,112,95);
	powerEffectImages[3] = image.getSubimage(375,1696,86,97);
	powerEffectImages[4] = image.getSubimage(474,1700,117,93);//26,1704,106,88,,,,
	powerEffectImages[5] = image.getSubimage(5,1808,115,99);
	powerEffectImages[6] = image.getSubimage(128,1807,114,97);
	powerEffectImages[7] = image.getSubimage(252,1808,122,99);
	powerEffectImages[8] = image.getSubimage(385,1813,99,92);
	powerEffectImages[9] = image.getSubimage(493,1812,143,92);//,,,,
	
}
private BufferedImage powerEffectImages() {
//	BufferedImage subImage = image.getSubimage(190,127,66,94);
//	return subImage;
	  if(imageIndex>9) {
	 		imageIndex=0;
	 		currentMove = STANDING;
	 	}
	 	BufferedImage img = powerEffectImages[imageIndex];
	 	imageIndex++;
	 	return img;
}
private BufferedImage damageImages() {
//	BufferedImage subImage = image.getSubimage(190,127,66,94);
//	return subImage;
	
	  if(imageIndex>=7) {
	 		imageIndex=0;
	 		currentMove=STANDING;
	 		
	 	}
	 	BufferedImage img = damageImages[imageIndex];
	 	imageIndex++;
	 	return img;
	
  }

  private BufferedImage walkImages() {
//	BufferedImage subImage = image.getSubimage(190,127,66,94);
//	return subImage;
	  if(imageIndex>5) {
	 		imageIndex=0;
	 		currentMove=STANDING;
	 		
	 	}
	 	BufferedImage img = walkImages[imageIndex];
	 	imageIndex++;
	 	return img;
	
  }
  private BufferedImage standingImage() {
//		BufferedImage subImage = image.getSubimage(190,127,66,94);
//		return subImage;
		  if(imageIndex>7) {
		 		imageIndex=0;
		 		currentMove = STANDING;
		 	}
		 	BufferedImage img = standingImage[imageIndex];
		 	imageIndex++;
		 	return img;
		
	  }
  private BufferedImage punchImage() {
//		BufferedImage subImage = image.getSubimage(190,127,66,94);
//		return subImage;
		  if(imageIndex>5) {
		 		imageIndex=0;
		 		currentMove=STANDING;
		 		isAttacking = false;
		 	}
		 	BufferedImage img = punchImages[imageIndex];
		 	imageIndex++;
		 	return img;
		
	  }
  private BufferedImage kickImage() {
//		BufferedImage subImage = image.getSubimage(190,127,66,94);
//		return subImage;
		  if(imageIndex>11) {
		 		imageIndex=0;
		 		currentMove=STANDING;
		 		isAttacking = false;
		 	}
		 	BufferedImage img = kickImages[imageIndex];
		 	imageIndex++;
		 	return img;
		
	  }
 private ArrayList<PowerEffect> powers = new ArrayList<>();
 public ArrayList<PowerEffect>getPowers(){
	 return powers;
 }
 public void addPower() {
  	// TODO Auto-generated method stub
  	powers.add(new PowerEffect(x+w,y + h/2-40,image));
  	
  }
  
  @Override
  public BufferedImage defaultImage() {
	  if(currentMove==WALK) {
		  return walkImages();
	  }
	  else if(currentMove==PUNCH) {
		return punchImage();  
	  }
	  else if(currentMove==KICK) {
			return kickImage();  
		  }
	  else if(currentMove==DAMAGE) {
		  return damageImages();
	  }
	  else if(currentMove==POWEREFFECT) {
		  return powerEffectImages();
	  }
	  return standingImage(); 
  }
  



}
