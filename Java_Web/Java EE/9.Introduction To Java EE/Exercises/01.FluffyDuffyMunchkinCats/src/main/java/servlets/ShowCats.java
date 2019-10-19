package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cats/all")
public class ShowCats extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("cats") == null){
            resp.getWriter().println("The are not cats at the moment");
        }else{
            StringBuilder builder = new StringBuilder();
            for(String cat : ((ArrayList<String>)req.getSession().getAttribute("cats"))){
                builder.append(cat).append(System.lineSeparator());
            }
            resp.getWriter().println(builder.toString());
        }
    }
}
