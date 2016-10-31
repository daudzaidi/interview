package java8.ParserChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shalvi on 23/06/16.
 */
public class Demo {

    private static List<String> populateFiles(){

        List<String> fileList = new ArrayList<>();
        fileList.add("someFile.txt");
        fileList.add("otherFile.json");
        fileList.add("xmlFile.xml");
        fileList.add("csvFile.csv");
        fileList.add("csvFile.doc");

        return fileList;
    }

    public static void main(String... args){
        //List of file names to parse.
        List<String> fileList = populateFiles();

        //No successor for this handler because this is the last in chain.
        Parser xmlParser = new XMLParser();

        //XmlParser is the successor of CSVParser.
        Parser csvParser = new CSVParser(xmlParser);

        //CsvParser is the successor of JSONParser.
        Parser jsonParser = new JSONParser(csvParser);

        //JsonParser is the successor of TextParser.
        //TextParser is the start of the chain.
        Parser textParser = new TextParser(jsonParser);

        for ( String fileName : fileList){
            textParser.parse(fileName);
        }

    }

}
