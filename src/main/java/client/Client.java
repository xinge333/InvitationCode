package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by zxy on 2017/8/11.
 */
public class Client {
    private String host = "localhost";// 默认连接到本机
    private int port = 8189;// 默认连接到端口8189

    public void applyCode() {
        try {
            //连接到服务器
            Socket socket = new Socket(host, port);
            try {
                // 读取服务器端传过来信息的DataInputStream
                DataInputStream in = new DataInputStream(socket
                        .getInputStream());
                // 向服务器端发送信息的DataOutputStream
                DataOutputStream out = new DataOutputStream(socket
                        .getOutputStream());
                // 标准输入流，用于从控制台输入
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String schoolName = scanner.nextLine();
                    if (isBlank(schoolName)){
                        System.out.print("学校名称不能为空，请重新输入：");
                    }
                    else {
                        out.writeUTF(schoolName);
                        out.flush();
                        // 读取来自服务器的信息，打印邀请码
                        String accpet = in.readUTF();
                        System.out.println(accpet);
                    }
                }
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isBlank(String s){
        if (s == "" || s == "\t" || s == "\r" || s == "\n" || s == "\b")
            return true;
        return false;
    }

    public static void main(String[] args) {
        new Client().applyCode();
    }

}