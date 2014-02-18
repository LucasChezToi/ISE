package xml;

import ise.Flow;
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
   private List<Node> nodes;
   private List<Flow> flows;
   
   public XmlParser(String file) {
	   sxb = new SAXBuilder();
	   try {
		   document = sxb.build(new File(file));
	  } catch(Exception e){}
   }

  public String getNode(String id) {
	  racine = document.getRootElement();
	  racine.getChild(id);
	  return null;
  }
  
  List firstStep = racine.getChildren("??");
  
  Iterator i = firstStep.iterator();
  /*while(i.hasNext()) {
     Element courant = (Element)i.next();
     System.out.println(courant.getChild("??").getText());
      }
   }*/
}
