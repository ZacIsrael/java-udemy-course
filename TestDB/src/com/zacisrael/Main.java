package com.zacisrael;

import java.sql.*;

public class Main {

    public static final String DB_name = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/zacisrael/Desktop/UdemyJava/TestDB/" + DB_name;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                  " (" + COLUMN_NAME + " text, " + COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text)");



            insertContact(statement, "Tim", 506545678,"Time@email.com");
            insertContact(statement, "Joe", 2027650927,"joe@anywhere.com");
            insertContact(statement, "Zac", 2022885916,"zac@gmail.com");
            insertContact(statement, "Jane", 2037689020,"jane@yahoo.com");



            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + "=5566789" + " WHERE " + COLUMN_NAME + "='Jane'");


            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE "
                    + COLUMN_NAME + "='Joe'");


            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            // creates a set of each rows in the contacts table
            while(results.next()){
                // while there is another row, print the following line
                System.out.println(results.getString(COLUMN_NAME) + "'s phone number is "
                        + results.getInt(COLUMN_PHONE) + " and their email is "
                + results.getString(COLUMN_EMAIL));
            }
            results.close(); // close the set
            statement.close();
            conn.close();
            // ALWAYS CLOSE STATEMENTS BEFORE YOU CLOSE THE CONNECTIONS

        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException{

        statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" +
                COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL + ") " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
