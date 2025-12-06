package com.project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2222);

        Socket s = serverSocket.accept();
        System.out.println("Connection Established");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "",str1="";
        while(!str.equals("stop")){
            str = dis.readUTF();
            System.out.println("Client saying : "+str);
            str1 = br.readLine();
            dos.writeUTF(str1);
            dos.flush();
        }
        dos.close();
        dis.close();
        br.close();
        s.close();
        serverSocket.close();

    }
}
