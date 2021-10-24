/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverhtpt;

import com.connect.ConnectDatabaseDVX;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quan Dau
 */
public class ServerHTPT extends JFrame {

    private javax.swing.Timer timerDatGhe;
    private javax.swing.Timer timerRefresh;
    private String gheDangDat;
    private String trangThaiGhe;

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTextArea jTextArea_ThongBao;
    private static javax.swing.JTable jTable_DSVe;
    private ConnectDatabaseDVX access;
    private javax.swing.Timer timerLoadTable;

    private int port;

    // danh sách client
    public static ArrayList<Socket> listSK;

    public ServerHTPT(int port) {
        this.port = port;
        access = new ConnectDatabaseDVX("jdbc:sqlserver://localhost:1433;Database=VEMAYBAY;user=sa;password=123456", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        initComponents();
        loadTable();
        timerLoadTable = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTable();
            }
        });
        timerLoadTable.start();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DSVe = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_ThongBao = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Vé máy bay");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH VÉ");

        jTable_DSVe.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "SOLD", "BLOCK"
                }
        ));
        jScrollPane1.setViewportView(jTable_DSVe);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Thông báo");

        jTextArea_ThongBao.setEditable(false);
        jTextArea_ThongBao.setColumns(20);
        jTextArea_ThongBao.setRows(5);
        jScrollPane2.setViewportView(jTextArea_ThongBao);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel1)))
                                .addGap(46, 46, 46)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addGap(363, 363, 363))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(32, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(jScrollPane2))))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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
            jTextArea_ThongBao.setText(jTextArea_ThongBao.getText() + "\n\n" + "Server đã kết nối với client số: " + socket.getPort());
            System.out.println("Server đã kết nối với " + socket);
            ServerHTPT.listSK.add(socket);
            // đợi đọc
            ReadServer read = new ReadServer(socket);
            read.start();
        }

    }

    public void loadTable() {
        DefaultTableModel model = (DefaultTableModel) jTable_DSVe.getModel();
        model.setNumRows(0);
        ResultSet rs = access.loadData("select * from TICKET");
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerHTPT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        // khai báo mảng
        ServerHTPT.listSK = new ArrayList<>();
        // khai báo server
        ServerHTPT server = new ServerHTPT(15797);
        server.setVisible(true);
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

        access = new ConnectDatabaseDVX("jdbc:sqlserver://localhost:1433;Database=VEMAYBAY;user=sa;password=123456", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
//                    for (Socket item : ServerHTPT.listSK) {
//                        if (item.getPort() == socket.getPort()) {
//                            
//                            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//                            dos.writeUTF(listGhe);
//                        }
//
//                    }
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(listGhe);

                } else if (sms.contains("update")) {
                    access.Update(sms);
                    if (sms.contains("SOLD = 1")) {
                        String[] smsSubStr = sms.split("\\s+");
                        ServerHTPT.jTextArea_ThongBao.setText(ServerHTPT.jTextArea_ThongBao.getText() + "\n\n" + "client " + socket.getPort() + " đã mua ghế số " + smsSubStr[smsSubStr.length - 2]);
                    }
                }

            }
        } catch (Exception e) {
            ServerHTPT.jTextArea_ThongBao.setText(ServerHTPT.jTextArea_ThongBao.getText() + "\n\n" + "client " + socket.getPort() + " đã ngắt kết nối!");
            System.out.println(socket + " đã ngắt kết nối!");
            try {
                dis.close();
                socket.close();
                //e.printStackTrace();
            } catch (IOException ex) {
                System.out.println(socket + " ngat ket noi server");
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
