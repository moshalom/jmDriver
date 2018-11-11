import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import javax.swing.text.Document;
import java.util.List;
import java.util.Set;

public class mogoDriver {


    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void main (String [] args)
    {
        try{
            mongoClient = new MongoClient("localhost",27017);
            database = mongoClient.getDatabase("shalom");
            //DBCollection dbc =  database.getCollection("shalom");
            System.out.println("---------------");
            //System.out.println(dbc.find());
            //System.out.println("---------------");

            //getDBNames();
            getDBCollections();
            collectionQuery("shalom");

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }


     private static List getDBNames()
     {
         List<String> dbs = mongoClient.getDatabaseNames();
         for(String db : dbs){
             System.out.println(db);
         }

         return dbs;
     }

     private static void getDBCollections()
     {
         MongoIterable<String> tables = database.listCollectionNames();

        System.out.println("Get collection names for dataBase: " + database.getName());
         for(String coll : tables){
             System.out.println("111" + coll);
         }

     }

     private static void collectionQuery(String collName)
     {

         MongoCollection collection =  database.getCollection(collName);
         BasicDBObject whereQuery = new BasicDBObject();
         whereQuery.put("name", "ssdds");
         //DBCursor cursor = collection.find(whereQuery);
         //while(cursor.hasNext()) {
         //    System.out.println(cursor.next());
        // }
     }


}
