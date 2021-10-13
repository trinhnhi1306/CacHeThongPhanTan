/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

import java.awt.Color;

import java.io.*;
import static java.lang.Math.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Quan Dau
 */
public class Server {

    private javax.swing.Timer timerDatGhe;
    private javax.swing.Timer timerRefresh;
    private String gheDangDat;
    private String trangThaiGhe;

    private int port;

    // danh sách client
    public static ArrayList<Socket> listSK;

    public Server(int port) {
        this.port = port;
    }

    private void execute() throws IOException {
        // cho server chạy song song với tiến trình ghi dữ liệu
        ServerSocket server = new ServerSocket(port);
        WriteServer write = new WriteServer();
        write.start();
        System.out.println("server start");
        while (true) {

            // đợi một thằng kết nối tới và add vào list
            Socket socket = server.accept();
            System.out.println("đã kết nối với" + socket);
            Server.listSK.add(socket);
            // đợi đọc
            ReadServer read = new ReadServer(socket);
            read.start();
        }

    }

    public static void main(String[] args) throws IOException {
        // khai báo mảng
        Server.listSK = new ArrayList<>();
        // khai báo server
        Server server = new Server(15797);
        server.execute();
    }

}
// server đọc được dữ liệu thì sẽ gửi đi đến tất cả các client 

class ReadServer extends Thread {

    // đây là 1 trong những client được gửi đến,
    // nó hoàn toàn có thể phân biệt từng client
    private Socket socket;
    private DBAccess access;
    private JButton[] buttons;
    ArrayList<Ghe> listGhe = new ArrayList<Ghe>();

    public ReadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;

        access = new DBAccess();
        try {
            // khai báo dis để đọc dữ liệu trả về
            dis = new DataInputStream(socket.getInputStream());

            while (true) {
                //dữ liệu trả về
                String[] listString = new String[100];
                String listGhe = "";

                String sms = dis.readUTF();
                if (sms.contains("select")) {
                    ResultSet rs = access.Query(sms);

                    while (rs.next()) {

//                      Ghe ghe = new Ghe(rs.getInt(1),rs.getInt(2),rs.getInt(2));
                        String id = String.valueOf(rs.getInt(1));
                        String sold = String.valueOf(rs.getInt(2));
                        String block = String.valueOf(rs.getInt(3));
                        String u = id + " " + sold + " " + block;
                        listGhe = u + " " + listGhe;
                    }
                    //gửi đi đến tất cả client
                    for (Socket item : Server.listSK) {
                        if (item.getPort() == socket.getPort()) {
                            DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                            dos.writeUTF(listGhe);
                        }

                    }
                    System.out.println(listGhe);
                } else if (sms.contains("update")) {
                    access.Update(sms);
                }

            }
        } catch (Exception e) {
            try {

                dis.close();
                socket.close();
                e.printStackTrace();
            } catch (IOException ex) {
                System.out.println("ngat ket noi server");
            }

        }
    }

//    private boolean checkExitsClient(int port){
//        for (Integer i : listDK.keySet() ) {
//           if(i == port){
//               return true;
//           }
//        }
//        return false;
//    }
}

class WriteServer extends Thread {

    @Override
    public void run() {
        ObjectOutputStream objectOutput = null;

        while (true) {

            try {
                // gửi đi đến tất cả client
                for (Socket item : Server.listSK) {

                    objectOutput = new ObjectOutputStream(item.getOutputStream());

//                    dos.writeUTF("Server: " +sms);
                }

            } catch (Exception e) {
            }

        }
    }

}
//class WriteServer extends Thread{
//   
//
//    @Override
//    public void run() {
//        DataOutputStream dos = null;
//        OutputStream opt = null;
//        Scanner sc = new Scanner(System.in);
//        
//        while(true){
//             String sms = sc.nextLine();            
//                 try {
//                     // gửi đi đến tất cả client
//                for(Socket item : Server.listSK){
//                    
//                    Data test = new Data(10);
//                    listDK.put(1, test);
//                     dos = new DataOutputStream(item.getOutputStream());
//                     final ObjectOutputStream mapOutputStream = new ObjectOutputStream(dos);
//                     mapOutputStream.writeObject(listDK);
////                    dos.writeUTF("Server: " +sms);
//                }
//                System.out.println(sms);
//                 } catch (Exception e) {
//                 }
//            
//        }
//        }
//    
//}

// một class chứa thông tin client
class Data {

    private int port;
    private int timeRemain;

    public Data(int port) {
        this.port = port;
        this.timeRemain = 0;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeRemain() {
        return timeRemain;
    }

    public void setTimeRemain(int timeRemain) {
        this.timeRemain = timeRemain;
    }

}
