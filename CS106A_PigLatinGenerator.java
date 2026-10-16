//CS106A_PigLatinGenerator
/**
 * File: CS106A_PigLatinGenerator.java
 * ----------------------------------------
 * The CS106A_PigLatinGenerator class converts a client
 * provided String into pig latin. 
 * 
 **/

import acm.program.*;
import java.util.*;

public class CS106A_PigLatinGenerator extends ConsoleProgram
{
	private static final String SENTINEL = "exit";
	
	public void run()
	{
		introduceApp();
		while (true){
			String clientString = readLine("Enter phrase to be converted: ");
			if (clientString.equals(SENTINEL)){
				println("goodbye");
				break;
			}
			
			println(convertToPigLatin(clientString));
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private String convertToPigLatin(String clientString)
	{
		String pigVersion = "";
		
		
		
		return pigVersion;
	}
}