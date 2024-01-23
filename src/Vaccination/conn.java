package Vaccination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    public Connection c;
    public Statement s;

    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///vacc","root","root");
            s = c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
