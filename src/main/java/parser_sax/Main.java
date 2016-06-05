package main.java.parser_sax;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    private static SAXParserFactory saxParserFactory
            = SAXParserFactory.newInstance();


    public static void main(String[] args) {

        String xmlPath = "src\\main\\resources\\Deposits.xml";

        try {
            String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
            Schema schema = xsdFactory.newSchema();

            saxParserFactory.setSchema(schema);
            saxParserFactory.setNamespaceAware(true);

            if (!validate(xmlPath, schema)) {
                throw new SAXException();
            }

            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXPars pars = new SAXPars();


            saxParser.parse(new File(xmlPath), pars);

            for (Deposit r : pars.list) {
                System.out.println(r);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }

    public static boolean validate(String xmlFileName, Schema schema) {
        SAXParser parser;
        SAXPars handler;

        try {
            saxParserFactory.setSchema(schema);
            saxParserFactory.setNamespaceAware(true);

            parser = saxParserFactory.newSAXParser();
            handler = new SAXPars();

            parser.parse(xmlFileName, handler);

            return handler.isValid();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("XML is not valid");
            e.printStackTrace();
        }

        return false;
    }
}
