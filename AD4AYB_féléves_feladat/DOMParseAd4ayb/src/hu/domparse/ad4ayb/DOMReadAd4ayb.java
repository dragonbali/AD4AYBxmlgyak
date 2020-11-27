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
         //lent csináltam egy "menut" ahol egy switch el lehet a "lépkedni"
         menu(doc);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   //kilistazza az osszes autot ami szerepel az XML ben
   public static void ListAuto(Document doc) {
	   System.out.println("\nMinden autó:");
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
	            .getTextContent()
	            + "Ft" );
	      }
	   }
   }
   
   //kilistazza az osszes gyartot ami szerepel az XML ben
   public static void ListGyarto(Document doc) {
	   System.out.println("\nMinden gyártó:");
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
   
   //kilistazza az osszes karosszeriat ami szerepel az XML ben
   public static void ListKarosszeria(Document doc) {
	   System.out.println("\nMinden karosszeria:");
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
   
   //kilistazza az osszes extrat ami szerepel az XML ben
   public static void ListExtrak(Document doc) {
	   System.out.println("\nMinden extra:");
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
   
   //kilistazza az osszes mototrt ami szerepel az XML ben
   public static void ListMotor(Document doc) {
	   System.out.println("\nMinden motor:");
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
   
   //ez a main ben hivodik meg, ahol atadom neki a Document-et hogy a switchen belul at tudjam adni az
   //adott fugvenynek.
   private static void menu(Document doc) {
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		menuText();	
		//string ként olvasom be így ha más stringet írnak be mint ami a menuben választható, 
		//akkor a default lép érványbe és kiirja, hogy wrong input, majd megivja megint a menut.
		//Minden menu hivas utan megjelenik menint a menu hogy ujabb lekerdeset csinaljunk,
		//ha q-t megnyomjunk ki tudunk lepni a programbol
		
		String menu = scann.next();
		
		switch (menu) {
		case "1": {
			ListAuto(doc);
			System.out.println();
			menu(doc);
			break;
		}
		case "2": {
			ListGyarto(doc);
			System.out.println();
			menu(doc);
			break;
		}
		case "3": {
			ListKarosszeria(doc);
			System.out.println();
			menu(doc);
			break;
		}
		case "4": {
			ListExtrak(doc);
			System.out.println();
			menu(doc);
			break;
		}
		case "5": {
			ListMotor(doc);
			System.out.println();
			menu(doc);
			break;
		}
		case "q": {
			break;
		}
		default:
			System.out.println("Wrong input!");
			menu(doc);
			break;
		}
   }

   //ahhoz hogy ne kelljen megint leirni a modifyban.
	public static void menuText() {
		System.out.println("az osszes auto listazasahoz nyomd meg az 1-est!");
		System.out.println("az osszes gyarto listazasahoz nyomd meg az 2-est!");
		System.out.println("az osszes karosszéria listazasahoz nyomd meg az 3-ast!");
		System.out.println("az osszes extrak listazasahoz nyomd meg az 4-est!");
		System.out.println("az osszes motor listazasahoz nyomd meg az 5-ost!");
		System.out.println("----------------");
		System.out.println("kilepeshez nyomja meg a q-t");
		
	}
}