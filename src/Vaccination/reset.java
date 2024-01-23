package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reset implements ActionListener {

    JFrame f;
    JLabel l1,l2;
    JPasswordField t1,t2;
    JButton b1,b2;

    reset(){

        f=new JFrame("Reset");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("New Password");
        l1.setBounds(160,20,100,30);
        f.add(l1);

        l2 = new JLabel("Confirm Pass");
        l2.setBounds(160,70,100,30);
        f.add(l2);

        t1=new JPasswordField();
        t1.setBounds(270,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(270,70,150,30);
        f.add(t2);


        b1 = new JButton("Reset");
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
        b2.addActionListener(this);
        f.add(b2);

        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(600,320);
        f.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){

            boolean p = (t2.getText()).equals(t1.getText());

            if (!p) {
                JOptionPane.showMessageDialog(null, "Pass Dont Match");
            }

            else {
                try {
                    conn c = new conn();
                    String q = "update login set password='" + t2.getText() + "' where username='" + login.com2 + "'";
                    c.s.executeUpdate(q);
                    f.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Password has been reset successfully.");
                    new details();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An error occured.");
                }
            }
        }
        if (ae.getSource()==b2){
            f.setVisible(false);
            new details();
        }
    }

    public static void main(String[] args) {
        new reset();
    }
}
