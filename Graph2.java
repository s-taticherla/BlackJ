import javax.swing.*;
import java.awt.*;

public class Graph2 extends JFrame {

	private int xCoord = 0;
	private int yCoord = 0;
	private int downX = 50;
	private int downY = 750;
	private int upX = 120;
	private int upY = 100;
	private Deck deck;
	private Player player;
	private Player computer;
	private boolean contin = true;
	private boolean first = true;
	
	public Graph2(Deck deck, Player player, Player computer) {
		this.deck = deck;
		this.player = player;
		this.computer = computer;
		this.setTitle("BLACKJACK2");
		this.setBackground(new Color(53,101,77));
		this.setSize(2000, 1700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPannels2 mp = new MyPannels2(this, this.player, this.computer);
		this.add(mp);
		this.setVisible(true);
	}
	
	public void updateCoordinates(int i, int j) {
		this.xCoord = i;
		this.yCoord = j;
	}
	
	public void paint(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillOval(20, 80, 80, 80);
		g.setColor(Color.RED);
		g.fillOval(20, 180, 80, 80);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Consolas", Font.PLAIN, 36));
		g.drawString("HIT", 30, 130);
		g.setFont(new Font("Consolas", Font.PLAIN, 24));
		g.drawString("STAND", 30, 225);

		if (this.first) {
			this.first = false;
			this.first(g);
		}
	}
	
	public int getX() {
		return this.xCoord;
	}
	
	public int getY() {
		return this.yCoord;
	}
	
	public static void main(String[] args) {
		Deck de = new Deck();
		Player pla = new Player(de,1);
		Player com = new Player(de,2);
        new Graph2(de, pla, com);
    }
	
	public void drawCard(Graphics g, int x, int y, Player a) {
		paint(g);
		this.downX = 50;
		this.upX = 120;
		if (!this.first) {
			this.first(g);
		}
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
		if (cont == 0 && a.hitStand) {
			if (this.contin) {
				Card c = this.deck.randCard();
				a.addCard(c);
				boolean isRed = compute(c.getSymbol());
				String numb = compute(c.getNum());
				String suit = c.getSymbol();
				g.setColor(Color.WHITE);
				g.fillRect(this.downX, this.downY, 150, 220);
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
				
				this.downX+=160;
				this.contin = !this.contin;
			}
			else {
				this.contin = !this.contin;
			}
			if (a.sum()>21) {
				a.hitStand = false;
			}
		}
		else if (cont == 1) {
			a.hitStand = false;
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
	
	private void first(Graphics g) {
		for (int i = 0; i < this.player.size(); i++) {
			Card c = this.player.access(i);
			boolean isRed = compute(c.getSymbol());
			String numb = compute(c.getNum());
			String suit = c.getSymbol();
			g.setColor(Color.WHITE);
			g.fillRect(this.downX, this.downY, 150, 220);
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
			
			this.downX+=160;
		}
		g.setColor(Color.WHITE);
		g.fillRect(this.upX, this.upY, 150, 220);
		this.upX+=160;
		for (int i = 1; i < this.computer.size(); i++) {
			Card c = this.computer.access(i);
			boolean isRed = compute(c.getSymbol());
			String numb = compute(c.getNum());
			String suit = c.getSymbol();
			g.setColor(Color.WHITE);
			g.fillRect(this.upX, this.upY, 150, 220);
			if (!isRed) {
				g.setColor(Color.black);
			}
			else {
				g.setColor(Color.RED);
			}
			g.setFont(new Font("Consolas", Font.PLAIN, 36));
			g.drawString(numb+suit, this.upX + 5, this.upY + 35);
			if (!(numb.equals("10"))){
				g.drawString(suit+numb, this.upX + 105, this.upY + 205);
			} else {
				g.drawString(suit+numb, this.upX + 85, this.upY + 205);
			}
			
			this.upX+=160;
		}
	}
	
	public void drawCard(Graphics g, int x, int y) {
		paint(g);
		if (this.contin) {
			Card car = this.deck.randCard();
			this.computer.addCard(car);
			boolean isRed = compute(car.getSymbol());
			String numb = compute(car.getNum());
			String suit = car.getSymbol();
			g.setColor(Color.WHITE);
			g.fillRect(this.upX, this.upY, 150, 220);
			if (!isRed) {
				g.setColor(Color.black);
			}
			else {
				g.setColor(Color.RED);
			}
			g.setFont(new Font("Consolas", Font.PLAIN, 36));
			g.drawString(numb+suit, this.upX + 5, this.upY + 35);
			if (!(numb.equals("10"))){
				g.drawString(suit+numb, this.upX + 105, this.upY + 205);
			} else {
				g.drawString(suit+numb, this.upX + 85, this.upY + 205);
			}
			
			this.upX+=160;
			this.contin = !this.contin;
		}
		else {
			this.contin = !this.contin;
		}
		
	}

}
