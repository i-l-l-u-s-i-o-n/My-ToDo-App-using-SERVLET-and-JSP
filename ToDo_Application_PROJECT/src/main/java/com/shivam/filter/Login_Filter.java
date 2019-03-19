package com.shivam.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by Shivam on 22-02-2019.
 */

/*
We can directly see our todos by just going to /list_todo.
So in order to prevent this we have to implement a filter which checks
If the the user is logged in or not.
if not, then it will redirect user to login page,
if logged in, it will allow user to see todos.


 For this we have to implement a Filter interface of javax.servlet class.


 */

// In WebFilter, we are providing /* so that filter will be applied for all routes.
@WebFilter(urlPatterns = "/*")
public class Login_Filter implements Filter {


    // To initialise the filter.
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    //Filter logic ->
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //Firstly we have to cast the request to Http as we are only handling the http request.

        HttpServletRequest request=(HttpServletRequest)servletRequest;

        HttpServletResponse response=(HttpServletResponse) servletResponse;

        //============================================= LOGIC for FILTER =====================================//


        // The logic is that, after login, we are returning the "name" of user.
        // See line 64 on Login_Servlet.
        // If the name is null, this means the user hasn't logged in, so we should stop all the request except
        // The login request. So we will redirect user to login page.
        // If the name is not null,it means the user has logged in and now he can proceed any request.

        // ===================================================================================================//

        String path = ((HttpServletRequest) request).getRequestURI();

        if (request.getSession().getAttribute("name")!=null  || path.startsWith("/signup")){
            // User is logged in.
//            System.out.println(request.getRequestURI());
            // Now allow user to proceed for any request->

            filterChain.doFilter(servletRequest,servletResponse);

        }else{

            // The user has not yet logged in->
            //Redirect it to login page->
            request.getRequestDispatcher("/login").forward(servletRequest,servletResponse);
        }


    }


    //To destroy the filter
    public void destroy() {

    }
}
