package CreationalDP.Prototype;

import java.util.HashMap;

/**
 * Created by shalvi on 20/03/16.
 */
public class Registry {

    public HashMap<String,Item> items = new HashMap<String,Item>();

    public Registry(){
        loadItems();
    }

    public Item createItem(String type){
        Item item = null;

        try{
            item = (Item)(items.get(type)).clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return item;
    }
    private void loadItems(){
        Movie movie = new Movie();
        movie.setTitle("Kapoor & Sons");
        movie.setPrice(160);
        movie.setUrl("www.kapoorandsons.com");
        movie.setRuntime("3 Hours");

        items.put("Movie",movie);

        Book book = new Book();
        book.setTitle("Shiva");
        book.setPrice(950);
        book.setUrl("Shiva.com");
        book.setNumberOfPages(500);

        items.put("Book",book);

    }
}
