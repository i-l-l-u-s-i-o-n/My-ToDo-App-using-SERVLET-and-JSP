package com.shivam.mailing;


import com.shivam.connect_database.Connect_to_DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

/**
 * created by Shivam on 18-03-2019.
 */
public class Task extends TimerTask {

    public void run(){


        Statement statement = null;
        ResultSet result =null ;
        try {

            statement= Connect_to_DB.connectDB();
            result=statement.executeQuery("SELECT tdetail,tcategory,tdate,uid,reminder FROM todos");



            while (result.next() && !result.isClosed()) {


                String tdetail = result.getString("tdetail");
                String tcategory = result.getString("tcategory");
                String date = result.getString("tdate");
                int uid = result.getInt("uid");
                String remider=result.getString("reminder");


                String email = "";

                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");


                if (date != null && LocalDate.parse(date, df).equals(LocalDate.now()) &&  remider==null) {


                    statement.execute("UPDATE todos " +
                            "SET reminder = 'done' " +
                            "WHERE tdate ='"+date+"'");

                    ResultSet resultSet = statement.executeQuery("SELECT uemail from user_reg where uid = " + uid);
                    while (resultSet.next()) {
                        email = resultSet.getString("uemail");

                    }
                    Mail_Service.sendMail(email, tdetail);
                }

            }
            System.out.println("All reminders sent :)");


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
//                result.close();
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
