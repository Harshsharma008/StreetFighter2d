package com.Project.Game.Sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class kenPlayer  extends Sprite{
	private BufferedImage walkImages[] = new BufferedImage[6];
	private BufferedImage 	standingImage[] = new BufferedImage[6];
	private BufferedImage 	punchImages[] = new BufferedImage[6];
	private BufferedImage 	kickImages[] = new BufferedImage[9];
	private BufferedImage    damageImages[] = new BufferedImage[5];
//	private BufferedImage powerEffectImages[]=new BufferedImage[10];
	
public kenPlayer() throws IOException {
	x=GWIDTH-300;
	
	y=FLOOR-h;
	currentMove =STANDING;
	image=ImageIO.read(kenPlayer.class.getResource(Ken_Image));
	loadWalkImages();
	loadStandingImage();
	loadKickImage();
	loadPunchImage();
	loadDamageImage();
//	loadpowerEffectImages();
	
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
private void loadDamageImage() {
	damageImages[0] = image.getSubimage(1361,3275,67,93);
	damageImages[1] = image.getSubimage(1437,3273,84,100);
	damageImages[2] = image.getSubimage(1535,3276,84,93);
	damageImages[3] = image.getSubimage(1628,3277,70,96);
	damageImages[4] = image.getSubimage(1709,3275,65,92);
}
private void loadWalkImages() {
	walkImages[0] = image.getSubimage(1265,863,62,94);
	walkImages[1] = image.getSubimage(1335,862,63,95);
	walkImages[2] = image.getSubimage(1480,861,63,94);
	walkImages[3] = image.getSubimage(1479,862,62,95);
	walkImages[4] = image.getSubimage(1620,869,65,86);
	walkImages[5] = image.getSubimage(1754,864,61,92);
}
private void loadStandingImage() {
	standingImage[0] = image.getSubimage(1265,864,62,92);
	standingImage[1] = image.getSubimage(1336,862,60,95);
	standingImage[2] = image.getSubimage(1406,862,60,90);
	standingImage[3] = image.getSubimage(1480,860,58,94);
	standingImage[4] = image.getSubimage(1551,866,60,89);
	standingImage[5] = image.getSubimage(1624,866,55,94);
	
}	
private void loadKickImage() {
	kickImages[0] = image.getSubimage(882,1579,71,82);
	kickImages[1] = image.getSubimage(985,1583,106,80);
	kickImages[2] = image.getSubimage(1105,1567,122,93);
	kickImages[3] = image.getSubimage(1238,1564,94,99);
	kickImages[4] = image.getSubimage(1348,1570,64,90);
	kickImages[5] = image.getSubimage(1427,1565,64,93);
	kickImages[6] = image.getSubimage(1494,1561,117,97);
	kickImages[7] = image.getSubimage(1623,1563,68,93);
	kickImages[8] = image.getSubimage(2035,1568,62,92);
	
	
}
private void loadPunchImage() {
	punchImages[0] = image.getSubimage(1252,1144,111,99);
	punchImages[1] = image.getSubimage(1373,1152,72,92);
	punchImages[2] = image.getSubimage(1517,1149,63,93);
	punchImages[3] = image.getSubimage(1667,1143,109,100);
	punchImages[4] = image.getSubimage(1786,1148,78,95);
	punchImages[5] = image.getSubimage(1932,1154,96,87);
}
//private void loadpowerEffectImages() {
//	powerEffectImages[0] = image.getSubimage(26,1704,106,88);
//	powerEffectImages[1] = image.getSubimage(147,1702,94,96);
//	powerEffectImages[2] = image.getSubimage(248,1698,112,95);
//	powerEffectImages[3] = image.getSubimage(375,1696,86,97);
//	powerEffectImages[4] = image.getSubimage(474,1700,117,93);//26,1704,106,88,,,,
//	powerEffectImages[5] = image.getSubimage(5,1808,115,99);
//	powerEffectImages[6] = image.getSubimage(128,1807,114,97);
//	powerEffectImages[7] = image.getSubimage(252,1808,122,99);
//	powerEffectImages[8] = image.getSubimage(385,1813,99,92);
//	powerEffectImages[9] = image.getSubimage(493,1812,143,92);//,,,,
//	
//}
//private BufferedImage powerEffectImages() {
////	BufferedImage subImage = image.getSubimage(190,127,66,94);
////	return subImage;
//	  if(imageIndex>9) {
//	 		imageIndex=0;
//	 		currentMove = STANDING;
//	 	}
//	 	BufferedImage img = powerEffectImages[imageIndex];
//	 	imageIndex++;
//	 	return img;
//}
private BufferedImage damageImages() {
//	BufferedImage subImage = image.getSubimage(190,127,66,94);
//	return subImage;
	  if(imageIndex>=5) {
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
private BufferedImage kickImages() {
//	BufferedImage subImage = image.getSubimage(190,127,66,94);
//	return subImage;
	  if(imageIndex>5) {
	 		imageIndex=0;
	 		currentMove=STANDING;
	 		isAttacking = false;
	 		
	 	}
	 	BufferedImage img = kickImages[imageIndex];
	 	imageIndex++;
	 	return img;
	
  }
private BufferedImage punchImages() {
//	BufferedImage subImage = image.getSubimage(190,127,66,94);
//	return subImage;
	  if(imageIndex>5) {
	 		imageIndex=0;
	 		currentMove=STANDING;
	 		isAttacking = false;
	 	}
	 	BufferedImage img = punchImages[imageIndex];
	 	imageIndex++;
	 	return img;
	
  }
private BufferedImage standingImage() {
//	BufferedImage subImage = image.getSubimage(190,127,66,94);
//	return subImage;
	  if(imageIndex>5) {
	 		imageIndex=0;
	 		currentMove = STANDING;
	 	}
	 	BufferedImage img = standingImage[imageIndex];
	 	imageIndex++;
	 	return img;
	
  }
//private ArrayList<PowerEffect> powers = new ArrayList<>();
//public ArrayList<PowerEffect>getPowers(){
//	 return powers;
//}
//public void addPower() {
// 	// TODO Auto-generated method stub
// 	powers.add(new PowerEffect(x+w,y + h/2-40,image));
// 	
// }
@Override
public BufferedImage defaultImage() {
//	BufferedImage subImage = image.getSubimage(1756,685,65,94);
//	return subImage;
	  if(currentMove==WALK) {
		  return walkImages();
	  }
	  else if(currentMove==PUNCH) {
		 return punchImages(); 
	  }
	  else if(currentMove==KICK) {
		  return kickImages();
	  }
	  else if(currentMove==DAMAGE) {
		  return damageImages();
	  }
//	  else if(currentMove==POWEREFFECT) {
//		  return powerEffectImages();
//	  }
	  
	  return standingImage(); 
	 	
	 
};
}