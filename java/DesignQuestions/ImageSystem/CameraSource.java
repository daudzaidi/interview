package DesignQuestions.ImageSystem;

/**
 * Created by shalvi on 28/06/16.
 */
public class CameraSource extends ImageSource {
    @Override
    Image select() {
        System.out.println("Selected Image from ImageSource");
        return null;
    }
}
