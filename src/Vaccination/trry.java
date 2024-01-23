package Vaccination;

import java.sql.ResultSet;

public class trry {
    public static void main(String[] args) {



        try{
            String n="ayush";
            conn c=new conn();
            String q="select id,name,username from data where username='"+n+"'";
            ResultSet rs=c.s.executeQuery(q);
            String[][] arr=new String[3][3];
            int i=0;
            int j=0;
            rs.next();
            System.out.println("ok");
            rs.next();
            arr[i+1][j]=rs.getString(1);
            arr[i+1][j+1]=rs.getString(2);

            System.out.println(arr[1][0]);
            System.out.println(arr[1][1]);

        }
        catch (Exception e){
            System.out.println(e);
        }










//        try{
//            String a="ayush";
//            conn c = new conn();
//            String q = "select id from data where username='"+a+"'";
//            ResultSet r = c.s.executeQuery(q);
//            while (r.next()){
//                if (3==r.getInt(1) || 1==r.getInt(1)){
//                    System.out.println("ok");
//                }
//                else {
//                    System.out.println("not ok");
//                }
//            }
//        }
//        catch(Exception e){
//
//        }
    }
}

