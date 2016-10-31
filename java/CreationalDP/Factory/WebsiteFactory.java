package CreationalDP.Factory;

/**
 * Created by shalvi on 20/03/16.
 */
public class WebsiteFactory {

    public static Website getWebsite(WebsiteType siteType){
        switch (siteType){
            case BLOG: return new Blog();
            case SHOP: return new Shop();
            default:return  null;
        }
    }
}
