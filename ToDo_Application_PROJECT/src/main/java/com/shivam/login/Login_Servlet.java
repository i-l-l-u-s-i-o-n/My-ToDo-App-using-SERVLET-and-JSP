package com.shivam.login;


import com.shivam.mailing.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Timer;

/**
 * created by Shivam on 21-02-2019.
 */

/*
The main difference between GET and POST is that when, When we want to fetch some data, We use GET,
If we want to insert or submit some data, we use POST.

The submission made by GET method,  appears in the link,
The submission made by POST method, doesn't appear in the link.

So if are submitting sensitive info. such as password, we can use POST instead of GET.


 */
@WebServlet(urlPatterns = "/login")
public class Login_Servlet extends HttpServlet {


    public void init(){
        Timer timer=new Timer();
        timer.schedule(new Task(),0,10000);
    }


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {


//        BackgroundTask b=new BackgroundTask();
//        b.startTask();
//
//        Timer timer=new Timer();
//        timer.schedule(new Task(),0,5000);


        httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String name=httpServletRequest.getParameter("name");
        String pass=httpServletRequest.getParameter("pw");
        String date=httpServletRequest.getParameter("date");


//        try {
//
//            String url="jdbc:mysql://localhost:3306/mydb";
//            String user="root";
//            String password="vision22@";
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn= DriverManager.getConnection(url,user,password);
//
//            Statement statement=conn.createStatement();
//            ResultSet result;
//
//            result=statement.executeQuery("Select uname,upass from user_reg where uname='"+name+"'and upass = '"+pass+"'");
//
//            if (result.next()){
//
//                httpServletRequest.getSession().setAttribute("name",name);
//
//
//
//
//                // Redirecting to another SERVLET//////////
//                httpServletResponse.sendRedirect("/list_todo?name="+result.getString("uname"));
//
//            }else{
//
//                httpServletRequest.setAttribute("Error", "Invalid Credentials !");
//
//                httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }


        //For validating USER.
        UserValidationService user=new UserValidationService();



        if (user.isValid(name,pass)) {


//            REQUEST SCOPE and SESSION SCOPE ->

//            Here it will not set "name" in the ToDo.jsp as we are redirecting from one servlet to another servlet
//            httpServletRequest.setAttribute("name",name);
//            Also the name will also can't be sent over different requests, for example ->
//            Here we are setting the attribute in in doPOST() which is a post request,
//            and we are again redirecting to todo.jsp via doGET() in List_ToDo_Servlet class.
//            That's why the "name" attribute is lost over different requests.
//            So the keep transmitting the attribute over Different requests or redirections, we have to make use of session.
//            To be able to pass the name to todo.jsp, we must pass it through the session

            httpServletRequest.getSession().setAttribute("name",name);


            httpServletRequest.getSession().setAttribute("date",date);
            httpServletRequest.getSession().setAttribute("uid",user.getUID());


            // Redirecting to another SERVLET//////////
            httpServletResponse.sendRedirect("/list_todo");

        }else{

            httpServletRequest.setAttribute("Error", "Invalid Credentials ! Try again : (");

            httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }
}

