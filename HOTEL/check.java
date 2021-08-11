import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
class check{
 public static void main(String[]args){
int a=0;
try{
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/HOTEL";
String username = "root";
String password = "root";
Class.forName(driver);
System.out.println("connected");
Connection conn = DriverManager.getConnection(url,username,password);
PreparedStatement cre=conn.prepareStatement("create table if not exists hotel(NAME VARCHAR(255),LAST VARCHAR(255),MOBILE VARCHAR(255),PASSWORD VARCHAR(255))");
cre.executeUpdate();
PreparedStatement p=conn.prepareStatement("insert into hotel values('abhi','vishwakarma',9833043739,'abhi')");
a=p.executeUpdate();
}
catch(Exception e){
System.out.print(e);
}
}}