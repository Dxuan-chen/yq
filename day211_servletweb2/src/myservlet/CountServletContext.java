package myservlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/CountServletContext")
public class CountServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();

        Object obj = servletContext.getAttribute("count");
        int count =0;

        if(obj == null){
            count = Integer.parseInt(servletContext.getInitParameter("count"));
        }else if(obj instanceof String) {
            count = Integer.parseInt((String)obj);
        }
        count += 1;
        servletContext.setAttribute("count",count);
        System.out.println(count);
    }
}
