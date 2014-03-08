package xml;

import ise.Algorithm;
import ise.Flow;
import ise.Network;
import ise.Node;
import ise.Path;

import java.io.*;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe représentant le parseur afin de capturer les informations
 * contenues dans un fichier xml quelconque d'entrée
 */
public class XmlParser {
   private static org.jdom2.Document document;
   private static Element racine;
   private SAXBuilder sxb;
   private Network network;
   public static Logger logger = Logger.getLogger("xml.XmlParser");
   
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
		Handler fh;
		try {
			fh = new FileHandler("WorstCaseEndToEndResponse_Log.log");
			logger.addHandler(fh);
		} catch (SecurityException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   try {
		   document = sxb.build(new File(file));
	  } catch(Exception e){
		  logger.log(Level.WARNING, "Fonction : XmlParser"
		  		+ ", Classe : " + e.getClass().getName()
				+ ", Message : " + e.getMessage());
	  }
	   network = new Network();
   }
   
   /**
    * Parse les informations concernant le fichier xml d'entrée
    */
   public void parse() {
	   racine = document.getRootElement();
	   Element flows = document.getRootElement().getChild("flows");
	   Element links = document.getRootElement().getChild("links");
	   
	   for(Element e : flows.getChildren("flow")) {
		   Flow tempFlow = new Flow();
			network.addFlow(tempFlow);
		   tempFlow.setDeadline(Integer.parseInt(e.getChildText("deadline")));
			if(e.getChild("jitter") == null)
				tempFlow.setJitter(0);
			else 
				tempFlow.setJitter(Integer.parseInt(e.getChildText("jitter")));
			
			Path tempPath = new Path();
			for(Element e1 : e.getChild("path").getChildren()) {
				Node node = network.findNodeById(e1.getAttributeValue("id"));
				HashMap<Flow, Integer> capacity;
				if(node  == null){
					node = new Node();
					network.addNode(node);
					node.setId(e1.getAttributeValue("id"));
					capacity = new HashMap<Flow, Integer>();
					node.setCapacity(capacity);
				}
				capacity = node.getCapacity();
				capacity.put(tempFlow, Integer.parseInt(e1.getChildText("capacity")));
				tempPath.setNode(node);
				
			}
			tempFlow.setPath(tempPath);
			tempFlow.setId(e.getAttributeValue("id"));
			tempFlow.setDeadline(Integer.parseInt(e.getChildText("deadline")));
			tempFlow.setPeriod(Integer.parseInt(e.getChildText("period")));
			tempFlow.setPriority(Integer.parseInt(e.getChildText("priority")));
	   }
	   
	   network.setLmax(Integer.parseInt(links.getChildText("maxTime")));
	   network.setLmin(Integer.parseInt(links.getChildText("minTime")));
	   
	   for(Node node : network.getNodes()){
		   for(Flow flow : network.getFlows()){
			   if(node.getCapacity().get(flow) == null){
				   node.getCapacity().put(flow ,(Integer) 0);
			   }
		   }
	   }
	   
   }
   
  /**
   * Méthode pour le lancement de l'application
   * @param arg représente les entrées du système
   */
  public static void main (String [] arg) {
	  if(arg.length != 1) {
		  System.err.println("Aucun fichier en entrée référencé");
		  logger.log(Level.SEVERE, ", Classe : XmlParser"
				    + ", Fonction : main"
					+ ", Message : Aucun fichier en entrée du programme");
	  	  System.exit(0);
	  }
	  
	  if(!arg[0].contains(".xml")) {
		  System.err.println("Mauvais format de fichier (nécessite un fichier xml)");
		  logger.log(Level.SEVERE, "Classe : XmlParser"
				    + ", Fonction : main"
					+ ", Message : Fichier en entrée non reconnu (format xml attendu)");
	  	  System.exit(1);
	  }
	  
	  XmlParser parser = new XmlParser(arg[0]);
	  parser.parse();
	  
	  Network net = parser.getNetwork();
	  net.init();
	  Algorithm algo = new Algorithm(net);
	  algo.computeWorstCaseEndToEndResponse();
	  System.out.print("Done: ");
	  for(int r : algo.worstCasesResponseTime) {
		  System.out.print(r + " ");
	  }
	  System.out.println("");
  }
}
