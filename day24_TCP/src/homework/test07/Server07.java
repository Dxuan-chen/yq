package homework.test07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Server07 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(10020);
        while(true){
            Socket client = socket.accept();
            new Thread(() -> {
                try{
                    InputStream is = client.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String user = br.readLine();
                    System.out.println(user);
                    String[] splits = user.split("/");
                    String username = splits[0];
                    String password = splits[1];

                    Properties properties = new Properties();
                    FileReader fr = new FileReader("users.properties");
//                    BufferedWriter bw = new BufferedWriter(new FileWriter("users.properties"));
                    properties.load(fr);
                    OutputStream os = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

                    String nameValue = properties.getProperty("username");
                    String pwValue = properties.getProperty("password");

                    if(nameValue.equals(username)){//用户名存在
                        if(pwValue.equals(password)){//密码正确
                            pw.println("登录成功");
                            pw.flush();
                        }else{//密码不正确
                            pw.println("密码错误");
                            pw.flush();
                        }
                    }else{//用户名不存在
                        FileOutputStream fos = new FileOutputStream("users.properties");
                        properties.setProperty("username",username);
                        properties.setProperty("password",password);
                        properties.store(fos,"#");
                        pw.println("注册成功");
                        pw.flush();
                    }


                    br.close();
                    is.close();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
