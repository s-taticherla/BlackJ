import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MyPannels2 extends JPanel{
	private Graph2 gra;
	private Player play;
	private Player comp;
	ML2 a;
	
	public MyPannels2(Graph2 gr, Player p, Player c) {
		this.play = p;
		this.comp = c;
		this.gra = gr;
		this.a = new ML2(this, this.gra);
		addMouseListener(this.a);
	}
	
	public void paintComponent(Graphics g) {
		// to remove all face up drawings do : super.paintComponent(g);
	    g.setColor(new Color(53,101,77));
	    g.fillRect(0, 0, getWidth(), getHeight());
	    if (this.play.hitStand) {
	    	this.gra.drawCard(g, this.gra.getX(), this.gra.getY(), this.play);
	    }
	    else {
	    	if (this.play.sum()>21){   		
	    		lose(g, true);
	    	}
	    	else {
	    		this.gra.drawCard(g);
	    		this.gra.paint(g);
	    		this.gra.first(g);
	    	}
	    	
	    }
	    
	}
	
	public void lose(Graphics g, boolean b) {
		System.out.println("p:"+this.play.sum()+" c:"+this.comp.sum());
		if (b) {
			g.setColor(Color.white);
			g.setFont(new Font("Consolas", Font.PLAIN, 160));
			g.drawString("You lose ( °Д °;)", 50, 560);
			this.gra.paint(g);
			this.gra.first(g);
		} else {
			g.setColor(Color.white);
			g.setFont(new Font("Consolas", Font.PLAIN, 120));
			g.drawString("The computer loses (°u°)　", 80, 550);
			this.gra.paint(g);
		}
		
	}
	
}

class ML2 extends MouseAdapter {
    private MyPannels2 mp;
    private Graph2 parent;
    public boolean hitPressed = false;
    public boolean standPressed = false;

    public ML2(MyPannels2 f, Graph2 pa) {
        this.mp = f;
        this.parent = pa;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() - 25;
        int y = e.getY() - 25;
        
        // Detect hit or stand and update state
        if (x >= 20 && x <= 100 && y >= 80 && y <= 160) {
            hitPressed = true;
            standPressed = false;
        } else if (x >= 20 && x <= 100 && y >= 180 && y <= 260) {
            standPressed = true;
            hitPressed = false;
        }
        parent.updateCoordinates(e.getX() - 25, e.getY() - 25);
        mp.repaint();
    }
}
