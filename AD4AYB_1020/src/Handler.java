import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

   boolean bnev = false;
   boolean bvaros = false;
   boolean bkor = false;

   @Override
   public void startElement(String uri, 
   String localName, String qName, Attributes attributes) throws SAXException {

	   if (qName.equalsIgnoreCase("szemelyek")) {
		   System.out.println("START-szemelyek" );
	  } else if (qName.equalsIgnoreCase("szemely")) {
    	  System.out.print(" START-szemely" );
         String id = attributes.getValue("id");
         System.out.println(" {ID: " +  id + "}");
      } else if (qName.equalsIgnoreCase("nev")) {
         bnev = true;
         System.out.println("   START-nev" );
      } else if (qName.equalsIgnoreCase("varos")) {
         bvaros = true;
         System.out.println("   START-varos" );
      } else if (qName.equalsIgnoreCase("kor")) {
         bkor = true;
         System.out.println("   START-kor" );
      }
   }

   @Override
   public void endElement(String uri, 
   String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("szemelyek")) {
        	System.out.println("END-szemelyek");
		} else if (qName.equalsIgnoreCase("szemely")) {
         System.out.println(" END-szemely");
      } else if (qName.equalsIgnoreCase("nev")) {
    	  System.out.println("   END-nev");
	} else if (qName.equalsIgnoreCase("kor")) {
		System.out.println("   END-kor");
	}else if (qName.equalsIgnoreCase("varos")) {
		System.out.println("   END-varos");
	}
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {
      
      if (bnev) {
         System.out.println("     nev: " 
            + new String(ch, start, length));
         bnev = false;
      } else if (bvaros) {
         System.out.println("     varos: " + new String(ch, start, length));
         bvaros = false;
      }else if (bkor) {
         System.out.println("     kor: " + new String(ch, start, length));
         bkor = false;
      }
   }
}