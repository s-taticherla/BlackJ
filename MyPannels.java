import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPannels extends JPanel{
	Graph g;
	ML a;
	Player play;
	Player comp;
	
	public MyPannels(Graph gr) {
		this.g = gr;
		this.a = new ML(this, this.g);
		addMouseListener(this.a);
	}
	
	public void paintComponent(Graphics g) {
		// to remove all face up drawings do : super.paintComponent(g);
		this.g.drawCard(g, this.g.getX(), this.g.getY(), "♥", compute(12), compute("♥"));
	}
	
	private String compute(int num) {
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
	
	private boolean compute(String suit) {
		return (suit.equals("♥")||suit.equals("♦️"));
	}
}
class ML extends MouseAdapter {
    private MyPannels mp;
    private Graph parent;

    public ML(MyPannels f, Graph pa) {
        this.mp = f;
        this.parent = pa;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        parent.updateCoordinates(e.getX() - 25, e.getY() - 25);
        mp.repaint();
    }
}
