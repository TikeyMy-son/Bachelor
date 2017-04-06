//...


package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceCheck {

	final String REGEX_ENDING = "(.*)*[a-zA-Z0-9]+(\\.{1}|\\;{1}|\\:{1}|\\\"{1}|\\!{1}|\\?{1})"; //nicht erlaubt: endet auf Terminalsymbol+Terminalsymbol oder auf Buchstaben ohne Terminalsymbol
	final String REGEX_CASE = "[^a-z]*|[^A-Z]*"; //Nicht erlaubt: 1) nur Großbuchstaben 2) nur Kleinbuchstaben
	
	Pattern pEnding; //Regex String compiler
	Pattern pCase;
	Matcher mEnding; //Matches with compiled Regex
	Matcher mCase;
	
	public SentenceCheck(){
		pEnding = Pattern.compile(REGEX_ENDING);
		pCase = Pattern.compile(REGEX_CASE);
	} 

	public boolean isSentenceRegex(String s){
		
		mCase = pCase.matcher(s);	  //prueft auf richtige Groß- und Kleinschreibung; true wenn Fehler gefunden wurde.
		mEnding = pEnding.matcher(s); //
		boolean isWrongCase = mCase.matches();
		System.out.println(isWrongCase);
		
		if(!isWrongCase){
			if(s.endsWith("//")){
				return false;
			}
			return mEnding.matches(); //true, wenn richtiges Satzende
		}
		return false;
	}
	
	public boolean isSentenceClassic(String s){
		
		if(
				(//Alle Fälle, die eintreten können
				s.endsWith(".") ||
				s.endsWith("?")  ||
				s.endsWith("\"")  ||
				s.endsWith(":")  ||
				s.endsWith(";")  ||
				s.endsWith("!")) &&
				(//Alle Fälle, die nicht eintreten dürfen
				!s.endsWith("..")   &&
				!s.endsWith("\"\"") &&
				!s.endsWith("??")   &&
				!s.endsWith("!!")   &&
				!s.endsWith(";;")   
				)
			){
			return true;
			
		}
		
		
		return false;
	}
	//GUT: ^([A-Za-z0-9_.&,-]++\\s*+)+
	//NOT: ^([A-Za-z0-9\\-\\_\\.\\&\\,]+[\\s]*)+
	
}
