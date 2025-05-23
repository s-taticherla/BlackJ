import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class graphic extends JFrame {

    private int x = 50, y = 50;

    public graphic() {
        setTitle("Canvas Update Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                //super.paintComponent(g); // Clears the previous drawing
                g.setColor(Color.RED);
                e(g,x,y);
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX() - 25; // Center the circle on the click
                y = e.getY() - 25;
                panel.repaint(); // Request a redraw
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new graphic();
    }
    public void e(Graphics g, int x, int y) {
    	//♥ ♦️ ♠ ♣
    	g.setColor(Color.black);
    	g.drawRect(x,y,150,220);
    	g.setFont(new Font("Consolas", Font.PLAIN, 36));
    	g.drawString("J♣", x+5, y+35);
    	g.drawString("♣J", x+105, y+205);
    	
    }
}
