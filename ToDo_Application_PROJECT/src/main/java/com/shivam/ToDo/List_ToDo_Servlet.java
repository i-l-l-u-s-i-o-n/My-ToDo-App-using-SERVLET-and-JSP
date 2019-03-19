package com.shivam.ToDo;

import com.shivam.login.UserValidationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by Shivam on 22-02-2019.
 */
@WebServlet(urlPatterns = "/list_todo")
public class List_ToDo_Servlet extends HttpServlet {

    //For Using ToDo services as retrieve list etc.
    ToDoService service = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {


        int uid=new UserValidationService().getUID();

        httpServletRequest.setAttribute("list", service.fetchTodos(uid));
        httpServletRequest.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
