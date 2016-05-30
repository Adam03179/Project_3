package main.java.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;


public class MyValidator {

    public static void main(String[] args) throws FileNotFoundException {
        validate(new File("src\\main\\resources\\Deposits.xml"),new FileInputStream(new File("src\\main\\resources\\Deposits.xsd")));
    }

    public static void validate(File xml, InputStream xsd) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            StreamSource xmlFile = new StreamSource(xml);
            validator.validate(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
