package java8.ParserChainOfResponsibility;

/**
 * Created by shalvi on 23/06/16.
 */
public class XMLParser extends Parser {

    @Override
    public void parse(String fileName) {
        if ( canHandleFile(fileName, ".xml")){
            System.out.println("A XML parser is handling the file: "+fileName);
        }
        else{
            super.parse(fileName);
        }
    }

}
