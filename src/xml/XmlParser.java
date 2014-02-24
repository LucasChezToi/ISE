package xml;

import ise.Flow;
import ise.Network;
import ise.Node;

import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.filter.*;
import org.jdom2.input.SAXBuilder;

import java.util.List;
import java.util.Iterator;

/**
 * Classe représentant le parseur afin de capturer les informations
 * contenues dans un fichier xml quelconque d'entrée
 */
public class XmlParser {
   private static org.jdom2.Document document;
   private static Element racine;
   private SAXBuilder sxb;
   private Network network;
   
   /**
    * Contructeur de la classe
    * @param file  représente le nom du fichier d'entrée
    */
   public XmlParser(String file) {
	   sxb = new SAXBuilder();
	   try {
		   document = sxb.build(new File(file));
	  } catch(Exception e){}
	   network = new Network();
   }
   
   /**
    * Parse les informations concernant le fichier xml d'entrée
    */
   public void parse() {
	   racine = document.getRootElement().getChild("flows");
		  for(Element e : racine.getChildren("flow")) {
			  Flow tempFlow = new Flow();
			  tempFlow.setDeadline(Integer.parseInt(e.getChildText("deadline")));
			  tempFlow.setJitter(0);
			  for(Element e1 : e.getChild("path").getChildren()) {
				  Node node = new Node();
				  node.setId(Integer.parseInt(e1.getText()));
			  }
			  // Période = Deadline
			  tempFlow.setPeriod(Integer.parseInt(e.getChildText("deadline")));
			  tempFlow.setPriority(Integer.parseInt(e.getChildText("priority")));
			  network.addFlow(tempFlow);
		  }
   }
  
  /**
   * Méthode pour la lancement de l'application
   * @param arg représente les entrées du système
   */
  public static void main (String [] arg) {
	  if(arg.length == 0) {
		  System.err.println("Aucun fichier xml en entrée référencé");
	  	  System.exit(0);
	  }
	  
	  if(!arg[0].contains(".xml")) {
		  System.err.println("Mauvais format de fichier (nécessite un fichier xml)");
	  	  System.exit(0);
	  }
	  XmlParser parser = new XmlParser(arg[0]);
	  parser.parse();
  }
}