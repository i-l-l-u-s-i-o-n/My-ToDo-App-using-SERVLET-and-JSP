package com.shivam.connect_database;

import java.sql.*;

/**
 * created by Shivam on 17-03-2019.
 */
public class Connect_to_DB {

    private static final String name="root";
    private static final String pass="1234";
    private static final String url="jdbc:mysql://localhost:3306/sql9283549";




    private static Connection conn;

    private static void establishConnectionWithMySQL(){

        try {



            Class.forName("com.mysql.jdbc.Driver");

            //establishing connection with MySQL DB.
            conn= DriverManager.getConnection(url,name,pass);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement connectDB() throws SQLException {
        establishConnectionWithMySQL();
        Statement statement=conn.createStatement();
        return statement;
    }

    public static void disconnectDB() throws SQLException{
        conn.close();

    }

}
