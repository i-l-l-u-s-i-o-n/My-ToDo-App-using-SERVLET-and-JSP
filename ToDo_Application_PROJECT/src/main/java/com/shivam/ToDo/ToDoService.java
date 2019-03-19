package com.shivam.ToDo;

import com.shivam.connect_database.Connect_to_DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by Shivam on 22-02-2019.
 */
public class ToDoService {

//    private static ArrayList<ToDo> list=new ArrayList<ToDo>();
//
//
//    // We can't directly add elements here to the list, SO we need a static block for this.
//    static {
//        list.add(new ToDo("Learn Servlets and JSP .","Study"));
//        list.add(new ToDo("Learn Spring Framework","Study"));
//        list.add(new ToDo("Learn REST services.","Study"));
//        list.add(new ToDo("Learn Node JS.","Study"));
//    }
//
//    public List<ToDo> getList(){
//        return list;
//    }
//
//    public  void addToDo(String todo,String category){
//        list.add(new ToDo(todo,category));
//    }
//
//    public boolean removeTodo(String todo,String category){
//
//        return list.remove(new ToDo(todo,category));
//    }

//    private  static ArrayList<ToDo_Data_Model> list=new ArrayList<ToDo_Data_Model>();
//
//    static {
//        list.add(new ToDo_Data_Model("Learn Spring","Technology","2019-03-12"));
//        list.add(new ToDo_Data_Model("Learn Mongo","Technology","2019-03-15"));
//    }
//
//    public List<ToDo_Data_Model> getList(){
//        return list;
//    }
//
//
//    public void addToDo(String detail,String category,String date){
//        list.add(new ToDo_Data_Model(detail,category,date));
//    }
//
//    public boolean removeTodo(String detail){
//
//        for(ToDo_Data_Model item:list){
//            if (item.detail.equals(detail)){
//               return list.remove(item);
//            }
//        }
//        return false;
//    }

//
//    private final String name="root";
//    private final String pass="vision22@";
//
//    private final String url="jdbc:mysql://localhost:3306/mydb";

//    private Connection conn;
    private Statement statement;
    private ResultSet result;
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
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }

    public  boolean addNewTodo(int uid,String detail,String category,String date){


        try {
            statement= Connect_to_DB.connectDB();

            return statement.execute("INSERT into todos(tdetail,tcategory,tdate,uid) values ('"+detail+"','"+category+"','"+date
                    +"','"+uid+"')");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't add todo !");
        }finally {
            try {
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public List<ToDo_Data_Model> fetchTodos(int uid){


        try {

            statement=Connect_to_DB.connectDB();
            ArrayList<ToDo_Data_Model> list = new ArrayList<ToDo_Data_Model>();
            result = statement.executeQuery("SELECT tdetail,tcategory,tdate FROM todos where uid=" + uid);
            while (result.next()){
                String detail=result.getString("tdetail");
                String category=result.getString("tcategory");
                String date=result.getString("tdate");
                list.add(new ToDo_Data_Model(detail,category,date));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public boolean removeToDo(String detail){

        try {
            Statement statement= Connect_to_DB.connectDB();
            return statement.execute("DELETE  FROM todos where tdetail='"+detail+"'");
        }catch (SQLException e){
            System.out.println("Error while deleting :( "+e.getMessage());
        }
        return false;
    }


}
