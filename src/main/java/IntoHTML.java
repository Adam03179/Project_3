package main.java;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class IntoHTML {


    public static void main(String[] args) {
        String xmlPath = "src\\main\\resources\\Deposits.xml";
        String xslPath = "src\\main\\resources\\Deposits.xsl";

        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource(xslPath);
            Source xmlDoc = new StreamSource(xmlPath);

            String outputFileName = "src\\main\\resources\\Deposit.html";

            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));

            System.out.println("Transformation your xsl to html file " +
                    "completed successfully!");
            System.out.println("You can find your html file in the" +
                    " next directory " + outputFileName);

        } catch (FileNotFoundException | TransformerFactoryConfigurationError
                | TransformerException e) {
            e.printStackTrace();
        }

    }
}
