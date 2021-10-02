import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shakes {
	public static boolean[] shake = {false, false, false, false, false, false, false, false, false, false, false};
	public static boolean[] burgerBoolArr = {false, false, false, false, false, false, false};
	
	
	public static BufferedImage whip, cher, rainbowSprinks, chocoSprinks, peanuts, chocoDriz, caramel, oreos;
	public BufferedImage vanillaPic, chocolatePic, strawberryPic, whippedPic, cherryPic;
	public static BufferedImage bun;
	public static BufferedImage patty;
	public static BufferedImage cheese;
	
	public static BufferedImage DANIEL;
	
	public boolean[] shakeOrder = {false, false, false, false, false, false, false, false, false, false, false};

	public BufferedImage[] extras = new BufferedImage[6];
	public static BufferedImage[] burgerextras = new BufferedImage[4];
	
	public void images() throws IOException {
		vanillaPic = ImageIO.read(new File("vanilla.png"));
		chocolatePic = ImageIO.read(new File("chocolate.png"));
		strawberryPic = ImageIO.read(new File("strawberry.png"));
		whippedPic = ImageIO.read(new File("whipped.png"));
		cherryPic = ImageIO.read(new File("cherry.png"));
		whip = ImageIO.read(new File("whip.png"));
		cher = ImageIO.read(new File("cherrry.png"));
		chocoDriz = ImageIO.read(new File("chocobox.png"));
		caramel = ImageIO.read(new File("caramel.png"));
		rainbowSprinks = ImageIO.read(new File("sprinks.png"));
		peanuts = ImageIO.read(new File("peanuts.png"));
		chocoSprinks = ImageIO.read(new File("chocoSprinks.png"));
		oreos = ImageIO.read(new File("oreooos.png"));
		bun = ImageIO.read(new File("bun.png"));
		patty = ImageIO.read(new File("patty.png"));
		cheese = ImageIO.read(new File("cheese.png"));
		DANIEL =  ImageIO.read(new File("danyul.PNG"));
		
		for (int i = 0; i < 6; i++) {
			extras[i] = ImageIO.read(new File("image" + i + ".png"));
		}
		for(int i=0; i<4; i++) {
			burgerextras[i] = ImageIO.read(new File("bing"+i+".png"));
		}
		
	}
	
	public void danielwork(Graphics g) {
		g.drawImage(DANIEL, 450, 300, null);
	}
	
	public void baseShake(Graphics g) throws IOException {
		//Creating the base ingredients buttons
		//vanilla
		g.setColor(Color.WHITE);
		g.fillRect(50, 175, 75, 75);
		
		//strawberry
		g.setColor(Color.PINK);
		g.fillRect(50, 275, 75, 75);
		
		//chocolate
		g.setColor(new Color(111, 55, 45));
		g.fillRect(50, 375, 75, 75);
		
		//makes a shake of said ingredient
		
		if (choosingShake() > 0 && !shake[0] && !shake[1] && !shake[2]) {
			Quaking.shakeColor = choosingShake();
			
			if (Quaking.shakeColor == 1) {
				shake[0] = true;
			}
			else if (Quaking.shakeColor == 2) {
				shake[1] = true;
			}
			else if (Quaking.shakeColor == 3) {
				shake[2] = true;
			}
		}
		
		if (Quaking.shakeColor == 1) {
			g.drawImage(vanillaPic, 600, 250, null);
		}
		else if (Quaking.shakeColor == 2) {
			g.drawImage(strawberryPic, 600, 250, null);
		}
		else if (Quaking.shakeColor == 3) {
			g.drawImage(chocolatePic, 600, 250, null);
		}
	}
	
	public int choosingShake() {
		if (Quaking.xVal >= 50 && Quaking.xVal<= 150) {
			if (Quaking.yVal >= 175 && Quaking.yVal <= 250) {
				return 1;
			}
			else if (Quaking.yVal >= 275 && Quaking.yVal <= 350){
				return 2;
			}
			else if (Quaking.yVal >= 375 && Quaking.yVal <= 450){
				return 3;
			}
			return 0;
		}
		return 0;
	}
	
	public void classics(Graphics g) {
		//draws whipped cream if asked
		if (shake[3] && (shake[0]||shake[1]||shake[2])) {
			g.drawImage(whippedPic, 600, 200, null);
		}

		//draws cherry if asked
		if (shake[4] && (shake[0]||shake[1]||shake[2])) {
			g.drawImage(cherryPic, 637, 160, null);
		}
	}

	
	public void extraToppings(Graphics g) {
		for (int i = 5; i < 11; i++) {
			if (shake[i]) {
				g.drawImage(extras[i-5], 600, 200, null);
			}
		}
	}
	
	
	//Draws ingredients when selected and such
	public static void burgerForming(Graphics g) {
		if(burgerBoolArr[0]) {
			g.drawImage(bun, 500, 330, 100, 100, null);
		}
		if(burgerBoolArr[0] && burgerBoolArr[1]) {
			g.drawImage(patty, 500, 330, 100, 100, null);
		}
		if(burgerBoolArr[0] && burgerBoolArr[1] && burgerBoolArr[2]) {
			g.drawImage(cheese, 500, 330, 100, 100, null);
		}
		
		for(int i=3; i<burgerBoolArr.length;i++) {
			if(burgerBoolArr[0] && burgerBoolArr[1] && burgerBoolArr[2] && burgerBoolArr[i]) {
				g.drawImage(burgerextras[i-3], 500, 330, 100, 100, null);
			}
		}
	}
	
	public void basics(Graphics g) {
		//drawing whipped cream bottle
		g.drawImage(Shakes.whip, 200, 275, null);

		//cherries box
		g.drawImage(Shakes.cher, 200, 175, null);
		
		//rainbow sprinkle box
		g.drawImage(Shakes.rainbowSprinks, 325, 175, null);
		
		//chocolate sprinkle box
		g.drawImage(Shakes.chocoSprinks, 325, 275, null);
		
		//oreo box
		g.drawImage(Shakes.oreos, 325, 375, null);
		
		//peanut box
		g.drawImage(Shakes.peanuts, 450, 175, null);
		
		//draws chocolate box
		g.drawImage(Shakes.chocoDriz, 450, 275, null);
		
		//draws caramel box
		g.drawImage(Shakes.caramel, 450, 375, null);
	}
}