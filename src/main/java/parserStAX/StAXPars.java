package main.java.parserStAX;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXPars {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        List<Deposit> list = null;
        Deposit currDep = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(
                new FileInputStream("src\\main\\resources\\Deposits.xml"));

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
                            currDep.depositor.setAge(Byte.parseByte(tagContent));
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
                            currDep.amountOnDeposit.setDollars(Integer.parseInt(tagContent));
                            break;
                        case "hrivnas":
                            currDep.amountOnDeposit.setHrivnas(Integer.parseInt(tagContent));
                            break;
                        case "profitability":
                            currDep.setProfitability(Double.parseDouble(tagContent));
                            break;
                        case "days":
                            currDep.timeConstraints.setDays(Integer.parseInt(tagContent));
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
}
