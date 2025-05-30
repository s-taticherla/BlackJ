import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPannels extends JPanel{
	Graph g;
	private Image im;
	public MyPannels(Graph gr, Image I) {
		this.g = gr;
		this.im = I;
		addMouseListener(new ML(this, this.g));
	}
	
	public void paintComponent(Graphics g) {
		// to remove all face up drawings do : super.paintComponent(g);
		g.drawImage(this.im, 50, 50, 200, 150, this);
		this.g.test(g, this.g.getX(), this.g.getY());
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