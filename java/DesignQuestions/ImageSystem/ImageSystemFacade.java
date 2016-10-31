package DesignQuestions.ImageSystem;

/**
 * Created by shalvi on 28/06/16.
 */
public class ImageSystemFacade {

    InterfaceType type;

    public ImageSystemFacade(InterfaceType type){
        this.type = type;
    }

    public void open() {
       System.out.println(type+ " Opened");
    }

    public void close() {
        System.out.println(type+" Closed");
    }

    public void performOperation(ImageOperations operation,Tags tags){
        operation.perform(tags);
    }


}
