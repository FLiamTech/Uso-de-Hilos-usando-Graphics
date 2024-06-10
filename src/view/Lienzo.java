package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements Runnable
{
	private Image coche1, coche2, coche3;
	private Random random = new Random();
    private int[] xPos = new int[3];
    private int[] speed = new int[3];
    private boolean running = false;
    private int winnerIndex = -1;
	View_lienzo vl;
	public Lienzo (View_lienzo vl)
	{
		this.vl = vl;
		for (int i = 0; i < 3; i++) {
            xPos[i] = 0;
            speed[i] = random.nextInt(5) + 1;
        }
		repaint();
		coche1 = Toolkit.getDefaultToolkit().getImage("./src/Resources/bmw.png");
		coche2 = Toolkit.getDefaultToolkit().getImage("./src/Resources/mazda.png");
		coche3 = Toolkit.getDefaultToolkit().getImage("./src/Resources/ford.png");
	}
	public void paint (Graphics g)
	{
		super.paint(g);
		
		g.setColor(new Color(68, 68, 68));
		g.fillRect(0, 20, 574, 400);

		g.setColor(Color.BLACK);
		g.fillRect(10, 160, 100, 20);
		g.fillRect(160, 160, 100, 20);
		g.fillRect(310, 160, 100, 20);
		g.fillRect(460, 160, 100, 20);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 574, 85);
		g.fillRect(0, 250, 574, 100);
		
		g.setColor(new Color(104, 54, 9));
		g.fillRect(0, 0, 574, 60);
		g.setColor(new Color(77, 48, 9));
		g.fillRect(0, 0, 574, 40);
		
		g.setColor(new Color(104, 54, 9));
		g.fillRect(0, 275, 574, 60);
		g.setColor(new Color(77, 48, 9));
		g.fillRect(0, 295, 574, 45);
		
		for (int i = 0; i <= 574; i += 20) 
		{
		    if ((i / 20) % 2 == 0) 
		    {
		        g.setColor(Color.RED);
		    } else 
		    {
		        g.setColor(Color.WHITE);
		    }
		    g.fillRect(i, 80, 20, 5);
		}
		for (int i = 0; i <= 574; i += 20) 
		{
		    if ((i / 20) % 2 == 0) 
		    {
		        g.setColor(Color.RED);
		    } else 
		    {
		        g.setColor(Color.WHITE);
		    }
		    g.fillRect(i, 250, 20, 5);
		}
		
		g.setColor(Color.WHITE);
		g.fillRoundRect(490, 85, 5, 165, 5, 10);
		// Meta
		g.setColor(Color.WHITE);
		g.fillRect(510, 90, 25, 25);
		g.fillRect(535, 115, 25, 25);
		g.fillRect(510, 140, 25, 25);
		g.fillRect(535, 165, 25, 25);
		g.fillRect(510, 190, 25, 25);
		g.fillRect(535, 215, 25, 25);
		g.setColor(Color.BLACK);
		g.fillRect(535, 90, 25, 25);
		g.fillRect(510, 115, 25, 25);
		g.fillRect(535, 140, 25, 25);
		g.fillRect(510, 165, 25, 25);
		g.fillRect(535, 190, 25, 25);
		g.fillRect(510, 215, 25, 25);
		// Inicio
		g.setColor(Color.WHITE);
		g.fillRect(10, 90, 25, 25);
		g.fillRect(35, 115, 25, 25);
		g.fillRect(10, 140, 25, 25);
		g.fillRect(36, 165, 25, 25);
		g.fillRect(10, 190, 25, 25);
		g.fillRect(35, 215, 25, 25);
		g.setColor(Color.BLACK);
		g.fillRect(35, 90, 25, 25);
		g.fillRect(10, 115, 25, 25);
		g.fillRect(35, 140, 25, 25);
		g.fillRect(10, 165, 25, 25);
		g.fillRect(35, 190, 25, 25);
		g.fillRect(10, 215, 25, 25);
		
		g.drawImage(coche1, xPos[0], 70, 100, 50, vl);
		g.drawImage(coche2, xPos[1], 120, 100, 50, vl);
		g.drawImage(coche3, xPos[2], 170, 100, 50, vl);
	}
	 public void start() 
	 {
	        if (!running) 
	        {
	            running = true;
	            Thread thread = new Thread(this);
	            thread.start();
	        }
	    }

	    public void stop() 
	    {
	        running = false;
	    }

	    public void refresh ()
	    {
	    	for (int i = 0; i < 3; i++) 
            {
	    		xPos[i] = 0;
            }
	    }
	    @Override
	    public void run() 
	    {
	        while (running) 
	        {
	            for (int i = 0; i < 3; i++) 
	            {
	                if (random.nextBoolean()) 
	                { 
	                    speed[i] = random.nextInt(5) + 1;
	                }
	                xPos[i] += speed[i];	                
	                if (xPos[i] >= 510) 
	                { 
	                    xPos[i] = 510; 
	                    speed[i] = random.nextInt(5) + 1;
	                    
	                    if (winnerIndex == -1) 
	                    {
	                        winnerIndex = i;
	                        if (winnerIndex == 0) 
	                        {
	                            vl.lbl_winner.setText("Ganador es: " + vl.lbl_player1.getText());
	                            if (vl.lbl_state.getText() != "Apuesta al primero")
	                            {
	                            	vl.lbl_state.setText("Perdiste");
	                            }
	                            else
	                            {
	                            	vl.lbl_state.setText("Ganaste");
	                            }
	                        } else if (winnerIndex == 1) 
	                        {
	                            vl.lbl_winner.setText("Ganador es: " + vl.lbl_player2.getText());
	                            if (vl.lbl_state.getText() != "Apuesta al segundo")
	                            {
	                            	vl.lbl_state.setText("Perdiste");
	                            }
	                            else
	                            {
	                            	vl.lbl_state.setText("Ganaste");
	                            }
	                        } else if (winnerIndex == 2) 
	                        {
	                            vl.lbl_winner.setText("Ganador es: " + vl.lbl_player3.getText());
	                            if (vl.lbl_state.getText() != "Apuesta al tercero")
	                            {
	                            	vl.lbl_state.setText("Perdiste");
	                            }
	                            else
	                            {
	                            	vl.lbl_state.setText("Ganaste");
	                            }
	                        }
	                        JOptionPane.showMessageDialog(vl, vl.lbl_winner.getText());
	                    }
	                }
	                
	            }
	            repaint();
	            try {
	                Thread.sleep(50); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
