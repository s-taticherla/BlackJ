import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
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
	private MyPannels2 mp;
	
	public Graph2(Deck deck, Player player, Player computer) {
		this.deck = deck;
		this.player = player;
		this.computer = computer;
		this.setTitle("BLACKJACK2");
		int[] a = this.screenSize();
		this.setBackground(new Color(53,101,77));
		this.setSize(a[0], a[1]);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mp = new MyPannels2(this, this.player, this.computer);
		this.add(mp);
		this.setVisible(true);
	}
	
	public void updateCoordinates(int i, int j) {
		this.xCoord = i;
		this.yCoord = j;
	}
	
	public void paint(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(20, 80, 80, 80);
		g.setColor(Color.RED);
		g.fillRect(20, 180, 80, 80);
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
		if (mp.a.hitPressed && a.hitStand) {
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
				mp.lose(g, true);
			}
		}
		else if (mp.a.standPressed) {
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
	
	public void first(Graphics g) {
		this.downX = 50;
		this.upX = 120;
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
//		g.setColor(Color.WHITE);
//		g.fillRect(this.upX, this.upY, 150, 220);
//		this.upX+=160;
		for (int i = 0; i < this.computer.size(); i++) {
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
	
	public void drawCard(Graphics g) {
		this.contin = true;
		paint(g);
		if (this.contin) {
			while (this.computer.autoGetMove(this.player.sum(), this.computer.sum(), this.player.hitStand)) {
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
			if (this.computer.sum()>21) {
				this.computer.hitStand = false;
				mp.lose(g, false);
			}
			else {
				GameResult gr = new GameResult(this.computer.sum(), this.player.sum());
				mp.lose(g, gr.getResult());
			}
			
		
		}
		else {
			this.contin = !this.contin;
		}
			
	}
	private int[] screenSize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		 
        // Get the screen size as a Dimension object
        Dimension screenSize = toolkit.getScreenSize();
 
        // Extract width and height
        int width = screenSize.width;
        int height = screenSize.height;
        int[] a = {width, height};
        return a;

	}
}
	

