import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

class Quaking extends JComponent{

	Shakes sh = new Shakes();

	Borgar burger = new Borgar();
	
	//variables
	public static int xVal = 0, yVal = 0;
	public static boolean clicked = false;
	public static int burgClick = 0;

	public static int shakeColor = 0;

	static int rightBX = 650;
	static int leftBX = 350;
	
	static int lettuceBY = 150;
	static int tomatoBY = 230;
	static int onionBY = 310;
	static int baconBY = 390;
	static int bunBY = 150;
	static int pattyBY = 257;
	static int cheeseBY = 374;

	static int panX = 45;
	static int panY = 175;
	
	static int boxWIDTHL = 100;
	static int boxHEIGHTL = 120;
	static int boxWIDTHR = 100;
	static int boxHEIGHTR = 80;
	
	static int pattycookingX = 96;
	static int pattycookingY = 224;

	public boolean cookingCheck = false;
	public static boolean newOrder = false;
	
	/* [0] is the base
	 * [1] is whipped cream
	 * [2] is cherries
	 * [3] is Rainbow sprinkles/image 0
	 * [4] is Chocolate sprinkles/image 1
	 * [5] is peanuts/ image 3
	 * [6] is Chocolate sauce / image 4
	 * [7] is Caramel drizzle / image 5
	 * [8] is Oreos/image 2
	 * */
	
	public static int stage = 0;
	public static double money = 1.00;
	public static double studloan = 10.00;
	
	public static boolean[] Burger;
	public static BufferedImage lettuceBox, tomatoBox, onionBox, baconBox, bunBox, cheeseBox, pattyBox;

	
	public static boolean[] burgerOrder = {false, false, false, false, false, false, false};
	
	public void images() throws IOException {
		lettuceBox = ImageIO.read(new File("lettucebox.png"));
		tomatoBox = ImageIO.read(new File("tomatobox.png"));
		onionBox = ImageIO.read(new File("onionbox.png"));
		baconBox = ImageIO.read(new File("baconbox.png"));
		bunBox = ImageIO.read(new File("bunbox.png"));
		cheeseBox = ImageIO.read(new File("cheesebox.png"));
		pattyBox = ImageIO.read(new File("cookedpatty.png"));
	}
	
	//drawing
	public void draw(Graphics g) throws IOException {
		images();
		sh.images();
		
		//background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 750, 150);
		
		g.setColor(new Color(100, 100, 100));
		g.fillRect(0, 150, 750, 500);
		
		//dividing the screen
		g.setColor(Color.BLACK);
		g.drawLine(0, 150, 750, 150);
		
		g.setColor(Color.MAGENTA);
		g.fillRect(600, 25, 100, 100);
		
		g.setColor(Color.CYAN);
		g.fillRect(450, 25, 100, 100);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		g.drawString("Pressy press", 620, 75);
		g.drawString("New Order", 470, 75);
		
		g.setColor(Color.RED);
		g.fillRect(0,0,10,10);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		g.drawString("Money Earned: $" + money, 230, 145);
		g.drawString("Loans to pay off: $"+studloan, 450, 145);
		
		if (newOrder) {
			orders();
			newOrder = false;
		}
		
		
		if (stage == 0) {
			g.setColor(Color.WHITE);
			g.fillRect(0,0,750,500);
			
			g.setColor(Color.MAGENTA);
			g.fillRect(600, 25, 100, 100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
			g.drawString("Pressy press", 620, 75);
			
			g.setColor(Color.RED);
			g.fillRect(0,0,10,10);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("DIRECTIONS", 30, 100);
			
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			g.drawString("Welcome to Steak, Shakes, and Student Loans! Your goal", 30, 150);
			g.drawString("is to pay off your student loans through work. Each day you will", 30, 175);
			g.drawString("make burgers and shakes, one at a time, for the customers. ", 30, 200);
			g.drawString("You will get paid based on the difficulty of the order. Good luck!", 30, 225);
			g.drawString("Click the magenta box to move to the next screen. Click the ", 30, 300);
			g.drawString("red box to delete what you have.", 30, 325);
			
			sh.danielwork(g);
		}
		
		else if (stage == 1) {
			
		//Draws each station/ingredient box
			
			//Draws Boxes for ingredients
			g.setColor(new Color(202, 179, 104));
			g.fillRect(rightBX, lettuceBY, boxWIDTHR, 750);
			g.fillRect(leftBX, bunBY, boxWIDTHL, 750);
			
			
			//Draw the oven station
			g.setColor(Color.GRAY);
			g.fillRect(0, 150, 350, 500);
			g.setColor(Color.BLACK);
			g.fillOval(panX, panY, 250, 250);

			//Lines separating everything
			g.setColor(Color.BLACK);
			g.drawLine(0, 150, 750, 150);
			g.drawLine(350, 150, 350, 500);
			
			g.drawLine(rightBX, 150, rightBX, 500);
			g.drawLine(rightBX, tomatoBY, 750, tomatoBY);
			g.drawLine(rightBX, onionBY, 750, onionBY);
			g.drawLine(rightBX, baconBY, 750, baconBY);
			
			g.drawLine(leftBX+100, 150, leftBX+100, 500);
			g.drawLine(leftBX, pattyBY, leftBX+100, pattyBY);
			g.drawLine(leftBX, cheeseBY, leftBX+100, cheeseBY);
			
			//Draw images on boxes
			g.drawImage(lettuceBox, rightBX, lettuceBY, null);
			g.drawImage(tomatoBox, rightBX, tomatoBY, null);
			g.drawImage(onionBox, rightBX, onionBY, null);
			g.drawImage(baconBox, rightBX, baconBY, null);
			g.drawImage(bunBox, leftBX, bunBY, null);
			g.drawImage(pattyBox, leftBX, pattyBY, null);
			g.drawImage(cheeseBox, leftBX, cheeseBY, null);
			
			//plate
			g.setColor(Color.white);
			g.fillOval(500, 400, 100, 25);
			
			g.setColor(Color.black);
			
			//Draws burger
			if(cookingCheck) {
				if (burgClick == 1) {
					Color burgCol= new Color(255,127,127);
					g.setColor(burgCol);
				}
				else if (burgClick == 2) {
					Color burgCol = new Color(84, 45, 45);
					g.setColor(burgCol);
				}
					
					g.fillOval(pattycookingX, pattycookingY, 150, 150);
			}
			
			Shakes.burgerForming(g);
			
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			String[] itemsInBurger = {"Bun", "Patty", "Cheese", "Lettuce", "Tomato", "Onion", "Bacon"};
			int textY = 25;
			
			for (int i = 0; i < 7; i++) {
				if (burgerOrder[i]) {
					g.drawString(Game.subList(itemsInBurger, i), 10, textY);
					textY+=15;
				}
			}
			
		}
		
		else if (stage == 2) {			
			g.setColor(Color.BLACK);
			g.drawLine(0, 150, 750, 150);
			g.drawLine(175, 150, 175, 500);
			g.drawLine(550, 150, 550, 500);
			
			g.setColor(Color.GREEN);
			g.fillRect(300, 25, 100, 100);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
			g.drawString("CHECK ORDER", 315, 75);
			
			//draws base
			sh.basics(g);
	
			//draws classic toppings
			sh.classics(g);
			
			//draws extras on shake
			sh.extraToppings(g);
			
			//makes base shake
			sh.baseShake(g);
			
			sh.choosingShake();
			
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			String[] itemsInShake = {"Vanilla Shake", "Strawberry Shake", "Chocolate Shake", "Whipped Cream", "Cherry", "Rainbow Sprinkles", "Chocolate Sprinkles", "Oreos", "Peanuts", "Chocolate Drizzle", "Caramel Drizzle"};
			int textY = 25;
			
			for (int i = 0; i < 11; i++) {
				if (sh.shakeOrder[i]) {
					g.drawString(Game.subList(itemsInShake, i), 10, textY);
					textY+=15;
				}
			}
		}
		
		else if(stage ==3) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 750, 500);
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
			g.setColor(Color.black);
			g.drawString("YOU'RE OUT OF DEBT", 100, 200);
		}
		
		else if (stage == 4) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 750, 500);
			
			g.setColor(Color.RED);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			g.drawString("YOU'RE FIRED!!!", 170, 200);
			
			
			g.fillRect(320, 250, 100, 100);
			g.setColor(Color.black);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			g.drawString("Reapply", 340, 300);
			
		}
		
	}
	
	public void update() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		try {
			this.draw(g);
		} catch (IOException e) {
		
		}
	}
	public void checkClick(int x, int y) {
		if(x>=45 && x<=295 && y>=175 && y<=425) {
			if (cookingCheck) {
				burgClick++;
			}
			else {
				cookingCheck=true;
			}
		}
	}
	
	public void orders() {
		Random r = new Random();
		burgerOrder[0] = true;
		burgerOrder[1] = true;
		burgerOrder[2] = true;
		for (int i = 3; i < 6; i++) {
			int temp = r.nextInt(2);
			if (temp == 0) {
				burgerOrder[i] = false;
			}
			else {
				burgerOrder[i] = true;
			}
		}
		
		
		sh.shakeOrder[3] = true;
		sh.shakeOrder[4] = true;
		
		int temp = r.nextInt(3);
		if (temp == 0) {
			sh.shakeOrder[0] = true;
			sh.shakeOrder[1] = false;
			sh.shakeOrder[2] = false;
		}
		else if (temp == 1) {
			sh.shakeOrder[1] = true;
			sh.shakeOrder[0] = false;
			sh.shakeOrder[2] = false;
		}
		else {
			sh.shakeOrder[2] = true;
			sh.shakeOrder[1] = false;
			sh.shakeOrder[0] = false;
		}
		
		for (int i = 5; i < 11; i++) {
			temp = r.nextInt(2);
			if (temp == 0) {
				sh.shakeOrder[i] = false;
			}
			else {
				sh.shakeOrder[i] = true;
			}
		}

	}

}

public class Game {
	static Quaking quake;
	
	public static void reset() {
		for (int i = 0; i < 11; i++)
			quake.sh.shake[i] = false;
		for(int j=0;j<7;j++)
			quake.sh.burgerBoolArr[j] = false;
		
		Quaking.shakeColor = 0;
		Quaking.burgClick = 0;
		
		quake.money -= 0.25;
		if (quake.money < 0) {
			quake.stage = 4;
		}
		
	}
	
	public static double cashCheck() {
		double cash = 5;
		for (int i = 3; i < 9; i++) {
			if (i < 7) {
				if (quake.burgerOrder[i]) {
					cash += 0.50;
				}
			}
			if (quake.sh.shakeOrder[i+2]) {
				cash += 0.25;
			}
		}
		
		return cash;
	}
	
	public static String makeString(boolean[] array, int len) {
		String temp = "";
		for (int i = 0; i < len; i++) {
			temp += array[i] + ", ";
		}
		return temp;
	}
	
	public static String subList(String[] itemsInShake, int i) {
		return "" + itemsInShake[i];
	}

	
	public static void main(String[] args) {
		
		quake = new Quaking();
		quake.setFocusable(true);
		quake.addMouseListener(new MouseInput());
		
		JFrame frame = new JFrame("Steaks, Shakes, and Student Loans");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 500);
		
		frame.add(quake);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static boolean checking() {

		for (int i = 0; i < 11; i++) {
			if (quake.sh.shake[i] != quake.sh.shakeOrder[i]) 
				return false;
		}

		for (int i = 0; i < 7; i++) {
			if (quake.burgerOrder[i] != Shakes.burgerBoolArr[i]) {
				return false;
		}
	}
		return true;
	}
	
	
}
	
	
	