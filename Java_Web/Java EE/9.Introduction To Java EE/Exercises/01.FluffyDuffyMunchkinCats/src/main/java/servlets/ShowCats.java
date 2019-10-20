package servlets;

import models.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/cats/all")
public class ShowCats extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>All Cats</h1>");
        writer.println("</hr>");
        if(req.getSession().getAttribute("cats") == null){
            writer.println("<h3>The are not cats.<span><a href='/01_FluffyDuffyMunchkinCats_war_exploded/cats/crate'>Create Some!</a></span></h3>");
        }else{
            StringBuilder builder = new StringBuilder();
            for(Cat cat : ((LinkedHashMap<String,Cat>)req.getSession().getAttribute("cats")).values()){
                builder.append(String.format("<a href='/01_FluffyDuffyMunchkinCats_war_exploded/cats/profile?catName=%s'>%s</a></br>",cat.getName(),cat.getName()));
            }
            resp.getWriter().println(builder.toString());
        }
        writer.println("<a href='/01_FluffyDuffyMunchkinCats_war_exploded/'>Back To Home</a>");

    }
}
