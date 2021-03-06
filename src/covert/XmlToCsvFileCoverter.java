package covert;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlToCsvFileCoverter {

    public void convertXmlToCsvFile(String xmlFilePath, String xslFilePath, String outputFilePath) {
        try{
            //Creating a File object
            File file = new File(outputFilePath);
            //Creating the directory
            if(file.mkdir()){
                System.out.println("Output directory created successfully");
            }
            File stylesheet = new File(xslFilePath);
            File xmlSource = new File(xmlFilePath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlSource);

            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
            Source source = new DOMSource(document);
            Result outputTarget = new StreamResult(new File(outputFilePath));
            transformer.transform(source, outputTarget);
            System.out.println("File Converted Successfully !!!");
        }
        catch(Exception e) {
            System.out.println("Error thrown while converting .xls File. "+e.getMessage());
        }
    }

}
