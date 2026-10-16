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
			
			println(convertToPigLatin(clientInput));
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private String convertToPigLatin(String clientInput)
	{
		String pigVersion = "";

		try {
			StringTokenizer tokenizer = new StringTokenizer(clientInput, DELIMITERS, true);
			while (tokenizer.hasMoreTokens()){
				String token = tokenizer.nextToken();
				if (isAWord(token)){
					
				} else {
					println(Errors.NOTALLWORDS.value);
					return "" + (Errors.NOTALLWORDS.value);
				}
			}
		} catch (NullPointerException e) {
			return "NullPointerError occurred: /(e)";
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