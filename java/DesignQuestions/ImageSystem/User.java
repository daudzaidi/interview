package DesignQuestions.ImageSystem;

import java.util.ArrayList;

/**
 * Created by shalvi on 28/06/16.
 */
public class User {
    String username;
    ImageSystemFacade system;

    public User(ImageSystemFacade system, String name){
        this.system = system;
        this.username = name;
        System.out.println("Welcome "+name);
        this.system.open();
    }


    public static void main(String... args){

        User user1 = new User(new ImageSystemFacade(InterfaceType.SITE),"Shalvi");
        ArrayList<String>tags = new ArrayList<>();
        tags.add("good");
        tags.add("picture");
        user1.system.performOperation(new UploadImage(),new Tags(tags));
        user1.system.performOperation(new SearchImage(),new Tags(tags));
        user1.system.close();
    }
}
