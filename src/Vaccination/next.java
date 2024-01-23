package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class next implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2,t3;
    JButton b1,b2;
    int id;

    next(int nid){
        id=nid;

        f=new JFrame("Register");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(160,20,100,30);
        f.add(l1);

        l2 = new JLabel("New Password");
        l2.setBounds(160,70,100,30);
        f.add(l2);

        l3 = new JLabel("Confirm Pass");
        l3.setBounds(160,120,100,30);
        f.add(l3);

        t1=new JTextField();
        t1.setBounds(270,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(270,70,150,30);
        f.add(t2);

        t3=new JPasswordField();
        t3.setBounds(270,120,150,30);
        f.add(t3);

        b1 = new JButton("Register");
        b1.setBounds(160,190,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Back");
        b2.setBounds(300,190,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,320);
        f.setLocation(400,300);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1) {
            try {
            conn c1 = new conn();
                String u = t1.getText();
                String v = t2.getText();
                String cv = t3.getText();
                boolean p = v.equals(cv);

                if (p!=true) {
                        JOptionPane.showMessageDialog(null, "Pass Dont Match");
                        f.setVisible(false);
                        new next(4);
                }

//                System.out.println(id);
                else {
                    try {
                        String q1 = "update data set username='" + u + "' where id="+id+"";
                        String q = "insert into login values('" + u + "','" + cv + "')";

                        c1.s.executeUpdate(q1);

                        c1.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Password has created successfully");
                        f.setVisible(false);
                        new login();
                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Username already exist.");
                        f.setVisible(false);
                        new next(4);
                    }
                    }

//                    f.setVisible(false);
//                    new login();

//            String q = "select * from login where username='" + u + "' and password='" + v + "'";
//
//            ResultSet rs = c1.s.executeQuery(q);
//            if(rs.next()){
//                new details().f.setVisible(true);
//                f.setVisible(false);
//            }else{
//                JOptionPane.showMessageDialog(null, "Invalid login");
//                f.setVisible(false);
//               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new register();
        }
    }
    public static void main(String[] arg){
        next l=new next(1);
    }
}
