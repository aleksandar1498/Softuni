package servlets;

import models.Cat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/cats/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.println("<h1>Create a Cat</h1>");
        writer.println("<form action='/01_FluffyDuffyMunchkinCats_war_exploded/cats/create' method='post'>Create a Cat</h1>");
        writer.println("Name : <input type='text' name='name'/ value='Alex'></br>");
        writer.println("Breed : <input type='text' name='breed' value='Bulldog'/></br>");
        writer.println("Color : <input type='text' name='color' value='White'/></br>");
        writer.println("Number of Legs : <input type='number' name='numLegs'value='4'/></br>");
        writer.println("<button type='submit'>Create Cat</button></br>");
        writer.println("</form>");
        writer.println("<a href='/01_FluffyDuffyMunchkinCats_war_exploded/'>Back To Home</h1>");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        int numLegs = Integer.parseInt(req.getParameter("numLegs"));
        if(name.replaceAll("\\s+","").equals("")
        || breed.replaceAll("\\s+","").equals("")
        || color.replaceAll("\\s+","").equals("")
        || numLegs < 0){
           return;
        }

        if(req.getSession().getAttribute("cats") == null){
            req.getSession().setAttribute("cats",new LinkedHashMap<String, Cat>());
        }
        ((LinkedHashMap<String, Cat>)req.getSession().getAttribute("cats")).put(name,new Cat(name,breed,color,numLegs));
        resp.sendRedirect("/01_FluffyDuffyMunchkinCats_war_exploded/cats/profile?catName="+name);
    }
}
