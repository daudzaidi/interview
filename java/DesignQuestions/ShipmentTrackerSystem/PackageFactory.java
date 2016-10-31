package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public abstract class PackageFactory {
    public static PackageFactory getPackageFactory(PackageType type){
        if(type == PackageType.ORDER){
            return new OrderPackageFactory();
        }

        if(type == PackageType.SHIPMENT){
            return new ShipmentPackageFactory();
        }
        return null;
    }

    public abstract Package getPackage();
}
