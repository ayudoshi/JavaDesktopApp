package Vaccination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class first implements ActionListener{
    JFrame f;
    JLabel id,l1;
    JButton b,b1;

    first() {

        f = new JFrame("Vaccination Campaign");
        f.setBackground(Color.blue);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Vaccination/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0, 150, 1060, 330);
        f.add(l1);


        b = new JButton("Register");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(430, 500, 150, 70);
        b.addActionListener(this);
        f.add(b);

        b1 = new JButton("Login In");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(430, 600, 150, 70);
        b1.addActionListener(this);
        f.add(b1);

        id = new JLabel();
        id.setBounds(0, 0, 1060, 750);
        id.setLayout(null);


        JLabel lid = new JLabel("VACCINATION CAMPAIGN");
        lid.setBounds(80, 30, 1200, 100);
        lid.setFont(new Font("serif", Font.PLAIN, 70));
        lid.setForeground(Color.black);
        id.add(lid);

        f.add(id);

        f.getContentPane().setBackground(Color.white);

        f.setVisible(true);
        f.setSize(1060, 750);
        f.setLocation(200, 100);

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new register();
        }
        else if(ae.getSource()==b1){
            f.setVisible(false);
            new login();
        }
    }

    public static void main(String[] arg){
        first f = new first();
    }
}
