package myservlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(value = "/LookServlet")
public class LookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");

        //获取pdf文件的绝对路径
        String pdfFilePath = req.getServletContext().getRealPath("/WEB-INF/labuladong的算法小抄官方完整版.pdf");
        System.out.println("pdf的绝对路径="+pdfFilePath);
        FileInputStream pdfInputStream = new FileInputStream(pdfFilePath);
        ServletOutputStream outputStream = resp.getOutputStream();

        int len = -1;
        byte[] buf = new byte[128];
        while((len = pdfInputStream.read(buf))!=-1){
            outputStream.write(buf,0,len);
        }

        pdfInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
