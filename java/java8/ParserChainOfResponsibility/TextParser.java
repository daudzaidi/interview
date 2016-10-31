package java8.ParserChainOfResponsibility;

/**
 * Created by shalvi on 23/06/16.
 */
public class TextParser extends Parser {

    public TextParser(Parser successor){
        this.setSuccessor(successor);
    }

    @Override
    public void parse(String fileName) {
        if ( canHandleFile(fileName, ".txt")){
            System.out.println("A text parser is handling the file: "+fileName);
        }
        else{
            super.parse(fileName);
        }

    }
}
