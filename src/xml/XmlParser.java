package xml;

import ise.Flow;
import ise.Network;
import ise.Node;
import ise.Path;

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
   
   public Network getNetwork() {
	return network;
   }

   public void setNetwork(Network network) {
		this.network = network;
   }

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
	   racine = document.getRootElement();
	   Element flows = document.getRootElement().getChild("flows");
	   Element links = document.getRootElement().getChild("links");
	   
	   int flowNumber = 0;
	   for(Element e : flows.getChildren("flow")) {
		   Flow tempFlow = new Flow();
		   tempFlow.setDeadline(Integer.parseInt(e.getChildText("deadline")));
			if(e.getChild("jitter") == null)
				tempFlow.setJitter(0);
			else 
				tempFlow.setJitter(Integer.parseInt(e.getChildText("jitter")));
			
			Path tempPath = new Path();
			for(Element e1 : e.getChild("path").getChildren()) {
				Node node = new Node();
				node.setId(e1.getText());
				tempPath.setNode(node);
			}
			tempFlow.setPath(tempPath);
			tempFlow.setId(e.getText());
			tempFlow.setDeadline(Integer.parseInt(e.getChildText("deadline")));
			tempFlow.setPeriod(Integer.parseInt(e.getChildText("period")));
			tempFlow.setPriority(Integer.parseInt(e.getChildText("priority")));
			network.addFlow(tempFlow);
			/*System.out.println("Flow instance : " + flowNumber++);
			System.out.println("Deadline : " + tempFlow.getDeadline());
			System.out.println("Jitter : " + tempFlow.getJitter());
			System.out.println("Period : " + tempFlow.getPeriod());
			System.out.println("Priority : " + tempFlow.getPriority() + "\n");*/
	   }
	   network.setLmax(Integer.parseInt(links.getChildText("maxTime")));
	   network.setLmin(Integer.parseInt(links.getChildText("minTime")));
   }
   
  /**
   * Méthode pour la lancement de l'application
   * @param arg représente les entrées du système
   */
  public static void main (String [] arg) {
	  if(arg.length != 1) {
		  System.err.println("Aucun fichier en entrée référencé");
	  	  System.exit(0);
	  }
	  
	  if(!arg[0].contains(".xml")) {
		  System.err.println("Mauvais format de fichier (nécessite un fichier xml)");
	  	  System.exit(1);
	  }
	  XmlParser parser = new XmlParser(arg[0]);
	  parser.parse();
  }
}
