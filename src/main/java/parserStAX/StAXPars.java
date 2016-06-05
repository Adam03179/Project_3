package main.java.parserStAX;

import main.java.parser_sax.SAXPars;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StAXPars {

    private static SAXParserFactory saxParserFactory
            = SAXParserFactory.newInstance();

    public static void main(String[] args) throws XMLStreamException,
            FileNotFoundException {
        String xmlPath = "src\\main\\resources\\Deposits.xml";

        try {

            String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
            Schema schema = xsdFactory.newSchema();

            if (!validate(xmlPath, schema)) {
                throw new SAXException("XML is not valid");
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }

        List<Deposit> list = null;
        Deposit currDep = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(
                new FileInputStream(xmlPath));

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {

                case XMLStreamConstants.START_ELEMENT:
                    if ("deposit".equals(reader.getLocalName())) {
                        currDep = new Deposit();
                        currDep.setId(reader.getAttributeValue(0));
                    }
                    if ("bank".equals(reader.getLocalName())) {
                        list = new ArrayList<>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "deposit":
                            list.add(currDep);
                            break;
                        case "name":
                            currDep.setName(tagContent);
                            break;
                        case "country":
                            currDep.setCountry(tagContent);
                            break;
                        case "type":
                            currDep.setType(tagContent);
                            break;
                        case "sex":
                            currDep.depositor.setSex(tagContent);
                            break;
                        case "age":
                            currDep.depositor.setAge
                                    (Byte.parseByte(tagContent));
                            break;
                        case "first_name":
                            currDep.depositor.setFirstName(tagContent);
                            break;
                        case "last_name":
                            currDep.depositor.setLastName(tagContent);
                            break;
                        case "account_id":
                            currDep.setAccount(Long.parseLong(tagContent));
                            break;
                        case "dollars_USA":
                            currDep.amountOnDeposit.setDollars
                                    (Integer.parseInt(tagContent));
                            break;
                        case "hrivnas":
                            currDep.amountOnDeposit.setHrivnas
                                    (Integer.parseInt(tagContent));
                            break;
                        case "profitability":
                            currDep.setProfitability
                                    (Double.parseDouble(tagContent));
                            break;
                        case "days":
                            currDep.timeConstraints.setDays
                                    (Integer.parseInt(tagContent));
                            break;
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;

            }

        }

        for (Deposit deposit : list) {
            System.out.println(deposit);
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
