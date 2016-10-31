package CreationalDP.Singleton;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Created by shalvi on 19/03/16.
 */
public class MongoDBSingleton {
    private static MongoDBSingleton dbInstance = null;
    private static MongoClient mongo = null;
    private static DB db = null;

    //private constructor
    private MongoDBSingleton(){
        try{
             mongo = new MongoClient( "localhost" , 27017 );
        }
        catch(Exception e){
            System.out.println("Connection Failed");
        }
    }

    public static MongoDBSingleton getInstance(){
        if(dbInstance == null){
            synchronized (MongoDBSingleton.class){
                if(dbInstance == null){
                    dbInstance = new MongoDBSingleton();
                }
            }
        }
        return dbInstance;
    }

    public DB getDB(String name){
        db=mongo.getDB(name);
        return db;
    }

    public DBCollection getDBCollection(String db, String dbCollection){
        DBCollection table = getDB(db).getCollection(dbCollection);
        return table;
    }

    public static void main(String... args){
        MongoDBSingleton instance = MongoDBSingleton.getInstance();
        instance.getDBCollection("testDb","users");
        System.out.println(instance);

        MongoDBSingleton instance2 = MongoDBSingleton.getInstance();
        instance2.getDBCollection("testDb","users");
        System.out.println(instance2);
        if(instance2 == instance){
            System.out.println("Both instance are same");
        }
    }
}
