package util;

public class SentenceCleanAndFormat {

	
	public SentenceCleanAndFormat(){
	}
	
	
	public String formatAndCleanUp(String sentence){
		
		sentence = sentence.replace("\" ", "\"");
		sentence = sentence.replace("( ", "(");
		sentence = sentence.replace(" )", ")");
		sentence = sentence.replace(" /", "/");
		//sentence = sentence.replace("/ ", "/");   braucht man diese Abfrage ? Geschmackssache!
		sentence = sentence.replace(" ??", "?");
		sentence = sentence.replace(" !!", "!");
		sentence = sentence.replace("::", ":");
		sentence = sentence.replace(";;", ";");
		sentence = sentence.replace(" .", ".");
		
		
		return sentence;
	}
}
