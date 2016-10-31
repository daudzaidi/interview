package java8.ParserChainOfResponsibility;

/**
 * Created by shalvi on 23/06/16.
 */
public class JSONParser extends Parser {

    public JSONParser(Parser successor){
        this.setSuccessor(successor);
    }

    @Override
    public void parse(String fileName) {
        if ( canHandleFile(fileName, ".json")){
            System.out.println("A JSON parser is handling the file: "+fileName);
        }
        else{
            super.parse(fileName);
        }

    }


}
