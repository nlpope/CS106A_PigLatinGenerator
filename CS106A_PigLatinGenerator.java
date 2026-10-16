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
	private static final String DELIMITERS = "\n!@#$%^&*()_-+={[}]:;\"'<,>.?/~`/\\ ";
	
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
			
			if (isAWord(clientInput.replaceAll("\\s+", ""))){
				println(translateWord(clientInput));
			} else {
				println(Errors.NOTALLWORDS.value);
			}
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private String translateWord(String clientInput)
	{
		String pigVersion = "";

		for (int i = 0; i < clientInput.length(); i++){
			for (int j = 0; j < DELIMITERS.length(); j++){
				Character ci = (Character) clientInput.charAt(i);
				if (ci.equals(DELIMITERS.charAt(j))){ 
					String token = clientInput.substring(i-1, i-1);
					int firstVowelPosition = findFirstVowelPosition(token);
					String head = clientInput.substring(i-1);
					pigVersion += ci; 
					break; 	
				}
			}
		}
		
		return pigVersion;
	}
	
	
	private int findFirstVowelPosition(String st)
	{
		
	}
	
	
	private boolean isAWord(String word)
	{
		if (word.length() == 0) { return false; } 
		for (int i = 0; i < word.length(); i++){
			boolean notUpperCase = word.charAt(i) < 65 || word.charAt(i) > 90;
			boolean notLowerCase = word.charAt(i) < 97 || word.charAt(i) > 122;
			boolean notDelimiter = true;
			
			for (int j = 0; j < DELIMITERS.length(); j++){
				Character ci = (Character) word.charAt(i);
				if (ci.equals(DELIMITERS.charAt(j))){ notDelimiter = false; break; }
			}
			
			if (notUpperCase && notLowerCase && notDelimiter){ return false; }
		}
		return true;
	}
	
	/* Instance variables */
	private String pigVersion = "";
}