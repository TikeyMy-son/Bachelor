package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SentenceFilter {
	public static void sentenceFilter(){
		/*
		 * File Streams oeffnen (Eingabetext, Ergebnis, Verworfen)
		 */

		String endFileVerworfen = "resources/results/Verworfen_TIGER.txt";
		String endFile = "resources/results/Ergebnis_TIGER.txt";
		String source = "resources/text/Tiger_Saetze.txt";

		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fwResult = null;
		FileWriter fwAbort = null;
		BufferedWriter bwResult = null;
		BufferedWriter bwAbort = null;

		try {
			file = new File(source);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// neue File aufmachen
			fwResult = new FileWriter(endFile);
			fwAbort = new FileWriter(endFileVerworfen);
			bwResult = new BufferedWriter(fwResult);
			bwAbort = new BufferedWriter(fwAbort);

			SentenceCheck checker = new SentenceCheck();
			SentenceCleanAndFormat fp = new SentenceCleanAndFormat();

			String line = ""; // Variable fuer Zeile

//			// while Schleife fuer die ganze TextDatei: Gehe alle Zeilen durch
			while ((line = br.readLine()) != null) {
				line = fp.formatAndCleanUp(line);
				boolean isSentence = checker.isSentenceClassic(line);
				System.out.print("Cecking line \""+line+"\" ..");
				if (isSentence) {
					/*
					 * falls true, ist das richtiger Satz und wird in Ergebnisfile geschrieben
					 * sonst: schreibe Verworfenen Nichtsatz in VerworfenFile.
					 */
					
					bwResult.write(line);
					bwResult.newLine();
					
				}else {
					
					System.out.println("ABORT");
					bwAbort.write(line);
					bwAbort.newLine();
				}
			}
			
//			String[]tests = {
//					"Dies ist ein Satz.",
//					"Dies ist kein Satz",
//					"Dies ist auch keiner..",
//					"Nope??",
//					"Yes;",
//					"Oh ja !",
//					"Oh nein!!",
//					"neue endung ;!"
//					};
//			for(String t: tests){
//				System.out.println(t+" "+checker.isSentenceClassic(t));
//			}
			

			bwResult.close();
			bwAbort.close();
			
			// umwandelnFormat("HDT_C.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
