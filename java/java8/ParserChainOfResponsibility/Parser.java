package java8.ParserChainOfResponsibility;

/**
 * Created by shalvi on 23/06/16.
 */
public class Parser {
    private Parser successor;

    public void parse(String file){
        if(getSuccessor()!=null){
            getSuccessor().parse(file);
        }
        else{
            System.out.println("Unable to find the correct parser for the file: "+file);
        }
    }

    public Parser getSuccessor(){
        return successor;
    }

    protected boolean canHandleFile(String file, String format){
        return (file == null || file.endsWith(format));
    }

    void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
