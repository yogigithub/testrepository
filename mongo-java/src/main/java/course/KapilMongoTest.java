package course;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.bson.Document;

/**
 * Created by kapil_shrivastava on 12/4/15.
 */
public class KapilMongoTest {
    public static void main(String[] args) {
        try {
            MongoClient c = new MongoClient();
            MongoDatabase db = c.getDatabase("test");
            MongoCollection<Document> animals = db.getCollection("animals");

            Document animal = new Document("animal", "monkey");

            animals.insertOne(animal);
            animal.remove("animal");

            animal.append("animal", "cat");

            animals.insertOne(animal);

        animal.remove("animal");

        animal.append("animal", "lion");

        animals.insertOne(animal);
        }catch (Exception e){
            e.printStackTrace();;

        }

    }
}



