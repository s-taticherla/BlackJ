import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graph extends JFrame {
	private int xCoord = 0;
	private int yCoord = 0;
	private int upX = 1650;
	private int upY = 750;
	private int store = 0;
	
	public Graph() {
		this.setTitle("BLACKJACK");
		this.setSize(2000, 1700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPannels mp = new MyPannels(this);
		this.add(mp);
		this.setVisible(true);
	}
	public void updateCoordinates(int i, int j) {
		this.xCoord = i;
		this.yCoord = j;
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
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
        new Graph();
    }
	public void test(Graphics g, int x, int y) {
//		g.fillOval(50, 50, 50, 50);
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
			System.out.println("HI");
			g.setColor(Color.black);
			g.drawRect(this.upX, this.upY, 150, 220);
			g.setFont(new Font("Consolas", Font.PLAIN, 36));
			g.drawString("J♣", this.upX + 5, this.upY + 35);
			g.drawString("♣J", this.upX + 105, this.upY + 205);
			this.upX-=80;
		}
    }
}
