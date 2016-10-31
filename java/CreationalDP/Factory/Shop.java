package CreationalDP.Factory;

/**
 * Created by shalvi on 20/03/16.
 */
public class Shop extends Website {
    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
