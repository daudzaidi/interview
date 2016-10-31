package DesignQuestions.ImageSystem;

/**
 * Created by shalvi on 28/06/16.
 */
public class UploadImage implements ImageOperations {
    @Override
    public void perform(Tags tags) {
        StringBuilder builder= new StringBuilder();
        builder.append("[");
        for(String t : tags.tagList){
            builder.append(t);
            builder.append(",");
        }
        String v = builder.substring(0,builder.length()-1);
        System.out.println("Image Uploaded With tags ==>" +v+" ]");
    }
}
