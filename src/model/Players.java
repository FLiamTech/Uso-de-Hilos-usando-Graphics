package model;

import libreriaVersion1.Generica;

public class Players 
{
	Generica <String, String> dt_p;
	
	public Players ()
	{
		dt_p = new Generica<> ();
	}
	
	public Players (String name, String path)
	{
		dt_p = new Generica <> (name, path);
	}
	
	public String getName ()
	{
		return this.dt_p.getAttribute1();
	}
	
	public void setName (String name)
	{
		this.dt_p.setAttribute1(name);
	}
	
	public String getPath ()
	{
		return this.dt_p.getAttribute2();
	}
	
	public void setPath (String path)
	{
		this.dt_p.setAttribute2(path);
	}
	
	public String infoPlayers ()
	{
		return String.format("%s;%s", getName(), getPath());
	}
}
