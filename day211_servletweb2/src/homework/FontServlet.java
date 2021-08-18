package homework;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/FontServlet",initParams = {
        @WebInitParam(name = "color",value = "blue"),
        @WebInitParam(name = "size",value = "14px")
})
public class FontServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String color = servletConfig.getInitParameter("color");
        String size = servletConfig.getInitParameter("size");
        System.out.println(color);
        System.out.println(size);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
//        out.println("<div>");
        out.println("<span style='color: "+color+"" +
                ";size: "+size+"'>");
        out.println("word");
        out.println("</span>");
//        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
