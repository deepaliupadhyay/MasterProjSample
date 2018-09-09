package Master.controllers;

//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class testDB {
    public static void main(String args[]){
        System.out.print(1);
        MongoClientURI uri;


        MongoClient mongoClient = null;
        //try {
        //"mongodb+srv://DJ1982:forgot@test-cluster-dj-fkuxb.mongodb.net/test"
            uri = new MongoClientURI("mongodb+srv://DJ1982:forgot@test-cluster-dj-fkuxb.mongodb.net/test"
                    );
            mongoClient = new MongoClient(uri);
            //System.out.println(mongoClient);
            //DB database = mongoClient.getDatabase("testdb");



            MongoDatabase database = mongoClient.getDatabase("testdb");
//            if (database == null){
//                System.out.println("null***");
//            }else {
//                System.out.println(database);
//            }

            //DBCollection customers =
            //database.createCollection("customers", null);
            //BasicDBObject document = new BasicDBObject();
            //document.put("name", "Shubham");
            //document.put("company", "Baeldung");

            MongoCollection<Document> collection = database.getCollection("myData");
//            FindIterable<Document> documents = collection.find();
//            System.out.println((String)documents.first().);


           // BasicDBObject basic1 = new BasicDBObject();
     //       java.util.Map<String, Object> basic1 = new java.util.HashMap<String, Object>();
     //       basic1.put("_id", "5");
     //       basic1.put("type", "basic");
     //       basic1.put("first-name", "DJ");
     //       basic1.put("last-name", "Up");

     //       Document doc = new Document(basic1);
     //       collection.insertOne(doc);

//            Document myDoc = collection.find().first();
//            System.out.println(myDoc.toJson());
               MongoCursor<Document> cursor = collection.find().iterator();
               try {
                   while (cursor.hasNext()) {
                       System.out.println(cursor.next().toJson());
                   }
               } finally {
                   cursor.close();
               }
            //c}ollection.insertOne({ '_id': 10, 'item': "box", 'qty': 20 });
            //System.out.println("Employee 1: " + basic1.toJson());


        //System.out.println(collection);
            //collection.insertOne(document);
            //DBObject query = new BasicDBObject("_id", "5b907228ca839e176e706d0e");
            //DBCursor cursor = collection.find(query);

            mongoClient.close();
        //} catch (UnknownHostException e) {
          //  e.printStackTrace();
        //}
    }
    public JSONArray getData(String zipcode){
        JSONObject output = new JSONObject();
        JSONArray outputArray = new JSONArray();
        JSONParser parser = new JSONParser();

        System.out.print(1);
        MongoClientURI uri;
        MongoClient mongoClient = null;
        uri = new MongoClientURI("mongodb+srv://DJ1982:forgot@test-cluster-dj-fkuxb.mongodb.net/test"
        );
        mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("projectdb");
        MongoCollection<Document> collection = database.getCollection("projectData");
        int zip = Integer.parseInt(zipcode);
        System.out.println(zip);

        FindIterable<Document> myDoc = collection.find(
                Filters.and(Filters.eq("ZIP", zip), Filters.ne("STATUS", "Sold"))).limit(5);
        for (Document doc : myDoc) {
            try {
                boolean add;
                add = outputArray.add(parser.parse(doc.toJson()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("doc: " + doc.toJson());
        }
        //String result = myDoc.toJson();
//        MongoCursor<Document> cursor = collection.find().iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }
        mongoClient.close();

        return outputArray;
    }
}
