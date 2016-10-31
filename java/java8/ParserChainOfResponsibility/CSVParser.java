package java8.ParserChainOfResponsibility;

/**
 * Created by shalvi on 23/06/16.
 */
public class CSVParser extends Parser{

    public CSVParser(Parser successor){
        this.setSuccessor(successor);
    }

    @Override
    public void parse(String fileName) {
        if ( canHandleFile(fileName, ".csv")){
            System.out.println("A CSV parser is handling the file: "+fileName);
        }
        else{
            super.parse(fileName);
        }
    }
}
