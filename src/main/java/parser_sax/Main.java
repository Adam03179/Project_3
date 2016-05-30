package main.java.parser_sax;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args){
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXPars pars = new SAXPars();

            try {
                saxParser.parse(new File("src\\main\\resources\\Deposits.xml"), pars);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Deposit r : pars.list) {
                System.out.println(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
