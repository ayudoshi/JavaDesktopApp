package Vaccination;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class view implements ActionListener {

    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;

    view(){
        f=new JFrame("View");
        f.setBackground(Color.green);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Vaccination/icons/view.jpg"));
        l1.setIcon(img);


        l2=new JLabel("Member Id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.white);
        Font F1 = new Font("serif",Font.BOLD,30);
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);


        t=new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l1.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l1.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b){
            f.setVisible(false);
//            print p=new print(t.getText());
            conn c=new conn();
            String id=t.getText();
            try {
                String q1 = "select username from data where id='" + id + "'";
                ResultSet rs1 = c.s.executeQuery(q1);
                rs1.next();
                String n = rs1.getString("username");
                new viewlogin(t.getText());
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Invalid ID");
                f.setVisible(false);
                new view();
            }

        }

    }

    public static void main(String[]ar){
        view v=new view();
    }
}
