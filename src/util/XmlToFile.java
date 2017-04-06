/*
 *Java Klasse um TIGER Korpus Sätze auszulesen und in File abzuspeichern 
 */


package util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;



public class XmlToFile {

	public static void main(String[] args){
		 {
			
			
			
			 
		    try {
		    
		    FileWriter fw = new FileWriter("Text_zum_Eingeben.txt");
			BufferedWriter bw = new BufferedWriter(fw);	
			
			
			
			String zusammenbauen = "";		//hier werden die Sätze eingespeichert
			
			File fXmlFile = new File("/Users/ilgarboss/Documents/Informatik/BachelorArbeit/Korpora/short_TIGER.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			
			//http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

		//	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("terminals");
			
			for (int i = 0; i < nList.getLength(); i++) {// Gehe alle Sätze durch		A
				zusammenbauen = "";	//hier wird String immer wieder für einen neuen Satz zurueckgesetzt
				Node nNode = nList.item(i); // das sind die Sätze
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) nNode;
					NodeList nL = el.getElementsByTagName("t");		//das sind die einzelnen Woerter eines Satzes
					
					for(int j = 0; j< nL.getLength(); j++){			//gehe alle Woerter durch
						Node word = nL.item(j);
						
						if (word.getNodeType() == Node.ELEMENT_NODE){
							Element el1 = (Element) word;
							zusammenbauen = zusammenbauen + el1.getAttribute("word") + " ";
						}
						
					}//For Schleife innerhalb eines Satzes Ende
					bw.write(zusammenbauen);
					bw.newLine();
					//System.out.println("text wurde mehrmals erstellt");
				} 
			}//alle Saetze Ende															A
			bw.close();
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }
	}
}
