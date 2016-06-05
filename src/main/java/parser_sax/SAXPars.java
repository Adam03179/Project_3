package main.java.parser_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXPars extends DefaultHandler {
    private String thisElement;
    public List<Deposit> list = new ArrayList<>();
    private Deposit deposit = new Deposit();
    private boolean isValid;

    public SAXPars() {
        isValid = true;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public Deposit getResult() {
        return deposit;
    }


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Starting parse XML...");
    }


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        thisElement = qName;

        if (thisElement.equals("deposit")) {
            deposit = new Deposit();
            deposit.setId(attributes.getValue(0));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (thisElement.equals("name")) {
            deposit.setName(new String(ch, start, length));
        }

        if (thisElement.equals("country")) {
            deposit.setCountry(new String(ch, start, length));
        }

        if (thisElement.equals("type")) {
            deposit.setType(new String(ch, start, length));
        }

        if (thisElement.equals("sex")) {
            deposit.depositor.setSex(new String(ch, start, length));
        }

        if (thisElement.equals("age")) {
            deposit.depositor.setAge(new Byte(new String(ch, start, length)));
        }

        if (thisElement.equals("first_name")) {
            deposit.depositor.setFirstName(new String(ch, start, length));
        }

        if (thisElement.equals("last_name")) {
            deposit.depositor.setLastName(new String(ch, start, length));
        }

        if (thisElement.equals("account_id")) {
            deposit.setAccount(new Long(new String(ch, start, length)));
        }

        if (thisElement.equals("testSpace:dollars_USA")) {
            deposit.amountOnDeposit.setDollars(new Integer
                    (new String(ch, start, length)));
        }

        if (thisElement.equals("testSpace:hrivnas")) {
            deposit.amountOnDeposit.setHrivnas(new Integer(
                    new String (ch, start, length)));
        }

        if (thisElement.equals("profitability")) {
            deposit.setProfitability(new Double(
                    new String (ch, start, length)));
        }

        if (thisElement.equals("days")) {
            deposit.timeConstraints.setDays(new Integer(
                    new String(ch, start, length)));
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        thisElement = "";

        if (qName.equals("deposit")) {
            list.add(getResult());
        }
    }


    @Override
    public void endDocument() throws SAXException {
        System.out.println("Stopping parse XML...");
    }
}

