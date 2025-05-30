import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graph extends JFrame {
	private int xCoord = 0;
	private int yCoord = 0;
	private Image Back;
	
	public Graph() {
		this.setTitle("BLACKJACK");
		this.setSize(2000, 1700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPannels mp = new MyPannels(this, this.Back);
		this.Back = new ImageIcon("Back.jpg").getImage();
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
        g.setColor(Color.black);
        g.drawRect(x, y, 150, 220);
        g.setFont(new Font("Consolas", Font.PLAIN, 36));
        g.drawString("J♣", x + 5, y + 35);
        g.drawString("♣J", x + 105, y + 205);
    }
}
