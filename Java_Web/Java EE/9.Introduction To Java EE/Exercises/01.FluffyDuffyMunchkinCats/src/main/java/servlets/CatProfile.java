package servlets;

import models.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

@WebServlet("/cats/profile")
public class CatProfile extends HttpServlet {

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = ((LinkedHashMap<String, Cat>)req.getSession().getAttribute("cats")).values().stream().filter(c -> c.getName().equals(req.getParameter("catName"))).findFirst().orElse(null);
        PrintWriter writer = resp.getWriter();
        if(cat == null){
            writer.println(String.format("<h1>Cat, with name - %s was not found.</h1>",req.getParameter("catName")));
        }else{
            writer.println(String.format("<h1>Cat - %s<h1>",cat.getName()));
            writer.println("</hr>");
            writer.println(String.format("<h3>Breed - %s<h3>",cat.getBreed()));
            writer.println(String.format("<h3>Color - %s<h3>",cat.getColor()));
            writer.println(String.format("<h3>Number of legs: %s<h3>",cat.getNumLegs()));
            writer.println("</hr>");
        }
        writer.println("<a href='/01_FluffyDuffyMunchkinCats_war_exploded/'>Back</a>");
    }
}
