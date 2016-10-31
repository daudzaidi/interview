package CreationalDP.Prototype;

/**
 * Created by shalvi on 20/03/16.
 */
public class PrototypeDemo {

    public static void main(String... args){
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");

        if(movie == registry.items.get("Movie")){
            System.out.println("Equals");
        }else{

            System.out.println("Not equal");
        }
        System.out.println(movie);
        System.out.println("Default Movie Title:" + movie.getTitle());
        System.out.println("Default Movie runtime: "+ movie.getRuntime());
        System.out.println("Default Movie Price: "+ movie.getPrice());
        System.out.println("Default Move Url: "+ movie.getUrl());


        movie.setRuntime("2 Hours 20 Minutes");
        movie.setTitle("Neerja");
        movie.setUrl("www.neerja.com");

        System.out.println("New Movie Title:" + movie.getTitle());
        System.out.println("New Movie runtime: "+ movie.getRuntime());
        System.out.println("New Movie Price: "+ movie.getPrice());
        System.out.println("New Move Url: "+ movie.getUrl());

    }
}
