/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverhtpt;

import com.connect.ConnectDatabaseDVX;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Quan Dau
 */
public class ServerHTPT {
    
    private javax.swing.Timer timerDatGhe;
    private javax.swing.Timer timerRefresh;
    private String gheDangDat;
    private String trangThaiGhe;

    private int port;

    // danh sách client
    public static ArrayList<Socket> listSK;

    public ServerHTPT(int port) {
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
            ServerHTPT.listSK.add(socket);
            // đợi đọc
            ReadServer read = new ReadServer(socket);
            read.start();
        }

    }

    public static void main(String[] args) throws IOException {
        // khai báo mảng
        ServerHTPT.listSK = new ArrayList<>();
        // khai báo server
        ServerHTPT server = new ServerHTPT(15797);
        server.execute();
    }

    /**
     * @param args the command line arguments
     */
    
    
}

class ReadServer extends Thread {

    // đây là 1 trong những client được gửi đến,
    // nó hoàn toàn có thể phân biệt từng client
    private Socket socket;
    private ConnectDatabaseDVX access;
    private JButton[] buttons;
    

    public ReadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;

        access = new ConnectDatabaseDVX("jdbc:sqlserver://localhost:1433;Database=VEMAYBAY;user=sa;password=123456","com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            // khai báo dis để đọc dữ liệu trả về
            dis = new DataInputStream(socket.getInputStream());

            while (true) {
                //dữ liệu trả về
                String[] listString = new String[100];
                String listGhe = "";

                String sms = dis.readUTF();
                if (sms.contains("select")) {
                    
                    listGhe = access.Query(sms);
                    
                    //gửi đi đến tất cả client
                    for (Socket item : ServerHTPT.listSK) {
                        if (item.getPort() == socket.getPort()) {
                            DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                            dos.writeUTF(listGhe);
                        }

                    }
                    
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
                for (Socket item : ServerHTPT.listSK) {

                    objectOutput = new ObjectOutputStream(item.getOutputStream());

//                    dos.writeUTF("Server: " +sms);
                }

            } catch (Exception e) {
            }

        }
    }

}
