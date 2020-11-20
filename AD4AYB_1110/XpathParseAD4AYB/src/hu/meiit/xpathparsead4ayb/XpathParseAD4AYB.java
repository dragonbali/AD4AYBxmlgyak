package hu.meiit.xpathparsead4ayb;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathParseAD4AYB {
	
	public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src\\hu\\meiit\\xpathparsead4ayb\\student.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();



            /*List<String> names = getStudentsNames(doc, xpath);
            System.out.println(names);*/
            
            NodeList allElements = (NodeList)xpath.evaluate("//*", doc, XPathConstants.NODESET);

            ArrayList<String> elementNames = new ArrayList<>();
            ArrayList<String> elementValues = new ArrayList<>();

            for (int i = 0; i < allElements.getLength(); i++)
            {
                Node currentElement = allElements.item(i);
                elementNames.add(i, currentElement.getLocalName());
                elementValues.add(i, xpath.evaluate("*", currentElement, XPathConstants.NODE) != null ? null : currentElement.getTextContent());
            }

            for (int i = 0; i < elementNames.size(); i++)
            {
                System.out.println(elementNames.get(i) + "   value: " + (elementValues.get(i)));
            }

          
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }

    }




    private static List<String> getStudentsNames(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
       
        try {
			String name = (String) xpath.evaluate("//*", doc, XPathConstants.STRING);	
			list.add(name);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
    }


   


}
