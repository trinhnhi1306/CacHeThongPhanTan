/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication22;

import javaapplication22.DBAccess;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Apple Bee
 */
public class Client extends javax.swing.JFrame implements ActionListener {

    private Timer timerDatGhe;
    private Timer timerRefresh;
    private String gheDangDat;
    private String trangThaiGhe;
    private DBAccess access;
    public JButton[] buttons;
    public Ghe[] listGhe;

    DataOutputStream dos = null;
    DataInputStream dis = null;

    Socket client;

    /**
     * Creates new form Client
     */
    public Client() {

        initComponents();
        try {
            client = new Socket(InetAddress.getLocalHost(), 15797);

            // gửi câu lệnh
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
//            ReadClient read = new ReadClient(client);
//            read.start();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        access = new DBAccess();
        gheDangDat = "";
        trangThaiGhe = "";
        listGhe = new Ghe[100];
        timerDatGhe = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel_GheBiHuy.setText("Ghế " + gheDangDat + " đã bị hủy đặt");
                buttons[Integer.parseInt(gheDangDat)].setBackground(Color.green);
                String ok = "update TICKET set BLOCK = 0 where ID = " + gheDangDat;
                try {
                    dos.writeUTF(ok);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }

                timerDatGhe.stop();
            }
        });
        timerRefresh = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshButtons();
            }
        });

        timerRefresh.start();
        buttons = new JButton[100];
        getDatabase();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Buttons = new javax.swing.JPanel();
        jPanel_Status = new javax.swing.JPanel();
        jLabel_GheDangDat = new javax.swing.JLabel();
        jButton_Mua = new javax.swing.JButton();
        jLabel_GheBiHuy = new javax.swing.JLabel();
        jLabel_GheDuocMua = new javax.swing.JLabel();
        jLabel_CanhBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel_Buttons.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Buttons.setLayout(new java.awt.GridLayout(5, 10, 5, 5));

        jPanel_Status.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_GheDangDat.setText("Ghế đang đặt");

        jButton_Mua.setText("Mua");
        jButton_Mua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MuaActionPerformed(evt);
            }
        });

        jLabel_GheBiHuy.setForeground(new java.awt.Color(204, 0, 51));
        jLabel_GheBiHuy.setText("Ghế bị hủy");

        jLabel_GheDuocMua.setForeground(new java.awt.Color(204, 0, 51));
        jLabel_GheDuocMua.setText("Ghế được mua");

        jLabel_CanhBao.setForeground(new java.awt.Color(204, 0, 51));
        jLabel_CanhBao.setText("Cảnh báo");

        javax.swing.GroupLayout jPanel_StatusLayout = new javax.swing.GroupLayout(jPanel_Status);
        jPanel_Status.setLayout(jPanel_StatusLayout);
        jPanel_StatusLayout.setHorizontalGroup(
            jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StatusLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_GheDuocMua, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jLabel_GheBiHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_GheDangDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_StatusLayout.createSequentialGroup()
                        .addComponent(jButton_Mua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_StatusLayout.createSequentialGroup()
                        .addComponent(jLabel_CanhBao, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        jPanel_StatusLayout.setVerticalGroup(
            jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StatusLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_GheDangDat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_CanhBao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_GheBiHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Mua, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel_GheDuocMua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refreshButtons() {
        try {
            dos.writeUTF("select * from TICKET");
            String sms = dis.readUTF();
            String[] words = sms.split("\\s");
            System.out.println("refreshButtons");
            int x = 0;
            for (int i = words.length - 1; i > 0; i = i - 3) {
                x = Integer.parseInt(words[i - 2]);
                buttons[x].removeActionListener(this);
                if (Integer.parseInt(words[i - 1]) == 1) { // đã được mua                   
                    buttons[x].setBackground(Color.red);
                    buttons[x].removeActionListener(this);

                } else if (Integer.parseInt(words[i]) == 1) { // đã được đặt
                    buttons[x].setBackground(Color.yellow);
                    buttons[x].addActionListener(this);

                } else {// chưa mua, chưa đặt
                    buttons[x].setBackground(Color.green);
                    buttons[x].addActionListener(this);
                }
            }
        } catch (Exception e) {
            try {
                dos.close();
                dis.close();
                client.close();

            } catch (IOException ex) {
                System.out.println("ngat ket noi server");
            }

        }
    }

    public void getDatabase() {
        try {
            dos.writeUTF("select * from TICKET");
            String sms = dis.readUTF();
            String[] words = sms.split("\\s");
            System.out.println("getDatabase");
            int x = 0;
            for (int i = words.length - 1; i > 0; i = i - 3) {
                x = Integer.parseInt(words[i - 2]);
                buttons[x] = new JButton();
                buttons[x].setText(x + "");
                if (Integer.parseInt(words[i - 1]) == 1) { // đã được mua                   
                    buttons[x].setBackground(Color.red);
                    buttons[x].removeActionListener(this);

                } else if (Integer.parseInt(words[i]) == 1) { // đã được đặt
                    buttons[x].setBackground(Color.yellow);
                    buttons[x].addActionListener(this);

                } else {// chưa mua, chưa đặt
                    buttons[x].setBackground(Color.green);
                    buttons[x].addActionListener(this);

                }

                jPanel_Buttons.add(buttons[x]);
                //x++;
//                     this.listGhe[i].setSold(Integer.parseInt(words[i]));
//                     listGhe[i].setBlock(Integer.parseInt(words[i+1]));
//                     System.out.println(Integer.parseInt(words[i]));
//                     System.out.println(Integer.parseInt(words[i+1]));
            }
        } catch (Exception e) {
            try {
                dos.close();
                dis.close();
                client.close();

            } catch (IOException ex) {
                System.out.println("ngat ket noi server");
            }

        }

    }

    private void jButton_MuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MuaActionPerformed
        // TODO add your handling code here:
        if (timerDatGhe.isRunning()) {
            timerDatGhe.stop();
        }
        jLabel_GheDuocMua.setText("Ghế " + gheDangDat + " đã được mua");

        try {
            dos.writeUTF("update TICKET set SOLD = 1 where ID = " + gheDangDat);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = Integer.parseInt(gheDangDat);
        buttons[i].setBackground(Color.red);
        buttons[i].removeActionListener(this);
    }//GEN-LAST:event_jButton_MuaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:

            dos.writeUTF("update TICKET set BLOCK = 0 where SOLD = 0");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText());
        try {
            dos.writeUTF("select * from TICKET where ID = " + btn.getText());
            String sms = dis.readUTF();
            String[] words = sms.split("\\s");
            System.out.println("do dai:" + words.length);
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
            }

            if (Integer.parseInt(words[2]) == 1) {
                jLabel_CanhBao.setText("Ghế đang được đặt!");
                return;
            }

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (timerDatGhe.isRunning()) {
            timerDatGhe.stop();
            jLabel_GheBiHuy.setText("Ghế " + gheDangDat + " đã bị hủy đặt");
            buttons[Integer.parseInt(gheDangDat)].setBackground(Color.green);

            try {
                dos.writeUTF("update TICKET set BLOCK = 0 where ID = " + gheDangDat);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        gheDangDat = btn.getText();

        jLabel_GheDangDat.setText("Ghế " + gheDangDat + " đang được đặt");
        buttons[Integer.parseInt(gheDangDat)].setBackground(Color.yellow);
        try {
            dos.writeUTF("update TICKET set BLOCK = 1 where ID = " + gheDangDat);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        timerDatGhe.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnknownHostException, IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Mua;
    private javax.swing.JLabel jLabel_CanhBao;
    private javax.swing.JLabel jLabel_GheBiHuy;
    private javax.swing.JLabel jLabel_GheDangDat;
    private javax.swing.JLabel jLabel_GheDuocMua;
    private javax.swing.JPanel jPanel_Buttons;
    private javax.swing.JPanel jPanel_Status;
    // End of variables declaration//GEN-END:variables
}

class ReadClient extends Thread {

    private Socket client;

    public ReadClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(client.getInputStream());
            while (true) {
                String sms = dis.readUTF();

                String[] words = sms.split("\\s");

                for (int i = 1; i < words.length; i = i + 2) {
//                     Client.listGhe[i].setBlock(Integer.parseInt(words[i]));
                    System.out.println(Integer.parseInt(words[i]));
                }

            }
        } catch (Exception e) {
            try {
                dis.close();
                client.close();
            } catch (IOException ex) {
                System.out.println("ngat ket noi server");
            }

        }

    }

}

class WriteClient extends Thread {

    private Socket client;
    private String query;

    public WriteClient(Socket client, String query) {
        this.client = client;
        this.query = query;

    }

    @Override
    public void run() {
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(client.getOutputStream());

            while (true) {

                dos.writeUTF(query);

            }
        } catch (Exception e) {
            try {
                dos.close();
                client.close();
            } catch (IOException ex) {
                System.out.println("ngat ket noi server");
            }
        }

    }

}
