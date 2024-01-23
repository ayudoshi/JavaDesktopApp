package Vaccination;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class print implements ActionListener{
    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id4,aid4,id5,aid5,id9;
    String emp_id,name,father,phone,email,dob,aadhar;
    JButton b1,b2;

    print(String e_id){
        try{
            conn con = new conn();
            String str = "select * from data where id = '"+e_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            rs.next();
            name = rs.getString("name");
            father = rs.getString("fname");
            dob = rs.getString("dob");
            phone = rs.getString("phone");
            email = rs.getString("email");
            aadhar = rs.getString("aadhar");
            emp_id = rs.getString("id");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Enter a valid id");
            f.setVisible(false);
            new details();
        }

        f=new JFrame("See Data");
        f.setVisible(true);
        f.setSize(555,642);
        f.setLocation(450,200);
        f.setBackground(Color.white);
        f.setLayout(null);


        id9=new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Vaccination/icons/print.jpg"));
        id9.setIcon(img);

        id8 = new JLabel("Details");
        id8.setBounds(50,10,250,30);
        f.add(id8);
        id8.setFont(new Font("serif",Font.BOLD,25));
        id9.add(id8);
        f.add(id9);

        id = new JLabel("Member Id:");
        id.setBounds(50,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(emp_id);
        aid.setBounds(200,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("Name:");
        id1.setBounds(50,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(name);
        aid1.setBounds(200,120,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);


        id2 = new JLabel("Last Name:");
        id2.setBounds(50,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);

        aid2 = new JLabel(father);
        aid2.setBounds(200,170,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);


        id4= new JLabel("Mobile No:");
        id4.setBounds(50,220,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id4);

        aid4= new JLabel(phone);
        aid4.setBounds(200,220,300,30);
        aid4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid4);


        id5= new JLabel("Email Id:");
        id5.setBounds(50,270,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id5);

        aid5= new JLabel(email);
        aid5.setBounds(200,270,300,30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid5);


        b1=new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,520,100,30);
        b1.addActionListener(this);
        id9.add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,520,100,30);
        b2.addActionListener(this);
        id9.add(b2);


    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            JOptionPane.showMessageDialog(null,"printed successfully");
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new view();
        }
    }
    public static void main(String[] args){
        new print("Print Data");
    }

}
