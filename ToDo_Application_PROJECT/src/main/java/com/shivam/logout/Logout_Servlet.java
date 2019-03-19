package com.shivam.logout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by Shivam on 22-02-2019.
 */

@WebServlet(urlPatterns = "/logout")
public class Logout_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        //To logout, we can set the name to null , so that it cant pass the filter and user has to again log in.
        //But it is program specific.
        //        httpServletRequest.getSession().setAttribute("name",null);


        //So thw simplest way to logout user, we can invalidate the session as follows- >

        httpServletRequest.getSession().invalidate();



        // Now redirect to login page
        httpServletResponse.sendRedirect("/login");
    }
}
