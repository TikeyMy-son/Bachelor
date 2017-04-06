/*
 * (Daseinsberechtigung der Klasse:
 * tuebadz.conll hat keine UTF-8 Erkennung, sodass keine Umlaute in der Datei auftauchen. Ich benutze daher die tuebadz.xml,
 * da dort die Umlaute richtig stehen.)
 * 
 * TuebadzToFile.java liest die tuebadz.xml Datei ein, formt den Inhalt nach Sätze richtig um und speichert das Ergebnis in eine
 * neue Datei mit dem Namen "Tübadz_Sätze.txt"
 * 
 */


package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TuebadzToFile {
	
	
	public static void main(String[] args){

		
	//	File file = null;
		//FileReader fr = null;
		//FileInputStream fis = null;
		//InputStreamReader isr = null;
		BufferedReader br = null;
		
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		String txtFileName = "Tübaz_Sätze_komplett_testen.txt";		//Name der Ergebnisdatei
		
	        try
	        {
	        	String pfad = "/Users/ilgarboss/Documents/Informatik/BachelorArbeit/Korpora/TÜBADZ/tuebadz-10.0-exportXML-v2 Anf_zeichen_korrigiert.xml";
	            FileInputStream fis = new FileInputStream(pfad);
	            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	            br = new BufferedReader(isr);
	            
	          //neue File aufmachen
	            fw = new FileWriter(txtFileName);
	            bw = new BufferedWriter(fw);
	            
	            
	            String line = "";		//Variable fuer Zeile
	            String token = "";
	            String zusammenfuegen = "";	//Variable fuer die fertigen Saetze
	            String zusammenfuegenOhneLeerzeichen = "";
	            
	            //lies Zeile für Zeile durch und hoere erst auf, wenn EOF erreicht wurde.
	            while((line = br.readLine()) != null){	
	            	
	            	
	            	//pruefe ob die Zeile ein benoetigtes Satztoken enthaelt. benoetigt werden Zeilen, in denen "word" UND "form" zusammen stehen.
	            	if(line.contains("<word") && line.contains("form=")){
	            		
	            		
	            		//speicher die Zeile sowohl in "line", als auch in "token" zum Arbeiten
	            		token = line;
	            		 	            		
	            		token = TextabschnittAbschneiden.substringBefore(line,"\" pos=");		//schneide alles HINTER dem benoetigten Satztoken ab
	            		token = TextabschnittAbschneiden.substringAfter(token,"form=\"");		//schneide alles VOR dem benoetigten Satztoken ab
	            		//"token" beinhaltet jetzt das benoetigte Satztoken
	            		
	            		
	            		//ab hier geht es darum, mit dem Satztoken zu arbeiten
	            		//als erstes: ist es ein Wort oder ein Satzzeichen?
	            		
	            			if(token.equals(".") || token.equals(",") || token.equals("?") ||
	            				token.equals("!") || token.equals(":") || token.equals(";") || 
	            				token.equals("\"") || token.equals("/")){
	            				
	            				zusammenfuegen = zusammenfuegenOhneLeerzeichen + token;
	            				
	            			}
	            			else{
	            				
	            				zusammenfuegenOhneLeerzeichen = zusammenfuegen + token;
	            				zusammenfuegen = zusammenfuegen + token + " ";
	            			

	            			}
		  	            
	            	}
	            	else if(line.contains("</sentence")){
	            		
	            		zusammenfuegen = zusammenfuegen + "\n";
	            		
	            /*T		//da jetzt durch alle Satztoken ein ganzer Satz geschrieben wurde,
	            		//kann man diesen Satz nach Satzzeichen kontrollieren und den Satz "richtig" stellen, dh also
	            		//statt "das ist ein Beispiel,nur ein Beispiel" --> soll "das ist ein Beispiel, nur ein Beispiel", also
	            		//das nach einem Komma ein Leerzeichen folgt und...
	            			            		
	            		if(zusammenfuegen.contains(",")){
	            			
	            			int position = zusammenfuegen.indexOf(',');
	            			int positionEnde = zusammenfuegen.indexOf('\n');
	            			String satz = zusammenfuegen.substring(0, position) + " " + zusammenfuegen.substring(positionEnde); 

	            			
	            			
	            		}
	            */		bw.write(zusammenfuegen);											
	            		zusammenfuegen = "";
	            		zusammenfuegenOhneLeerzeichen = "";
	            		
	            	}
	            }
	       
	        System.out.println("Die Textdatei \"" + txtFileName + "\" wurde erstellt");

	        }
	        catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	            	//Schliesse alle Streams
	            	
	            	
	                br.close();
	               // fr.close();
	                bw.close();
	            }
	            catch (IOException e)
	            {
	            	e.printStackTrace();
	            }
	        }
	}
	
	
}