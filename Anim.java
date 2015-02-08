import javax.swing.*;
import java.awt.*;

public class Anim 
{
	int x = 45;
	int y = 50;
	public static void main (String[] args)
	{
		Anim gui = new Anim();
		gui.go();
	}

	public void go ()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawboard draw = new Drawboard();
		frame.getContentPane().add(draw);
		frame.setSize(400,400);
		frame.setVisible(true);
		for (int i = 0; i < 150; i++) {
			x++;
			y++;
			draw.recieve(x,y);
			try {
				Thread.sleep(50);}
			catch (Exception ex) {}
		}
	}
}

class Drawboard extends JPanel 
{
	
	int x;
	int y;

	public void recieve (int p,int q)
	{
		x = p;
		y = q;
		this.repaint();
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,300,300);
		g.setColor(Color.orange);
		g.fillOval(x,y,40,40);
	}
}