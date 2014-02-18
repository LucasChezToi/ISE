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

public class XmlParser {
   private static org.jdom2.Document document;
   private static Element racine;
   private SAXBuilder sxb;
   private Network network;
   
   public XmlParser(String file) {
	   sxb = new SAXBuilder();
	   try {
		   document = sxb.build(new File(file));
	  } catch(Exception e){}
	   network = new Network();
	   setFlows();
   }

  private void setFlows() {
	  racine = document.getRootElement().getChild("flows");
	  for(Element e : racine.getChildren("flow")) {
		  Flow flow = new Flow();
		  System.out.println(e.getChildText("deadline"));
		  flow.setDeadline(Integer.parseInt(e.getChildText("deadline")));
		  flow.setJitter(0);
		  for(int i = 0; i < racine.getChildren("flows").size(); i++) {
			  Node node = new Node();
			  //node.setId(racine.getChildren("flows").get(i));
		  }
		  // A revoir ici la période = deadline
		  flow.setPeriod(Integer.parseInt(e.getChildText("deadline")));
		
		  flow.setPriority(Integer.parseInt(e.getChildText("priority")));
		  network.addFlow(flow);
	  }
  }
  
  //List firstStep = racine.getChildren("??");
  
  //Iterator i = firstStep.iterator();
  /*while(i.hasNext()) {
     Element courant = (Element)i.next();
     System.out.println(courant.getChild("??").getText());
      }
   }*/
  
  public static void main (String [] arg) {
	  XmlParser parser = new XmlParser("/home/raphael/M2_SAR/ISE/ISE/xml/example1.xml");
  }
}
