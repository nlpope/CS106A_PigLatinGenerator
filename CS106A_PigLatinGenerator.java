//CS106A_PigLatinGenerator
/**
 * File: CS106A_PigLatinGenerator.java
 * ----------------------------------------
 * The CS106A_PigLatinGenerator class converts a client
 * provided String into pig latin. 
 * 
 **/

import acm.program.*;
//import java.util.*;

public class CS106A_PigLatinGenerator extends ConsoleProgram
{
	/* Named constants */
	private static final String SENTINEL = "exit";
	private static final String DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/~`/\\ ";
	
	/* Enumerations */
	public enum Errors
	{
		NOTALLWORDS("Error: Input must consist of all words.");
		
		String value;
		Errors(String value){
			this.value = value;
		}
	}
	
	
	public void run()
	{
		introduceApp();
		
		while (true){
			String clientInput = readLine("Enter phrase to be converted: ");
			
			if (clientInput.equals(SENTINEL)){
				println("goodbye");
				break;
			}
			
			if (isAWord(clientInput.trim())){
				println(convertToPigLatin(clientInput));
			} else {
				println(Errors.NOTALLWORDS.value);
			}
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private String convertToPigLatin(String clientInput)
	{
		String pigVersion = "";

		for (int i = 0; i < clientInput.length(); i++){
			for (int j = 0; j < DELIMITERS.length(); j++){
				Character c = (Character) clientInput.charAt(i);
				if (c.equals(DELIMITERS.charAt(j))){ pigVersion += c; }
			}
		}
		
		return pigVersion;
	}
	
	
	private boolean isAWord(String word)
	{
		if (word.length() == 0) { return false; } 
		for (int i = 0; i < word.length(); i++){
			boolean firstCase = word.charAt(i) < 65 || word.charAt(i) > 90;
			boolean secondCase = word.charAt(i) < 97 || word.charAt(i) > 122;
			if (firstCase && secondCase){ return false; }
		}
		return true;
	}
	
	/* Instance variables */
}