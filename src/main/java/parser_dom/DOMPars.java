package main.java.parser_dom;

import main.java.parser_sax.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMPars {
    public static List<Deposit> list = new ArrayList<>();
    private static int i = -1, j = -1, k = -1, m = -1;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse(new File("src\\main\\resources\\Deposits.xml"));


        String titleEl = doc.getDocumentElement().getNodeName();

        NodeList nodeList1 = doc.getElementsByTagName("deposit");
        NodeList nodeList2 = doc.getElementsByTagName("depositor");
        NodeList nodeList3 = doc.getElementsByTagName("amount_on_deposit");
        NodeList nodeList4 = doc.getElementsByTagName("time_constraints");

        String id = "", name = "", country = "", type = "", sex = "", firstName = "", lastName = "";
        int dollars = 0, hrivnas = 0, days = 0;
        byte age = 0;
        long account = 0;
        double profitability = 0.0;


        while (i < nodeList1.getLength() - 1) {
            i++;
            Element element1 = (Element) nodeList1.item(i);

            id = element1.getAttributes().getNamedItem("id").getNodeValue();
            name = element1.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
            country = element1.getElementsByTagName("country").item(0).getChildNodes().item(0).getNodeValue();
            type = element1.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue();
            account = Long.parseLong(element1.getElementsByTagName("account_id").item(0).getChildNodes().item(0).getNodeValue());
            profitability = Double.parseDouble(element1.getElementsByTagName("profitability").item(0).getChildNodes().item(0).getNodeValue());

            if (j < nodeList2.getLength()) {
                j++;

                Element element2 = (Element) nodeList2.item(j);

                sex = element2.getElementsByTagName("sex").item(0).getChildNodes().item(0).getNodeValue();
                age = Byte.parseByte(element2.getElementsByTagName("age").item(0).getChildNodes().item(0).getNodeValue());
                firstName = element2.getElementsByTagName("first_name").item(0).getChildNodes().item(0).getNodeValue();
                lastName = element2.getElementsByTagName("last_name").item(0).getChildNodes().item(0).getNodeValue();

            }

            if (k < nodeList3.getLength()) {
                k++;

                Element element3 = (Element) nodeList3.item(k);

                    hrivnas = Integer.parseInt(element3.getElementsByTagName("hrivnas").item(0).getChildNodes().item(0).getNodeValue());
                    dollars = Integer.parseInt(element3.getElementsByTagName("dollars_USA").item(0).getChildNodes().item(0).getNodeValue());



            }

            if (m < nodeList4.getLength()) {
                m++;

                Element element4 = (Element) nodeList4.item(m);

                days = Integer.parseInt(element4.getElementsByTagName("days").item(0).getChildNodes().item(0).getNodeValue());

            }

            Deposit deposit = new Deposit();
            deposit.setId(id);
            deposit.setName(name);
            deposit.setCountry(country);
            deposit.setType(type);
            deposit.setAccount(account);
            deposit.setProfitability(profitability);
            deposit.depositor.setSex(sex);
            deposit.depositor.setAge(age);
            deposit.depositor.setFirstName(firstName);
            deposit.depositor.setLastName(lastName);
            deposit.amountOnDeposit.setDollars(dollars);
            deposit.amountOnDeposit.setHrivnas(hrivnas);
            deposit.timeConstraints.setDays(days);

            list.add(deposit);

        }


        for (Deposit r : list) {
            System.out.println(r);
        }


    }
}
