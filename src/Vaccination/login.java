package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login implements ActionListener {
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2, b3;
    public static int com1;
    public static String com2;
    public static String pass;

    login(){

        f=new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(160,20,100,30);
        f.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(160,70,100,30);
        f.add(l2);

        t1=new JTextField();
        t1.setBounds(270,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(270,70,150,30);
        f.add(t2);


        b1 = new JButton("Login");
        b1.setBounds(160,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Back");
        b2.setBounds(300,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        f.add(b2);

        b3=new JButton("Forgot Password");
        b3.setBounds(230,180,120,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        f.add(b3);


        f.getContentPane().setBackground(Color.lightGray);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1) {
            try {
                conn c1 = new conn();
                conn c = new conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from login where username='" + u + "' and password='" + v + "'";
                ResultSet rs = c.s.executeQuery(q);

                String q1 = "select id from data where username='" + u + "'";
                ResultSet rs1 = c1.s.executeQuery(q1);
                rs1.next();
                com1 = rs1.getInt("id");
                if (rs.next()) {
                    com2 = rs.getString("username");
                    pass = rs.getString("password");
                    new details().f.setVisible(true);
                    f.setVisible(false);
//                new details();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    f.setVisible(false);
                    new first();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Credentials not found in database.");
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new first();
        }
        if (ae.getSource()==b3){
            new otp();
            new SendEmail("a","b","c","d");
        }
    }
    public static void main(String[] arg){
        login l=new login();
    }
}
