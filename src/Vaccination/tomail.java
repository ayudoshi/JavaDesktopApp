package Vaccination;

import javax.swing.*;
import java.sql.ResultSet;

public class tomail {

    public static String uname;

    tomail(){
        try {
            conn c = new conn();
            String q = "select email from data where id=" + login.com1 + "";
            ResultSet rs = c.s.executeQuery(q);
            rs.next();
            uname=rs.getString("email");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Technical issue. Cant send otp now.");
        }
    }


    public static void main(String[] args) {
        new tomail();
    }
}
