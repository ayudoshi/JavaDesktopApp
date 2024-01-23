package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ruser implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JPasswordField t3;
    JButton b1,b2;
    String id;

    ruser(String nid){
        id=nid;

        f=new JFrame("Remove User Authentication");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("User Id");
        l1.setBounds(160,20,100,30);
        f.add(l1);
        l1.setVisible(false);

        l2 = new JLabel("Username");
        l2.setBounds(160,70,100,30);
        f.add(l2);

        l3 = new JLabel("Password");
        l3.setBounds(160,120,100,30);
        f.add(l3);

        t1=new JTextField();
        t1.setBounds(270,20,150,30);
        f.add(t1);
        t1.setVisible(false);

        t2=new JPasswordField();
        t2.setBounds(270,70,150,30);
        f.add(t2);

        t3=new JPasswordField();
        t3.setBounds(270,120,150,30);
        f.add(t3);

        b1 = new JButton("Next");
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
                conn c = new conn();
//                String id = t1.getText();
                String u = t2.getText();
                String v = t3.getText();
//                boolean p = v.equals(cv);

//                if (p!=true) {
//                    JOptionPane.showMessageDialog(null, "Pass Dont Match");
//                    f.setVisible(false);
//                    new next(4);
//                }

//                System.out.println(id);

                        String q = "select * from login where username='"+u+"' and password='"+v+"'";
                        String q1 = "select * from data where username='"+u+"' and id="+id+"";

                        ResultSet rs = c.s.executeQuery(q);
                        ResultSet rs1 = c1.s.executeQuery(q1);
                        if(rs.next() && rs1.next()){
                            remove.f.setVisible(true);
//                            new add(u).f.setVisible(true);
                            f.setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(null, "Invalid login");
                            f.setVisible(false);
                            new remove();
                        }

//                        JOptionPane.showMessageDialog(null, "Password has created successfully");
//                        f.setVisible(false);
////                        new login();


//                        JOptionPane.showMessageDialog(null, "Something went wrong.");
//                        f.setVisible(false);
//                        new adduser();



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
            new remove();
        }
    }
    public static void main(String[] arg){
        ruser l=new ruser("aa");
    }
}
