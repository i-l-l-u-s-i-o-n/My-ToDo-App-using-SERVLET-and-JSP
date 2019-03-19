package com.shivam.signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by Shivam on 24-02-2019.
 */

@WebServlet(urlPatterns = "/signup")
public class SignUp_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(httpServletRequest,httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Signup_Services signup_services=new Signup_Services();

        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        String email=request.getParameter("email");

        String status=signup_services.addNewUser(name.toLowerCase(),pass,email);

        if (status.equals("Successfully Signed Up. Now LogIn again.")){
            System.out.println("Successfully added");
            request.setAttribute("Error",status);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        }
        else {
            request.setAttribute("Error", status);
            System.out.println("Error while adding user!");
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request,response);
        }

    }
}
