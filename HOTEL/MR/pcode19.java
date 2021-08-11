import java.sql.*;
import java.util.Scanner;
public class pcode19 {
   public static void main(String[] args) {
  try{
   String driver = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/abhi";
   String username = "root";
   String password = "abhi";
   String name=null,rollno=null;
   Class.forName(driver);
   System.out.println("connected");   
   Connection conn = DriverManager.getConnection(url,username,password);
   Scanner sc=new Scanner(System.in);
   int rollno=sc.next();
   int perc=sc.next();
   String name=sc.nextLine();
   PreparedStatement p1=conn.prepareStatement("update Student set rollno="+rollno+",per="+perc+" where name="+name+"");
   while(rst.next()){
	   name=rst.getString("name");
	   rollno=rst.getString("rollno");
   System.out.println("name:"+name+"\tRollno:"+rollno);
   } }catch(Exception e){}}}