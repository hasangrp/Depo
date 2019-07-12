package database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;

public class NoSQLConnection {

    static Logger log = Logger.getLogger(NoSQLConnection.class.getName());
    MongoCollection collection;

    public MongoCollection getCollection() {
        return collection;
    }

    public void connect() {

        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("mydb");
            collection = db.getCollection("CURRENCY");

        } catch (Exception e) {
            log.error("başarısız");
        }
    }
}
