package Vaccination;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class search implements ActionListener {

    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;

    search(){
        f=new JFrame("Search");
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

        if(ae.getSource()==b){
            try {
                conn c=new conn();
                String q="select username from data where id="+t.getText()+"";
                ResultSet rs=c.s.executeQuery(q);
                rs.next();
                String s=rs.getString("username");
                if (s.equals(login.com2)){
                    System.out.println();
                    new update(t.getText());
                    f.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Id dosent match with your username.");
                    new search();
                    f.setVisible(false);
                }

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error");
                System.out.println(e);
                f.setVisible(false);
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
//            print p=new print(t.getText());
            new details();

        }

    }

    public static void main(String[]ar){
        search v=new search();
    }
}
