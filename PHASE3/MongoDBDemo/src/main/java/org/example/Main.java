package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> productsCollection;

    public static void main(String[] args) {

        connectToMongoDB();
        System.out.println("PRODUCTS IN THE COLLECTIONS");
        listProducts();

        Document prod1 = new Document();
        prod1.append("price",5600.4f);
        prod1.append("name","HP AI PC 2");

        System.out.println("INSERTING A NEW PRODUCT IN THE COLLECTIONS");
        insertProduct(prod1);

        System.out.println("PRODUCTS IN THE COLLECTIONS AFTER INSERTING THE ABOVE DOC ");
        listProducts();
    }

    private static void connectToMongoDB() {

        String localDBURL = "mongodb://localhost:27017";

        mongoClient = MongoClients.create(localDBURL);

        database = mongoClient.getDatabase("we_jan_26");

        productsCollection = database.getCollection("products");

        System.out.println("Successfully connected to products collection of we_jan_26 database");
    }

    private static void listProducts() {
        System.out.println("\nAll Products:");

        productsCollection.find().forEach(doc -> System.out.println(doc.toJson()));;
    }

    private static void insertProduct(Document newProductDoc) {
        productsCollection.insertOne(newProductDoc);
    }
}