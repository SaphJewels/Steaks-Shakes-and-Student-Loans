import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class images {
	
	public static BufferedImage whip, cher, rainbowSprinks, chocoSprinks, peanuts, chocoDriz, caramel, oreos;
	public static BufferedImage vanillaPic, chocolatePic, strawberryPic, whippedPic, cherryPic;
	public static BufferedImage lettuceBox, tomatoBox, onionBox, baconBox, bunBox, cheeseBox, pattyBox;
	
	public static BufferedImage[] extras = new BufferedImage[6];
	
	public images() throws IOException {
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
		lettuceBox = ImageIO.read(new File("lettucebox.png"));
		tomatoBox = ImageIO.read(new File("tomatobox.png"));
		onionBox = ImageIO.read(new File("onionbox.png"));
		baconBox = ImageIO.read(new File("baconbox.png"));
		bunBox = ImageIO.read(new File("bunbox.png"));
		cheeseBox = ImageIO.read(new File("cheesebox.png"));
		pattyBox = ImageIO.read(new File("cookedpatty.png"));
		
		for (int i = 0; i < 6; i++) {
			extras[i] = ImageIO.read(new File("image" + i + ".png"));
		}
	}
}
