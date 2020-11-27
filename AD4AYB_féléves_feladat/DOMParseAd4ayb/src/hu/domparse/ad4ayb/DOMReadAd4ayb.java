package hu.domparse.ad4ayb;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMReadAd4ayb {

   public static void main(String[] args) {

      try {
         File inputFile = new File("XMLAd4ayb.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("auto");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("rendszam: " 
                  + eElement.getAttribute("rsz"));
               System.out.println("ev " 
                  + eElement
                  .getElementsByTagName("ev")
                  .item(0)
                  .getTextContent());
               System.out.println("tipus: " 
                  + eElement
                  .getElementsByTagName("tipus")
                  .item(0)
                  .getTextContent());
               System.out.println("ar : " 
                  + eElement
                  .getElementsByTagName("ar")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}