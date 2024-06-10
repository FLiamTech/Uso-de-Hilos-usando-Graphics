package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreriaVersion1.Files;

public class PlayersDAO 
{
	private Files file;
	
	public PlayersDAO ()
	{
		file = new Files ("C:/Registro");
		file.create(0);
	}
	
	public boolean writePlayers(List<Players> players) throws IOException {
	    file.setFile(new File("C:/Registro", "infoPlayers.txt"));
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file.getFile(), false));
	    try {
	        for (Players p : players) {
	            writer.write(p.infoPlayers() + "\n");
	        }
	        return true;
	    } finally {
	        writer.close();
	    }
	}
	
	public List <Players> readerPlayers () throws IOException
	{
		List <Players> player = new ArrayList();
		file.setFile(new File ("C:/Registro", "infoPlayers.txt"));
		
		BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));
		String line;
		
		while ((line = reader.readLine()) != null)
		{
			String [] info = line.split(";");
			Players p = new Players ();
			p.setName(info[0]);
			p.setPath(info[1]);
			
			player.add(p);
		}
		return player;
	}
	
}
