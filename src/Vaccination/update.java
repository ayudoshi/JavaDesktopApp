package Vaccination;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class update implements ActionListener{

    JFrame f;
    JLabel id1,id2,id4,id5,id8,id9,id15;
    JTextField t,t1,t2,t4,t5,t8;
    JButton b,b1;
    String id_emp;
    static String sd;

    update(String idaa){
        f=new JFrame("update Employee details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_emp=idaa;
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Vaccination/icons/details.jpg"));
        id15.setIcon(img);

        id8 = new JLabel("Update Employee Detail:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("Name:");
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Last Name:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id4= new JLabel("Mobile No:");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);
        id15.add(t4);

        id5= new JLabel("Email Id:");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);

        id9= new JLabel("Aadhar No:");
        id9.setBounds(400,250,100,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);


        b=new JButton("update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);

        f.setVisible(false);
        showData(idaa);
    }

    int i=0;
    String user,dat;

    void showData(String s){
        sd=s;
        try{
            conn con = new conn();
            String str = "select * from data where id = '"+s+"'";
            System.out.println("select * from data where id = '"+s+"'");
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                f.setVisible(true);
                i=1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                t8.setText(rs.getString(6));

                user=rs.getString(8);
                dat=rs.getString(3);
                f.setVisible(true);
                f.setSize(900,500);
                f.setLocation(400,100);
            }
            if(i==0) {
                JOptionPane.showMessageDialog(null, "Id not found");
                f.setVisible(false);
                new search();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Id ille not found");
            f.setVisible(false);
            new search();
        }

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                String str = "update data set name='"+t1.getText()+"',fname='"+t2.getText()+"',dob='"+dat+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',aadhar='"+t8.getText()+"',username='"+user+"' where id="+sd+"";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new search();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[] arg){
        new update("update");
    }
}