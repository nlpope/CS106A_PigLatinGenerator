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
			
			println(translateSentence(clientInput));
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private String translateSentence(String sentence)
	{
		String result = "";
		String trimmedSentence = sentence.trim() + " ";
		for (int i = 0,
				 j = 0; 
			     i < trimmedSentence.length(); 
			     i = j + 1){
			
			j = trimmedSentence.indexOf(" ", i);
			//breaking too early
			if (j == -1){ break; }
			result += translateWord(sentence.substring(i, j)) + " ";
			
			
			boolean upperCaseLetter = trimmedSentence.charAt(j) > 64 || trimmedSentence.charAt(j) < 91;
			boolean lowerCaseLetter = trimmedSentence.charAt(j) > 96 || trimmedSentence.charAt(j) < 123;
			while (!upperCaseLetter && !lowerCaseLetter){ j++; }
		}
		
		return result;
	}
	
	
	private String translateWord(String word)
	{	
		int vp = findFirstVowelPosition(word);
		if (vp == -1){ 
			return word;
		} else if (vp == 0){
			return word + "way";
		} else {
			String head = word.substring(0, vp);
			String tail = word.substring(vp);
			return tail + head + "ay";
		}
	}
	
	
	private int findFirstVowelPosition(String str)
	{
		str = str.toLowerCase();
		char[] vowels = new char[]{'a','e','i','o','u'};
		for (int i = 0; i < str.length(); i++){
			for (char c : vowels){
				if (str.charAt(i) == c){ return i; }
			}
		}
		
		return -1;
	}
	
	/* Instance variables */
	private String pigVersion = "";
}