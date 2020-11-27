package hu.domparse.ad4ayb;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyAd4ayb2 {

	public static void main(String[] args) {

	      try {
	         File inputFile = new File("XMLAd4ayb.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         //  irtam egy menut a modify hoz valo navigalashoz
	         menu(doc);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	private static void menu(Document doc) throws TransformerException {
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		//a readben leirt menupontok
		System.out.println("Navigaljon el oda ahhol módosítást szeretne véghezvinni, majd írja be annak az id-ját!\n");
		DOMReadAd4ayb.menuText();	
		//string ként olvasom be így ha más stringet írnak be mint ami a menuben választható, 
		//akkor a default lép érványbe és kiirja, hogy wrong input, majd megivja megint a menut.
		//Minden menu hivas utan megjelenik menint a menu hogy ujabb lekerdeset csinaljunk,
		//ha q-t megnyomjunk ki tudunk lepni a programbol		
		String menu = scann.next();
		
		switch (menu) {
		case "1": {
			//a readben levo kiiratast hasznalom
			DOMReadAd4ayb.ListAuto(doc);
			//bekerem a valtoztatashoz szukseges adatokat
			String id = valasztas();
			String element = valasztas2();
			String newElement = valasztas3();
			//atadom a bekert adatokat
			ModifyAuto(id, element, newElement, doc);
			//ismet meghivodik a menu
			DOMReadAd4ayb.ListAuto(doc);
			menu(doc);
			break;
		}
		case "2": {
			//a readben levo kiiratast hasznalom
			DOMReadAd4ayb.ListGyarto(doc);
			//bekerem a valtoztatashoz szukseges adatokat
			String id = valasztas();
			String element = valasztas2();
			String newElement = valasztas3();
			//atadom a bekert adatokat
			ModifyGyarto(id, element, newElement, doc);
			System.out.println("megtortent a modositas");
			//ismet meghivodik a menu
			menu(doc);
			break;
		}
		case "3": {
			//a readben levo kiiratast hasznalom
			DOMReadAd4ayb.ListKarosszeria(doc);
			//bekerem a valtoztatashoz szukseges adatokat
			String id = valasztas();
			String element = valasztas2();
			String newElement = valasztas3();
			//atadom a bekert adatokat
			ModifyKarosszeria(id, element, newElement, doc);
			System.out.println("megtortent a modositas");
			//ismet meghivodik a menu
			menu(doc);
			break;
		}
		case "4": {
			//a readben levo kiiratast hasznalom
			DOMReadAd4ayb.ListExtrak(doc);
			//bekerem a valtoztatashoz szukseges adatokat
			String id = valasztas();
			String element = valasztas2();
			String newElement = valasztas3();
			//atadom a bekert adatokat
			ModifyExtrak(id, element, newElement, doc);
			System.out.println("megtortent a modositas");
			//ismet meghivodik a menu
			menu(doc);
			break;
		}
		case "5": {
			//a readben levo kiiratast hasznalom
			DOMReadAd4ayb.ListMotor(doc);
			//bekerem a valtoztatashoz szukseges adatokat
			String id = valasztas();
			String element = valasztas2();
			String newElement = valasztas3();
			//atadom a bekert adatokat
			ModifyMotor(id, element, newElement, doc);
			System.out.println("megtortent a modositas");
			//ismet meghivodik a menu
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

	//motor adat módosítás
	private static void ModifyMotor(String id, String element, String newElement, Document doc) throws TransformerException {
		NodeList nList = doc.getElementsByTagName("motor");   
		   for (int temp = 0; temp < nList.getLength(); temp++) {
		      Node nNode = nList.item(temp);
		      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		         Element eElement = (Element) nNode;
		           if (eElement.getAttribute("id").equals(id)) {
		        	   eElement.getElementsByTagName(element).item(0).setTextContent(newElement);
				} 
		     }
		   }
		   CreateXML(doc);	
		
	}

	//extrák adat módosítás
	private static void ModifyExtrak(String id, String element, String newElement, Document doc) throws TransformerException {
		NodeList nList = doc.getElementsByTagName("extra");   
		   for (int temp = 0; temp < nList.getLength(); temp++) {
		      Node nNode = nList.item(temp);
		      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		         Element eElement = (Element) nNode;
		           if (eElement.getAttribute("id").equals(id)) {
		        	   eElement.getElementsByTagName(element).item(0).setTextContent(newElement);
				} 
		     }
		   }
		   CreateXML(doc);		
	}

	//karosszeria adat módosítás
	private static void ModifyKarosszeria(String id, String element, String newElement, Document doc) throws TransformerException {
		NodeList nList = doc.getElementsByTagName("karosszeria");   
		   for (int temp = 0; temp < nList.getLength(); temp++) {
		      Node nNode = nList.item(temp);
		      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		         Element eElement = (Element) nNode;
		           if (eElement.getAttribute("id").equals(id)) {
		        	   eElement.getElementsByTagName(element).item(0).setTextContent(newElement);
				} 
		     }
		   }
		   CreateXML(doc);	
		
	}

	//gyarto adat módosítás
	private static void ModifyGyarto(String id, String element, String newElement, Document doc) throws TransformerException {
		NodeList nList = doc.getElementsByTagName("gyarto");   
		   for (int temp = 0; temp < nList.getLength(); temp++) {
		      Node nNode = nList.item(temp);
		      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		         Element eElement = (Element) nNode;
		           if (eElement.getAttribute("id").equals(id)) {
		        	   eElement.getElementsByTagName(element).item(0).setTextContent(newElement);
				} 
		     }
		   }
		   CreateXML(doc);	
	}

	//auto adat módosítás
	private static void ModifyAuto(String id, String element, String newElement, Document doc) throws TransformerException {
		 NodeList nList = doc.getElementsByTagName("auto");   
		   for (int temp = 0; temp < nList.getLength(); temp++) {
		      Node nNode = nList.item(temp);
		      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		         Element eElement = (Element) nNode;
		           if (eElement.getAttribute("rsz").equals(id)) {
		        	   eElement.getElementsByTagName(element).item(0).setTextContent(newElement);
				} 
		     }
		   }
		   CreateXML(doc);
	}
	
	//uj XML dokumentumba taroljuk a modositasokat(a regiekkel egyutt persze)
	public static void CreateXML(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("XMLAd4ayb.updated.xml"));
        transformer.transform(source, result);
	}

	//bekérés
	private static String valasztas() {
		System.out.println("irja az id-t ahol modositani szeretne!");
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		String menu = scann.next();
		return menu;
		
	}
	
	//bekérés
	private static String valasztas2() {
		System.out.println("addja meg azt az adattagot, amit modositani szeretne!");
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		String menu = scann.next();
		return menu;
		
	}
	
	//bekérés
	private static String valasztas3() {
		System.out.println("addja meg, hogy mire modositana!");
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		String menu = scann.next();
		return menu;
		
	}
}
