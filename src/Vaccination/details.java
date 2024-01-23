package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class details implements ActionListener{
    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;

    details(){
        f=new JFrame("Home Page");
        f.setBackground(Color.lightGray);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Vaccination/icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("Home Page");
        l2.setBounds(280,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1=new JButton("Details");
        b1.setBounds(330,80,150,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);

        b5=new JButton("Own Details");
        b5.setBounds(180,80,150,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);

        b2=new JButton("Add Member");
        b2.setBounds(480,80,150,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove Member");
        b3.setBounds(260,140,150,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b6=new JButton("Reset Password");
        b6.setBounds(110,140,150,40);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        l1.add(b6);

        b7=new JButton("Member Details");
        b7.setBounds(30,80,150,40);
        b7.setFont(new Font("serif",Font.BOLD,15));
        b7.addActionListener(this);
        l1.add(b7);

        b4=new JButton("Update Details");
        b4.setBounds(405,140,150,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new view();
        }
        if(ae.getSource()==b2){
            new max();
            if (max.count<2) {
                f.setVisible(false);
                new add(login.com2);
            }
            else{
                JOptionPane.showMessageDialog(null,"You already added two members.Now you cant add anymore.");
            }
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new remove();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new search();
        }
        if(ae.getSource()==b5){
            f.setVisible(false);
            new owndetails("as");
        }
        if(ae.getSource()==b6){
            f.setVisible(false);
            new otp();
            new SendEmail("a","b","c","d");
        }
        if (ae.getSource()==b7){
            f.setVisible(false);
            new mymembers();
        }
    }

    public static void main(String[ ] arg){
        new details();
    }
}
