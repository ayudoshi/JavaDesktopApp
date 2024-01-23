package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mymembers implements ActionListener {

    JFrame f;
    JLabel l,id,aid,id1,aid1,id2,aid2,aid3,aid4,aid5;
    JButton b2;
    String[][] arr=new String[3][3];
    int i=0;
    int j=0;

    mymembers(){

        try{
            conn c=new conn();
            String q="select id,name,username from data where username='"+login.com2+"'";
            ResultSet rs=c.s.executeQuery(q);
            rs.next();
            while (rs.next()) {
                arr[i][j] = rs.getString(1);
                arr[i][j + 1] = rs.getString(2);
                arr[i][j + 2] = rs.getString(3);
                ++i;
                j=0;
            }

        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"No Members");
            new details();
        }

        f=new JFrame("My Member");
        f.setBackground(Color.lightGray);
        f.setLayout(null);

        l = new JLabel("Member Details");
        l.setBounds(250,20,200,40);
        l.setFont(new Font("serif",Font.BOLD,25));
        l.setForeground(Color.black);
        f.add(l);

        id = new JLabel("Member Id:");
        id.setBounds(50,90,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        f.add(id);

        id1 = new JLabel("Name:");
        id1.setBounds(50,140,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        f.add(id1);

        id2 = new JLabel("Username:");
        id2.setBounds(50,190,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        f.add(id2);


        aid = new JLabel(arr[0][0]);
        aid.setBounds(200,90,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid);

        aid1 = new JLabel(arr[0][1]);
        aid1.setBounds(200,140,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid1);

        aid2 = new JLabel(arr[0][2]);
        aid2.setBounds(200,190,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid2);

        aid3 = new JLabel(arr[1][0]);
        aid3.setBounds(300,90,200,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid3);

        aid4 = new JLabel(arr[1][1]);
        aid4.setBounds(300,140,300,30);
        aid4.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid4);

        aid5 = new JLabel(arr[1][2]);
        aid5.setBounds(300,190,300,30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid5);

        b2=new JButton("Home");
        b2.setBounds(282,350,150,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        f.add(b2);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b2){
            f.setVisible(false);
            f.dispose();
            new details();
        }
    }

    public static void main(String[] args) {
        new mymembers();
    }

}
