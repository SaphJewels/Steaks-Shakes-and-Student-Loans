import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Borgar {
	public int[] Burger;
	Random rand = new Random();
	public int makeup;
	
	public Borgar() {
		makeup = rand.nextInt(5)+3;
		Burger = new int[makeup];
		if(makeup==3) {
			for(int i=0;i<3;i++) {
				Burger[i]=1;
			}
		}
		else if(makeup>3) {
			for(int i=0;i<3;i++) {
				Burger[i]=1;
			}
			
			for(int i = 3; i<makeup;i++) {
			/*Ingredient's List
			 * 2 - Lettuce
			 * 3 - Tomato
			 * 4 - Onion
			 * 5 - Bacon
			 Burger[] has default 1,1,1 for Bun, Patty, and Cheese. Any extra length will add random ingredients, maximum of 4 extra.*/
				int ingredient = rand.nextInt(4)+2;
				Burger[i]=ingredient;
			}
		}
	}
}

class burgeroom extends JComponent{
	Borgar burger = new Borgar();


	int rightBX = 650;
	int leftBX = 350;
	
	int lettuceBY = 150;
	int tomatoBY = 230;
	int onionBY = 310;
	int baconBY = 390;
	int bunBY = 150;
	int pattyBY = 257;
	int cheeseBY = 374;
	
	int plateX = 0;
	int plateY = 0;
	
	int panX = 45;
	int panY = 175;
	
	int boxWIDTHL = 100;
	int boxHEIGHTL = 120;
	int boxWIDTHR = 100;
	int boxHEIGHTR = 80;
	
	int pattycookingX = 96;
	int pattycookingY = 224;

	public boolean cookingCheck = false;
	
	//Sets values for each and every X, Y, WIDTH, and HEIGHT

	public void initialize() {}
	

	public void draw(Graphics g) {
		/*Draws the area for orders. Will be removed and added to the OrderList class when made,
		 * because it's a separate thing*/
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 750, 150);
		
		//Area for the Burger related items
		g.fillRect(0, 150, 750, 350);
		
		
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
		
		//Draws burger
		if(cookingCheck) {
			g.setColor(new Color(255,127,127));
			g.fillOval(pattycookingX, pattycookingY, 150, 150);
			timecheck();
		}

		
	}
	
	public void timecheck() {
		
	}
	public void update() {
		repaint();
	}
		
	public void checkClick(int x, int y) {
		if(x>=45 && x<=295 && y>=175 && y<=425) {
			cookingCheck=true;
		}

	}
	public void paintComponent(Graphics g) {
		this.draw(g);
	}

}

public class Burger{
	static JFrame frame;
	static JPanel panel;
	static burgeroom game;
	static MouseClick click1 = new MouseClick();
	
	public static void main(String[] agrs) {	
		
		frame = new JFrame("Steak, Shakes, and Student Loans");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 500);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		game=new burgeroom();
		frame.add(game);
		game.addMouseListener(click1);

		frame.setResizable(false);
		frame.setVisible(true);
		
		
		System.out.println("Borgar consists of "+game.burger.makeup);
		for(int i=0;i<game.burger.makeup;i++) {
			System.out.println("Ingredient value at "+i+" is "+game.burger.Burger[i]);
		}

	}
}

class MouseClick implements MouseListener{	
	
	@Override
	public void mouseClicked(MouseEvent click) {
		
		int mosX = click.getX();
		int mosY = click.getY();
		Burger.game.checkClick(mosX, mosY);
		Burger.game.update();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}