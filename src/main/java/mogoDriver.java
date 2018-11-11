import com.mongodb.*;
import java.util.List;
import java.util.Set;

public class mogoDriver {


    private static MongoClient mongoClient;
    private static DB database;

    public static void main (String [] args)
    {
        try{
            mongoClient = new MongoClient("localhost",27017);
            database = mongoClient.getDB("shalom");
            //DBCollection dbc =  database.getCollection("shalom");
            //System.out.println("---------------");
            //System.out.println(dbc.find());
            //System.out.println("---------------");

            //getDBNames();
            getDBCollections();

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
         Set<String> tables = database.getCollectionNames();

        // System.out.println(database.getName());
         for(String coll : tables){
             System.out.println(coll);
         }
     }


}
