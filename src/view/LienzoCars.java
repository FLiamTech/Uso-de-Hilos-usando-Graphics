package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class LienzoCars extends JPanel
{
	public LienzoCars ()
	{
		repaint ();
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, 230, 100);
		g.drawRect(10, 120, 230, 100);
		g.drawRect(10, 230, 230, 100);
		g.drawRect(10, 340, 230, 100);
		
		View_choose vc = new View_choose();
		Toolkit t = Toolkit.getDefaultToolkit();
		Image coche1 = t.getImage("./src/Resources/BMW M3 GTR.jpg");
		g.drawImage(coche1, 10, 10, 230, 100, vc);
		Image coche2 = t.getImage("./src/Resources/Mazda_RX-8_29.jpg");
		g.drawImage(coche2, 10, 120, 230, 100, vc);
		Image coche3 = t.getImage("./src/Resources/Mitsubishi Lancer Evolution VIII.jpg");
		g.drawImage(coche3, 10, 230, 230, 100, vc);
		Image coche4 = t.getImage("./src/Resources/Ford Mustang GT.jpg");
		g.drawImage(coche4, 10, 340, 230, 100, vc);
		}
}
