package CreationalDP.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shalvi on 20/03/16.
 */
public abstract class Website {
    protected List<Page> pages = new ArrayList<Page>();

    public List<Page> getPages() {
        return pages;
    }

    public Website(){
        this.createWebsite();
    }

    public abstract void createWebsite(); // crux of factory method
}
