package homework;

import homework.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * 功能描述：
 * 将用户注册数据保存到集合对象，
 * 以表格方式显示注册用户列表内容，
 * 同时将注册用户数据保存到服务器文件（user.txt）
 */
@WebServlet(value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HashMap<String, User> map = new HashMap<>();
        String username = request.getParameter("username");
       if(username!=null){
             String password = request.getParameter("password");
            String sex = request.getParameter("sex");
            String[] hobby = request.getParameterValues("hobby");
            String city = request.getParameter("city");
            User user = new User(username,password,sex,hobby,city);
            map.put(username,user);
            File file = new File("/day210_users.txt");
            if(!file.exists()){
                file.createNewFile();
            }
           System.out.println(file.getAbsolutePath());
            //保存到服务器文件
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file,true));
            oos.writeObject(map);
            oos.flush();

           PrintWriter out=response.getWriter();
           out.println("<html>");
           out.println("<body>");
           out.println("<table>");
           out.println("<tr>");
           out.println("<th>");
           out.println("用户名");
           out.println("</th>");
           out.println("<th>");
           out.println("密码");
           out.println("</th>");
           out.println("<th>");
           out.println("性别");
           out.println("</th>");
           out.println("<th>");
           out.println("爱好");
           out.println("</th>");
           out.println("<th>");
           out.println("所在城市");
           out.println("</th>");
           out.println("</tr>");

           out.println("<tr>");
           out.println("<td>");
           out.println(username);
           out.println("</td>");
           out.println("<td>");
           out.println(password);
           out.println("</td>");
           out.println("<td>");
           out.println(sex);
           out.println("</td>");
           for (String h : hobby) {
               out.println("<td>");
               out.println(h);
               out.println("</td>");
           }
           out.println("<td>");
           out.println(city);
           out.println("</td>");

           out.println("</tr>");



           out.println("</table>");
           out.println("</body>");
           out.println("</html>");
           oos.close();
           out.close();

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
