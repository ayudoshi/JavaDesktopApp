package Vaccination;

//import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
//import java.io.*;
import javax.swing.*;

public class register implements ActionListener{
    JFrame f;
    JLabel id1,id2,id4,id6,id7,id8,id11,id15;
//    JLabel id16,id17,lab,lab1;
    JTextField t,t1,t2,t4,t6,t7,t10;
    JButton b1,b;


//    register(int i){}

    register(){
        f = new JFrame("Registration Details");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
        id15.setIcon(img);

        id8 = new JLabel("Registration Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.BOLD,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Last Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id4= new JLabel("Date Of Birth");
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);


        id6= new JLabel("Mobile No.");
        id6.setBounds(400,250,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id15.add(t6);

        id7= new JLabel("Email Id");
        id7.setBounds(50,200,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,200,150,30);
        id15.add(t7);

        id11= new JLabel("Aadhar No");
        id11.setBounds(50,250,100,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);

        t10=new JTextField();
        t10.setBounds(200,250,150,30);
        id15.add(t10);

//        lab=new JLabel();
//        lab.setBounds(200,450,250,200);
//        id15.add(lab);

//        lab1=new JLabel("");
//        lab1.setBounds(600,450,250,200);
//        id15.add(lab1);

        b1=new JButton("Next");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(270,550,150,40);
        id15.add(b1);
        b1.addActionListener(this);

        b=new JButton("Back");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(470,550,150,40);
        id15.add(b);
        b.addActionListener(this);

        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae){

        int i=0;
        String a = t1.getText();
        String bb = t2.getText();
        String d = t4.getText();
        String ff = t6.getText();
        String g="a";
        String j="a";

        try {
            long fl = Long.parseLong(ff);
            String sf = "9999999999";
            long sfl = Long.parseLong(sf);
            if (fl > sfl || fl <= 999999999) {
                JOptionPane.showMessageDialog(null, "Please Check your mobile number");
                i++;
            }
            g = t7.getText();
            if ((!g.endsWith(".edu") || !g.endsWith(".com")) && !g.contains("@")) {
                JOptionPane.showMessageDialog(null, "Please Check your mail id.");
                i++;
            }
            j = t10.getText();
            long ad = Long.parseLong(j);
            String adf = "999999999999";
            long adl = Long.parseLong(adf);
            String adsf = "99999999999";
            long adsl = Long.parseLong(adsf);
            if (ad > adl || ad <= adsl) {
                JOptionPane.showMessageDialog(null, "Please Check your aadhar number");
                i++;
            }
        }
        catch (Exception e){

        }
        int newid;


        if(ae.getSource() == b1 && i==0) {
            try {

                conn cc = new conn();
                int id=0;
                try{
                    String q1 = "select id from data order by id desc limit 1";
                    ResultSet rs1 = cc.s.executeQuery(q1);
                    rs1.next();
                    id = rs1.getInt("id");
                }catch (Exception e){

                }

                newid=(id+1);

                String q = "insert into data values('"+a+"','"+bb+"','"+d+"','"+ff+"','"+g+"','"+j+"','"+newid+"','')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                JOptionPane.showMessageDialog(null, "Your Id is:" + newid + " Please remember it. It is very important");
                f.setVisible(false);
                new next(newid);
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        }
        else{
            i=0;
        }

        if(ae.getSource() == b){
            f.setVisible(false);
            new first();
        }

    }
    public static void main(String[ ] arg){
        new register();
    }
}
