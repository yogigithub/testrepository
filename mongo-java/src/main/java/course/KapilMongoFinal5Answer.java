package course;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by kapil_shrivastava on 12/4/15.
 */
public class KapilMongoFinal5Answer {
    public static void main(String[] args) {
        try {
            MongoClient c = new MongoClient();
            MongoDatabase db = c.getDatabase("test");
            MongoCollection<Document> stuff = db.getCollection("stuff");

            for (int a=50000;a<100000;a++) {
                System.out.println("inserting:"+a);
                stuff.deleteOne(new Document("a",a).append("b",a).append("c",a));
            }
        }catch (Exception e){
            e.printStackTrace();;

        }

    }
}



