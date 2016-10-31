package DesignQuestions.ImageSystem;

/**
 * Created by shalvi on 28/06/16.
 */
public class Image {

    private int[][] imageMatrix;

    //initialize 2-D image with pixel information
    public Image(int[][] matrix){
        this.imageMatrix = matrix;
    }

    public int[][] getImage() {
        return imageMatrix;
    }
}
