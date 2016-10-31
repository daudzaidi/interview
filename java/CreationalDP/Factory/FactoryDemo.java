package CreationalDP.Factory;

/**
 * Created by shalvi on 20/03/16.
 */
public class FactoryDemo {
    public static void main(String... args){
        Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);

        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteType.SHOP);

        System.out.println(site.getPages());
    }
}
