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
@WebServlet(urlPatterns = "/add_todo")
public class Add_ToDo_Servlet extends HttpServlet {

    ToDoService service=new ToDoService();


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/WEB-INF/views/new_todo.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ToDoService add_todo_services=new ToDoService();



        // Adding new ToDo.
        String detail=request.getParameter("newToDO");
        String category=request.getParameter("category");
        String date=request.getParameter("date");


        add_todo_services.addNewTodo(new UserValidationService().getUID(),detail,category,date);

//        service.addToDo(request.getParameter("newToDO"),request.getParameter("category"),request.getParameter("date"));

//        request.getSession().setAttribute("date",date);
//        request.setAttribute("list",service.getList());
//        request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);

        //Above code causes the problem of DUPLICATE SUBMITTING.
        // If we do this, when we refresh page, it will add the last added Todo again.
        // So instead of showing data in the doPost(), we can redirect it to /todo servlet and let the doGet() execute.

        // Redirecting to Todo_servlet to list the todos.
        response.sendRedirect("/list_todo");


    }
}
