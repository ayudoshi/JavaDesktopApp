package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class otp implements ActionListener {

    JFrame f;
    JLabel l1;
    JTextField t1;
    JButton b1,b2,b3;

    otp(){
        f=new JFrame("OTP");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Enter OTP sent to your registered mail.");
        l1.setBounds(190,20,240,30);
        f.add(l1);

        t1=new JTextField();
        t1.setBounds(220,70,150,30);
        f.add(t1);

        b1 = new JButton("Verify");
        b1.setBounds(160,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Back");
        b2.setBounds(300,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        f.add(b2);

        b3=new JButton("Resend OTP");
        b3.setBounds(230,180,120,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        f.add(b3);

        f.getContentPane().setBackground(Color.lightGray);
        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            String input=t1.getText();
            int in=Integer.parseInt(input);
            try {
                if (in==SendEmail.otp){
                    JOptionPane.showMessageDialog(null, "Correct OTP");
                    f.setVisible(false);
                    new reset();
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Wrong OTP");
            }
        }
        if (ae.getSource()==b2 && login.pass!=null){
            f.setVisible(false);
            new details();
        }
        else{
            f.setVisible(false);
        }
        if (ae.getSource()==b3){
            JOptionPane.showMessageDialog(null,"New OTP has been sent to your mail.");
            new SendEmail("a","b","c","d");
            new otp();
        }
    }


    public static void main(String[] args) {
        new otp();
    }
}
