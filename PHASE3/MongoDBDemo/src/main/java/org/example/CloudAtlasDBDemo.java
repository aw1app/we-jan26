package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CloudAtlasDBDemo {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> productsCollection;

    public static void main(String[] args) {
        connectToMongoDB();
        System.out.println("PRODUCTS IN THE COLLECTIONS");
        listProducts();



//        // The insertion should fail because of schema enforcement we did above
//        Document prod1 = new Document();
//        prod1.append("id", 1);
//        prod1.append("price", 7777.46f); // price is NOT Max 100000
//        prod1.append("name", "HP AI PC 77");
//
//        try {
//            productsCollection.insertOne(prod1);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        System.out.println("PRODUCTS IN THE COLLECTIONS");
//        listProducts();
    }

    private static void listProducts() {
        System.out.println("\nAll Products:");
        productsCollection.find().forEach(doc -> System.out.println(doc.toJson()));
        ;
    }

    private static void connectToMongoDB() {
        String cloudDBURL = "mongodb+srv://ciscouser1:<db_password>@cluster0.ixxay.mongodb.net/?appName=Cluster0&connectTimeoutMS=60000&socketTimeoutMS=60000";
        mongoClient = MongoClients.create(cloudDBURL);

        database = mongoClient.getDatabase("we_jan_26");
        productsCollection = database.getCollection("products");
        System.out.println("Successfully connected to products collection of we_jan_26 database on the cloud atlas;");
    }

}
