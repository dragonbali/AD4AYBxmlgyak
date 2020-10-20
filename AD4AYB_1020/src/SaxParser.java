import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParser {

   public static void main(String[] args) {

      try {
         File inputFile = new File("szemelyek.xml");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         Handler handler = new Handler();
         saxParser.parse(inputFile, handler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}
