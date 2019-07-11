package nosqltest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;
public class NoSQLConnection {

    static Logger log = Logger.getLogger(NoSQLConnection.class.getName());

    public static void main(String[] args) {

        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("mydb");
            MongoCollection collection = db.getCollection("STUDENT");
             
             Document  doc = new Document();
                    doc.put("STUDENT_NUMBER", "161816025");
                     doc.put("NAME", "Hasan");
                     doc.put("LESSON", "fizik");
                     doc.put("NOTE", "75");
             collection.insertOne(doc);
             System.out.println(collection.find().first());
                               
        } catch (Exception e) {
            log.error("başarısız");
        }

    }
}
