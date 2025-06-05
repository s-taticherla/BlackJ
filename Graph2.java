import javax.swing.*;
import java.awt.*;

public class Graph2 extends JFrame {

	private int xCoord = 0;
	private int yCoord = 0;
	private int downX = 50;
	private int downY = 750;
	private int upX = 120;
	private int upY = 100;
	private Deck d;
	private Player p;
	private Player c;
	
	public Graph2(Deck deck, Player player, Player computer) {
		this.d = deck;
		this.p = player;
		this.c = computer;
		this.setTitle("BLACKJACK2");
		this.setBackground(new Color(53,101,77));
		this.setSize(2000, 1700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPannels2 mp = new MyPannels2(this, this.p, this.c);
		this.add(mp);
		this.setVisible(true);
		this.setBackground(new Color(53,101,77));
	}
	public void updateCoordinates(int i, int j) {
		this.xCoord = i;
		this.yCoord = j;
	}
	
	public void paint(Graphics g) {
		this.setBackground(new Color(53,101,77));
		g.setColor(Color.BLUE);
		g.fillOval(20, 80, 80, 80);
		g.setColor(Color.RED);
		g.fillOval(20, 180, 80, 80);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Consolas", Font.PLAIN, 36));
		g.drawString("HIT", 30, 130);
		g.setFont(new Font("Consolas", Font.PLAIN, 24));
		g.drawString("STAND", 30, 225);

	}
	
	public int getX() {
		return this.xCoord;
	}
	
	public int getY() {
		return this.yCoord;
	}
	
	public static void main(String[] args) {
		Deck de = new Deck();
		Player pla = new Player();
		Player com = new Player();
        new Graph2(de, pla, com);
    }
	
	public void drawCard(Graphics g, int x, int y, Player a) {
		paint(g);
		int cont;
		if (x>=20 && x <= 100) {
			if (y>=80 && y <= 160) {
				cont = 0;
			}
			else if (y>= 180 && y<=260) {
				cont = 1;
			}
			else {
				cont = 2;
			}	
		}
		else {
			cont = 2;
		}
		if (cont == 0) {
			Card c = this.d.randCard();
			a.addCard(c);
			boolean isRed = compute(c.getSymbol());
			String numb = compute(c.getNum());
			String suit = c.getSymbol();
			System.out.println(suit+numb);
			g.setColor(Color.BLACK);
			g.drawRect(this.downX, this.downY, 150, 220);
			if (!isRed) {
				g.setColor(Color.black);
			}
			else {
				g.setColor(Color.RED);
			}
			g.setFont(new Font("Consolas", Font.PLAIN, 36));
			g.drawString(numb+suit, this.downX + 5, this.downY + 35);
			if (!(numb.equals("10"))){
				g.drawString(suit+numb, this.downX + 105, this.downY + 205);
			} else {
				g.drawString(suit+numb, this.downX + 85, this.downY + 205);
			}
			
			this.downX+=80;
		}
		else if (x == 1) {
			
		}
    }
	
	public String compute(int num) {
		if (num <= 10 && num !=1) {
			return ""+num;
		}
		else {
			if(num == 1) {
				return "A";
			}
			else if (num == 11) {
				return "J";
			}
			else if (num == 12) {
				return "Q";
			}
			else {
				return "K";
			}
		}
	}
	
	public boolean compute(String suit) {
		return (suit.equals("♥")||suit.equals("♦️"));
	}

}
