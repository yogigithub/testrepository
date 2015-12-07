package course;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by kapil_shrivastava on 12/4/15.
 */
public class KapilMongoFinal7Answer {
    public static void main(String[] args) {
        try {
            MongoClient c = new MongoClient();
            MongoDatabase db = c.getDatabase("final7");
            MongoCollection<Document> images = db.getCollection("images");
            MongoCollection<Document> albums = db.getCollection("albums");
            for (Document image : images.find()) {
                System.out.println(image.get("_id"));
                FindIterable<Document> albumsWithImage = albums.find(new Document("images",image.get("_id")));
                if(!albumsWithImage.iterator().hasNext()){
                    System.out.println("remove this image .. no album found"+image.get("_id"));
                    images.deleteOne(new Document("_id",image.get("_id")));
                }
            }

        }catch (Exception e){
            e.printStackTrace();;

        }

    }
}



