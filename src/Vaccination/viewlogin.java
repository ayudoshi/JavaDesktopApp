package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewlogin implements ActionListener {

        JFrame f;
        JLabel l1,l2;
        JTextField t1;
        JPasswordField t2;
        JButton b1,b2;
        public String id;

        viewlogin(String e_id){
            id=e_id;

            f=new JFrame("ViewLogin");

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
            f.add(b2);

            b2.addActionListener(this);

            f.getContentPane().setBackground(Color.WHITE);

            f.setVisible(true);
            f.setSize(600,300);
            f.setLocation(400,300);

        }

        public void actionPerformed(ActionEvent ae){

//            String id="7";
            if (ae.getSource()==b1) {
                try {
                    conn c1 = new conn();
                    conn c = new conn();
                    String u = t1.getText();
                    String v = t2.getText();

                    String q1 = "select username from data where id='" + id + "'";
                    ResultSet rs1 = c.s.executeQuery(q1);
                    rs1.next();
                    String n = rs1.getString("username");

                    if (n.equals(u)) {
                        String q = "select * from login where username='" + u + "' and password='" + v + "'";

                        ResultSet rs = c1.s.executeQuery(q);
                        if (rs.next()) {
                            new print(id);
                            f.setVisible(false);
//                    new print(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid login");
                            f.setVisible(false);
                            new view();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "username and id doesnt match");
                        f.setVisible(false);
                        new view();
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if(ae.getSource()==b2){
                f.setVisible(false);
                new details();
            }
        }
        public static void main(String[] arg){
            Vaccination.viewlogin l=new Vaccination.viewlogin("View Login");
        }
    }


