import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPannels2 extends JPanel{
	Graph2 gra;
	ML2 a;
	Player play;
	Player comp;
	
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
	    	if (this.play.sum()<21){
	    		while(this.comp.sum()< this.play.sum()) {
	    			this.gra.drawCard(g, this.gra.getX(), this.gra.getY());
	    		}
	    	}
	    	
	    }
	    
	}
	
}

class ML2 extends MouseAdapter {
    private MyPannels2 mp;
    private Graph2 parent;

    public ML2(MyPannels2 f, Graph2 pa) {
        this.mp = f;
        this.parent = pa;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        parent.updateCoordinates(e.getX() - 25, e.getY() - 25);
        mp.repaint();
    }
}
