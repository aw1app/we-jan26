package com.sl;

public class DatabaseConnection {
    private String dbName;

    public String getDbName() { return dbName; }
    public void setDbName(String dbName) { this.dbName = dbName; }

    public void init() {
        System.out.println("[XML Lifecycle] Initializing database connection to: " + dbName);
    }

    public void destroy() {
        System.out.println("[XML Lifecycle] Closing database connection to: " + dbName);
    }
}