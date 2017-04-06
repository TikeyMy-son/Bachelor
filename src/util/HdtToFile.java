/*
 *	Copyright by Ilgar Bosatov
 *
 *Klasse zum Einlesen von .conll Formaten
 *Tiger und HDT wurden mit dieser Klasse eingelesen.
 *
 *
 */

package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import util.TextabschnittAbschneiden;

public class HdtToFile {

	public static void umwandelnFormat(String endFile) {

		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;

		String endFileName = endFile;

		try {
			file = new File("/Users/ilgarboss/Documents/Informatik/BachelorArbeit/Korpora/HDT/part_C.conll");
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// neue File aufmachen
			fw = new FileWriter(endFileName);
			bw = new BufferedWriter(fw);

			String line = ""; // Variable fuer Zeile
			String selekt = "";
			String zusammenfuegen = ""; // Variable fuer die fertigen Saetze
			String zusammenfuegenZeichen = ""; // in dieser Variable wird fuer
												// Satzzeichen gespeichert, da
												// diese Variable im while Block
												// kein Leerzeichen (" ")
												// angehaengt bekommt.
			String endPuffer = ""; // Variable speichert das letzte Wort eines
									// Satzes

			// while Schleife fuer die ganze TextDatei: Gehe alle Zeilen durch
			while ((line = br.readLine()) != null) {
				// falls Leerzeile --> beende Satz, indem
				if (line.isEmpty()) {
					bw.write(zusammenfuegenZeichen + endPuffer);
					zusammenfuegen = "";
					zusammenfuegenZeichen = "";
					bw.newLine();
				}

				else {

					selekt = line;

					selekt = TextabschnittAbschneiden.substringAfter(selekt, "\t");
					Scanner scanner = new Scanner(selekt);

					String Wort = scanner.next();
					endPuffer = Wort;
					// bei , oder . oder : oder anderen Satzzeichen, soll KEIN
					// Leerzeichen dazukommen
					if (Wort.equals(",") || Wort.equals(".") || Wort.equals(":") || Wort.equals(";")
							|| Wort.equals("\"")) {

						zusammenfuegen = zusammenfuegenZeichen + Wort + " ";
					} else {

						zusammenfuegenZeichen = zusammenfuegen + Wort; // fuer
																		// Satzzeichen
						zusammenfuegen = zusammenfuegen + Wort + " "; // fuer
																		// ein
																		// normales
																		// Wort
					}

					scanner.close();
				}
			} // while schleife 1 zuende

			System.out.println("Die Textdatei \"" + endFileName + "\" wurde erstellt");

		} // Klammerende von try
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Schliesse alle Streams
				fr.close();
				br.close();

				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
