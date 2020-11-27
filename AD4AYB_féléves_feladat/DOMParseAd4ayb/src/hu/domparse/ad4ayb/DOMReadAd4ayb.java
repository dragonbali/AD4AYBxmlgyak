package hu.domparse.ad4ayb;

import java.io.File;
import java.util.Scanner;

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
         
         menu(doc);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   private static void ListAuto(Document doc) {
	   System.out.println("Minden autó:");
	   NodeList nList = doc.getElementsByTagName("auto");       
	   for (int temp = 0; temp < nList.getLength(); temp++) {
	      Node nNode = nList.item(temp);
	      System.out.println();
	      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	         Element eElement = (Element) nNode;
	         System.out.println("rendszam: " 
	            + eElement.getAttribute("rsz"));
	         System.out.println("ev: " 
	            + eElement
	            .getElementsByTagName("ev")
	            .item(0)
	            .getTextContent());
	         System.out.println("tipus: " 
	            + eElement
	            .getElementsByTagName("tipus")
	            .item(0)
	            .getTextContent());
	         System.out.println("ár : " 
	            + eElement
	            .getElementsByTagName("ar")
	            .item(0)
	            .getTextContent());
	      }
	   }
   }
   
   private static void ListGyarto(Document doc) {
	   System.out.println("Minden gyártó:");
	   NodeList nList = doc.getElementsByTagName("gyarto");       
	   for (int temp = 0; temp < nList.getLength(); temp++) {
	      Node nNode = nList.item(temp);
	      System.out.println();
	      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	         Element eElement = (Element) nNode;
	         System.out.println("id: " 
	            + eElement.getAttribute("id"));
	         System.out.println("nev: " 
		 	            + eElement
		 	            .getElementsByTagName("nev")
		 	            .item(0)
		 	            .getTextContent());
	         System.out.println("orszag: " 
	            + eElement
	            .getElementsByTagName("orszag")
	            .item(0)
	            .getTextContent());
	         System.out.println("varos: " 
	 	            + eElement
	 	            .getElementsByTagName("varos")
	 	            .item(0)
	 	            .getTextContent());
	      }
	   }
   }
   private static void ListKarosszeria(Document doc) {
	   System.out.println("Minden karosszeria:");
	   NodeList nList = doc.getElementsByTagName("karosszeria");       
	   for (int temp = 0; temp < nList.getLength(); temp++) {
	      Node nNode = nList.item(temp);
	      System.out.println();
	      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	         Element eElement = (Element) nNode;
	         System.out.println("id: " 
	            + eElement.getAttribute("id"));
	         System.out.println("kivitel: " 
		 	            + eElement
		 	            .getElementsByTagName("kivitel")
		 	            .item(0)
		 	            .getTextContent());
	         System.out.println("szin: " 
	            + eElement
	            .getElementsByTagName("szin")
	            .item(0)
	            .getTextContent());
	         System.out.println("ajtok száma: " 
	 	            + eElement
	 	            .getElementsByTagName("ajtok_szama")
	 	            .item(0)
	 	            .getTextContent());
	      }
	   }
   }
   private static void ListExtrak(Document doc) {
	   System.out.println("Minden extra:");
	   NodeList nList = doc.getElementsByTagName("extra");       
	   for (int temp = 0; temp < nList.getLength(); temp++) {
	      Node nNode = nList.item(temp);
	      System.out.println();
	      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	         Element eElement = (Element) nNode;
	         System.out.println("id: " 
	            + eElement.getAttribute("id"));
	         System.out.println("nev: " 
		 	            + eElement
		 	            .getElementsByTagName("nev")
		 	            .item(0)
		 	            .getTextContent());
	         System.out.println("hely: " 
	            + eElement
	            .getElementsByTagName("hely")
	            .item(0)
	            .getTextContent());
	      }
	   }
   }
   private static void ListMotor(Document doc) {
	   System.out.println("Minden motor:");
	   NodeList nList = doc.getElementsByTagName("motor");  	   
	   for (int temp = 0; temp < nList.getLength(); temp++) {
	      Node nNode = nList.item(temp);
	      System.out.println();
	      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	         Element eElement = (Element) nNode;
	         System.out.println("id: " 
	            + eElement.getAttribute("id"));
	         System.out.println("uzemanyag: " 
		 	            + eElement
		 	            .getElementsByTagName("uzemanyag")
		 	            .item(0)
		 	            .getTextContent());
	         System.out.println("hengeruertartalom: " 
	            + eElement
	            .getElementsByTagName("cc")
	            .item(0)
	            .getTextContent()
	         	+ "cm3");
	      }
	   }
   }
   
   
   private static void menu(Document doc) {
	@SuppressWarnings("resource")
	Scanner scann = new Scanner(System.in);
	System.out.println("az osszes auto listazasahoz nyomd meg az 1-est!");
	System.out.println("az osszes gyarto listazasahoz nyomd meg az 2-est!");
	System.out.println("az osszes karosszéria listazasahoz nyomd meg az 3-ast!");
	System.out.println("az osszes extrak listazasahoz nyomd meg az 4-est!");
	System.out.println("az osszes motor listazasahoz nyomd meg az 5-ost!");

	int menu = scann.nextInt();
	
	switch (menu) {
	case 1: {
		ListAuto(doc);
		break;
	}
	case 2: {
		ListGyarto(doc);
		break;
	}
	case 3: {
		ListKarosszeria(doc);
		break;
	}
	case 4: {
		ListExtrak(doc);
		break;
	}
	case 5: {
		ListMotor(doc);
		break;
	}
	default:
		menu(doc);
		break;
	}
	System.out.println();
}

}