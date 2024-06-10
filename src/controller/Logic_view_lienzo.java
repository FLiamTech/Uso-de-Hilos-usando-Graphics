package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Players;
import model.PlayersDAO;
import view.Lienzo;
import view.LienzoCars;
import view.View_Dates;
import view.View_choose;
import view.View_lienzo;

public class Logic_view_lienzo implements ActionListener
{
	private View_lienzo vl;
	private View_Dates vd;
	private View_choose vc;
	
	private Players p = new Players();
	private PlayersDAO pdao = new PlayersDAO();
	private Lienzo lienzo;
	
	List<Players> playersList = new ArrayList();
	List<Players> getPlayers = new ArrayList();
	
	public Logic_view_lienzo (View_lienzo vl, View_Dates vd, View_choose vc, Lienzo lienzo)
	{
		super ();
		this.vd = vd;
		this.vl = vl;
		this.vc = vc;
		this.lienzo = lienzo;
		this.vl.btn_select.addActionListener(this);
		this.vl.btn_Start.addActionListener(this);
		this.vl.btn_pause.addActionListener(this);
		this.vl.btn_bet1.addActionListener(this);
		this.vl.btn_bet2.addActionListener(this);
		this.vl.btn_bet3.addActionListener(this);
		
		this.vd.btn_choose1.addActionListener(this);
		this.vd.btn_choose2.addActionListener(this);
		this.vd.btn_choose3.addActionListener(this);
		this.vd.btn_acceptPlayers.addActionListener(this);
		this.vd.btn_return.addActionListener(this);
		
		this.vc.btn_acceptVehicle.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if (e.getSource() == vl.btn_select)
		{
			vd.setVisible(true);
			vd.setLocationRelativeTo(null);
			vl.dispose();
		}
		if (e.getSource() == vd.btn_choose1)
		{
			if (validate(1))
			{
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
				loadList ();
			}
			else
			{
				JOptionPane.showMessageDialog(vc, "Ponga un nombre primero");
			}
			
		}
		if (e.getSource() == vd.btn_choose2)
		{
			if (validate(2))
			{
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
				loadList ();
			}
			else
			{
				JOptionPane.showMessageDialog(vc, "Ponga un nombre primero");
			}
		}
		
		if (e.getSource() == vd.btn_choose3)
		{
			if (validate(3))
			{
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
				loadList ();
			}
			else
			{
				JOptionPane.showMessageDialog(vc, "Ponga un nombre primero");
			}
		}
        if (e.getSource() == vc.btn_acceptVehicle) 
        {
        	
            int playerIndex = playersList.size() + 1;
            if (validate(playerIndex)) {
                Players player = new Players();
                if (playerIndex == 1) {
                    player.setName(vd.txt_player1.getText());
                } else if (playerIndex == 2) {
                    player.setName(vd.txt_player2.getText());
                } else if (playerIndex == 3) {
                    player.setName(vd.txt_player3.getText());
                }

                int selectedCarIndex = vc.lst_catalogue.getSelectedIndex();
                if (selectedCarIndex == 0) {
                    player.setPath("./src/Resources/BMW M3 GTR.jpg");
                } else if (selectedCarIndex == 1) {
                    player.setPath("./src/Resources/Mazda_RX-8_29.jpg");
                } else if (selectedCarIndex == 2) {
                    player.setPath("./src/Resources/Mitsubishi Lancer Evolution VIII.jpg");
                } else {
                    player.setPath("./src/Resources/Ford Mustang GT.jpg");
                }
                
                playersList.add(player);

                vc.dispose();
                
            }
        }
        
        if(e.getSource() == vd.btn_acceptPlayers)
        {
        	if (playersList.size() == 3) 
        	{
                try {

                    pdao.writePlayers(playersList);
                    
                    vl.setVisible(true);
                    vl.setLocationRelativeTo(null);
                    vd.dispose();
                    vl.lbl_player1.setText("Desconocido");
                    vl.lbl_player2.setText("Desconocido");
                    vl.lbl_player3.setText("Desconocido");
                    
                    playersList.removeAll(playersList);
                    
                    getPlayers = pdao.readerPlayers();
                    for (int i=0; i<getPlayers.size() ; i++)
                    {
                    	Players p = getPlayers.get(i);
                    	if (i == 0)
                    	{
                    		vl.lbl_player1.setText(p.getName());
                    	}
                    	else if (i == 1)
                    	{
                    		vl.lbl_player2.setText(p.getName());
                    	}
                    	else
                    	{
                    		vl.lbl_player3.setText(p.getName());
                    	}
                    }
                    this.lienzo.refresh();
                    this.lienzo.stop();
                    
                } catch (IOException e1) 
                {
                    e1.printStackTrace();
                }
            } 
        	else
            {
            	JOptionPane.showMessageDialog(vd, "Tiene que escoger primero los 3 campos", "Error", 0);
            }
        }
        if (e.getSource() == vl.btn_Start) {
            if (getPlayers.size() < 3) {
                JOptionPane.showMessageDialog(vl, "Debe seleccionar a los 3 jugadores antes de iniciar la carrera.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                this.lienzo.start();
            }
        }
        
        if (e.getSource() == vl.btn_pause)
        {
        	this.lienzo.stop();
        }
        if(e.getSource() == vd.btn_return)
        {
        	vl.setVisible(true);
        	vl.setLocationRelativeTo(null);
        	vd.dispose();
        }
        
        if (e.getSource() == vl.btn_bet1)
        {
        	bet1 ();
        	vl.lbl_state.setText("Apuesta al primero");
        }
        if (e.getSource() == vl.btn_bet2)
        {
        	bet1 ();
        	vl.lbl_state.setText("Apuesta al segundo");
        }
        if (e.getSource() == vl.btn_bet3)
        {
        	bet1 ();
        	vl.lbl_state.setText("Apuesta al tercero");
        }
        
    }	
	
	public void loadList ()
	{
		DefaultListModel<String> listModel = new DefaultListModel<>();
		String listItem;
		listItem = "<html><b>Coche: " + 1 + "</b><br>";
        listItem += "<font color='brown'>Tipo:</font> " + "BMW M3 GTR" + "<br>";
        listItem += "<font color='blue'>Origen:</font> " + "Alemania" + "<br>";
        listItem += "<font color='blue'>Motor:</font> " + "Motor Delantero, Tracción Trasera" + "<br>";
        listItem += "<font color='blue'>Marca:</font> " + "BMW" + "<br>";
        listItem += "</html>";
        
        listModel.addElement(listItem);
        
        listItem = "<html><b>Coche: " + 2 + "</b><br>";
        listItem += "<font color='brown'>Tipo:</font> " + "Mazda RX-8" + "<br>";
        listItem += "<font color='blue'>Origen:</font> " + "Japon" + "<br>";
        listItem += "<font color='blue'>Motor:</font> " + "Motor Delantero, Tracción Trasera" + "<br>";
        listItem += "<font color='blue'>Marca:</font> " + "Mazda" + "<br>";
        listItem += "</html>";
        
        listModel.addElement(listItem);
        
        listItem = "<html><b>Coche: " + 3 + "</b><br>";
        listItem += "<font color='brown'>Tipo:</font> " + "Mitsubishi Lancer Evolution VIII" + "<br>";
        listItem += "<font color='blue'>Origen:</font> " + "Japon" + "<br>";
        listItem += "<font color='blue'>Motor:</font> " + "Motor Delantero, Tracción Trasera" + "<br>";
        listItem += "<font color='blue'>Marca:</font> " + "Mitsubishi" + "<br>";
        listItem += "</html>";
        
        listModel.addElement(listItem);
        
        listItem = "<html><b>Coche: " + 4 + "</b><br>";
        listItem += "<font color='brown'>Tipo:</font> " + "Ford Mustang GT" + "<br>";
        listItem += "<font color='blue'>Origen:</font> " + "Estados Unidos" + "<br>";
        listItem += "<font color='blue'>Motor:</font> " + "Motor Delantero, Tracción Trasera" + "<br>";
        listItem += "<font color='blue'>Marca:</font> " + "Ford" + "<br>";
        listItem += "</html>";

        listModel.addElement(listItem);
        
        vc.lst_catalogue.setModel(listModel);
	}
	
    public boolean validate(int playerIndex) 
    {
        boolean state = true;
        if (playerIndex == 1) 
        {
            if (ValidateFields.validateNamePlayer(vd.txt_player1.getText())) 
            {
                vd.txt_player1.setBackground(Color.green);
            } 
            else 
            {
                vd.txt_player1.setBackground(Color.magenta);
                state = false;
            }
        }
        else if (playerIndex == 2) 
        {
            if (ValidateFields.validateNamePlayer(vd.txt_player2.getText())) 
            {
                vd.txt_player2.setBackground(Color.green);
            } else
            {
                vd.txt_player2.setBackground(Color.magenta);
                state = false;
            }
        }
        else if (playerIndex == 3) 
        {
            if (ValidateFields.validateNamePlayer(vd.txt_player3.getText())) 
            {
                vd.txt_player3.setBackground(Color.green);
            } else 
            {
                vd.txt_player3.setBackground(Color.magenta);
                state = false;
            }
        }
        return state;
    }
    
    private void bet1 ()
    {
    	String userInput;
    	int value = 0;
    	boolean validInput = false;

    	do {
    	    userInput = JOptionPane.showInputDialog(vl, "Ingrese un valor entero:");
    	    if (userInput != null && !userInput.isEmpty()) 
    	    {
    	        try {
    	            value = Integer.parseInt(userInput);
    	            validInput = true;
    	            
    	            if (validInput)
    	            {
    	            	vl.lbl_bet.setText(userInput + "$");
    	            }
    	        } catch (NumberFormatException ex) {
    	            JOptionPane.showMessageDialog(vl, "Ingrese un valor entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
    	    } 
    	    else 
    	    {
    	        validInput = true;
    	    }
    	} while (!validInput);
    }
}
