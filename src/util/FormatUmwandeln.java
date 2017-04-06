package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FormatUmwandeln {

	
	public static void umwandeln(String sourceFile, String nameNewFile){
		

		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		String nameEndfile = nameNewFile;				//erstelle eine neue ferige Datei, im .txt Format
		
		try{
			file = new File(sourceFile);				//Mach die einzulesende Datei auf
			fr = new FileReader(file);					//initialisiere die Reader
			br = new BufferedReader(fr);
			
			fw = new FileWriter(nameEndfile);
			bw = new BufferedWriter(fw);
			
			String line = "";							//Variable, in die die derzeitige eingescannte Zeile gespeichert wird. Wird nach jeder Schleife neu zwischengespeichert.
			
			
			
			
			
			
		}
		catch(Exception e){
			//do nothing on Exception
		}
		
		
	}
	
	
}
