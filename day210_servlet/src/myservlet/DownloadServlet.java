package myservlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/zip");
        String filename = "labuladong的算法小抄官方完整版.pdf";
        //设置响应头，以下载方式打卡文件
        resp.setHeader("Content-disposition",
                "attachment;filename=\""+filename+"\"");

        //获取下载文件的绝对路径
        String downfilepath = req.getServletContext().getRealPath("/WEB-INF/labuladong的算法小抄官方完整版.pdf");

        //获取输入流及输出流对象
        FileInputStream downFileInputStream = new FileInputStream(downfilepath);
        ServletOutputStream outputStream = resp.getOutputStream();

        int readLen = -1;
        byte[] buf = new byte[128];
        while ((readLen=downFileInputStream.read(buf))!=-1){
            outputStream.write(buf,0,readLen);
        }

        downFileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
