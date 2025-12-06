package com.project;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",2222);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str="",str1="";
        while(!str.equals("stop")){
            str=br.readLine();
            out.writeUTF(str);
            out.flush();
            str1=in.readUTF();
            System.out.println("Server Saying :"+str1);
        }
        out.close();
        br.close();
        socket.close();
        in.close();
        socket.close();
    }
}
