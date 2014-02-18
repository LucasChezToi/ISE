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
   }

  private void setFlows() {
	  racine = document.getRootElement();
	  for(Element e : racine.getChildren("flows")) {
		  Flow flow = new Flow();
		  try {
			flow.setDeadline(e.getAttribute("deadline").getIntValue());
		} catch (DataConversionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  flow.setJitter(0);
		  for(int i = 0; i < racine.getChildren("flows").size(); i++) {
			  Node node = new Node();
			  //node.setId(racine.getChildren("flows").get(i));
		  }
		  // A revoir ici la période = deadline
		  try {
			flow.setPeriod(e.getAttribute("deadline").getIntValue());
		} catch (DataConversionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			flow.setPriority(e.getAttribute("priority").getIntValue());
		} catch (DataConversionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  network.addFlow(flow);
	  }
  }
  
  List firstStep = racine.getChildren("??");
  
  Iterator i = firstStep.iterator();
  /*while(i.hasNext()) {
     Element courant = (Element)i.next();
     System.out.println(courant.getChild("??").getText());
      }
   }*/
}
