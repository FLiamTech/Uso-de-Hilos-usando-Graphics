package controller;

public class ValidateFields implements Paramets
{
	public static boolean validateNamePlayer (String name)
	{
		return name.matches(ERNamePlayer);
	}
}
