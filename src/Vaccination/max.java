package Vaccination;

import java.sql.ResultSet;

public class max {

    public static int count;
    max(){
        try{
            conn c=new conn();
            String q="select count(*) from data where username='"+login.com2+"'";
            ResultSet r=c.s.executeQuery(q);
            r.next();
            count= r.getInt(1);
            count=count-1;
        }
        catch (Exception e){

        }
    }

    public static void main(String[] args) {
        new max();
    }
}
