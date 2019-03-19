package com.shivam.login;

import com.shivam.connect_database.Connect_to_DB;

import java.sql.*;

/**
 * created by Shivam on 22-02-2019.
 */
public class UserValidationService {

    // MySQL DB user name ->
//    private final String name="root";
//    private final String pass="vision22@";
//
//    private final String url="jdbc:mysql://localhost:3306/mydb";

//
//
//
//    private Connection conn;
    private Statement statement;
    private ResultSet result;
    private static int uid=-1;
//
//    private void establishConnectionWithMySQL(){
//
//        try {
//
//
//
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //establishing connection with MySQL DB.
//            conn= DriverManager.getConnection(url,name,pass);
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public boolean isValid(String name,String pass){

//        establishConnectionWithMySQL();
        try {
            statement= Connect_to_DB.connectDB();

            result=statement.executeQuery("Select uname,upass,uid from user_reg where uname='"+name.toLowerCase()+"'and upass = '"+pass+"'");

            if (result.next() && result.getString("upass").equals(pass)){
                this.uid=result.getInt("uid");
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    public int getUID(){
        return this.uid;
    }






}
