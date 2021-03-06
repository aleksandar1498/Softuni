package servlets;

import models.Cat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

@WebServlet("/")
public class HomeServlet extends HttpServlet{



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //PrintWriter writer = resp.getWriter();
        try {
            req.setAttribute("name","alex");
            RequestDispatcher rd = req.getRequestDispatcher("/Web%20Pages/home.jsp");
            rd.forward(req, resp);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       /* resp.setContentType("text/html");
        writer.println("<h1>Welcome to Fluffy Duffy</h1>");
        writer.println("<h1>Navigate through the following links</h1>");
        writer.println("<a href='/01_FluffyDuffyMunchkinCats_war_exploded/cats/create'>Create Cat</a></br>");
        writer.println("<a href='/01_FluffyDuffyMunchkinCats_war_exploded/cats/all'>Show All Cats</a>");*/
    }

}
