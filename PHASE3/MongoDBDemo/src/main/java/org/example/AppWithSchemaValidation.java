package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AppWithSchemaValidation {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> productsCollection;

    public static void main(String[] args) {
        connectToMongoDB();
        System.out.println("PRODUCTS IN THE COLLECTIONS");
        listProducts();

        // schema
        Document priceCriteria = new Document("price", new Document("bsonType", "double")
                .append("minimum", 100000)
                .append("description", "price must be a GT 100000 number"));

        Document schemaDoc = new Document("bsonType", "object")
                .append("properties", priceCriteria);

        Document priceValidation = new Document("$jsonSchema", schemaDoc);

        Document command = new Document("collMod", "products")
                .append("validator", priceValidation)
                .append("validationLevel", "moderate")
                .append("validationAction", "error");

        // enforce schema command
        database.runCommand(command);

        // The insertion should fail because of schema enforcement we did above
        Document prod1 = new Document();
        prod1.append("id", 15);
        prod1.append("price", 99999.46f); // price is NOT MINimum 100000
        prod1.append("name", "HP AI PC 5");

        try {
            productsCollection.insertOne(prod1);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("PRODUCTS IN THE COLLECTIONS");
        listProducts();
    }

    private static void listProducts() {
        System.out.println("\nAll Products:");
        productsCollection.find().forEach(doc -> System.out.println(doc.toJson()));
        ;
    }

    private static void connectToMongoDB() {

        String localDBURL = "mongodb://localhost:27017";
        mongoClient = MongoClients.create(localDBURL);

        database = mongoClient.getDatabase("we_jan_26");
        productsCollection = database.getCollection("products");
        System.out.println("Successfully connected to products collection of we_jan_26 database");
    }

}
