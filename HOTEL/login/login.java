package login;
import signup.*;
import AllM.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.sql.*;
public class login extends JFrame{
JPanel pan1,pan2;
ImageIcon img =new ImageIcon("Image.jpg");
JLabel imgL,PASSL,LoginL,Invalid;
JButton BackB,SigninB;
JTextField PASST,LOGINT;
Font f1=new Font("Times New Roman",Font.BOLD,20);
Font f2=new Font("Times New Roman",Font.ITALIC,20);
Font f=new Font("Cooper Black",Font.BOLD,40);
public login(){

setSize(960,628);
setTitle("HOTEL MANAGEMENT");
setLayout(null);
imgL=new JLabel("",img,JLabel.CENTER);
imgL.setBounds(0,0,960,628);
add(imgL);

pan1 = new JPanel();
pan1.setLayout(null);
pan1.setBounds(0,0,960,70);
pan1.setBackground(new Color(0,0,0,80));
imgL.add(pan1);
BackB = new JButton("SIGNUP");
BackB.setFont(f1);
BackB.setBackground(new Color(40,80,70));
BackB.setForeground(Color.BLACK);
BackB.setBounds(805,15,120,40);
pan1.add(BackB);
JLabel LoginL=new JLabel("LOGIN INTO OUR HOTEL");
LoginL.setForeground(Color.WHITE);
LoginL.setFont(f);
LoginL.setBounds(200,20,700,30);
pan1.add(LoginL);
BackB.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent aae){
if(aae.getSource()==BackB){
signup s=new signup();
setVisible(false);


}}});


pan2= new JPanel();
pan2.setLayout(null);
pan2.setBackground(new Color(0,0,0,80));
pan2.setBounds(280,200,400,300);
imgL.add(pan2);
JLabel LOGINL =new JLabel("FIRST NAME");
LOGINL.setBounds(30,70,200,30);
LOGINL.setFont(f1);
LOGINL.setForeground(Color.WHITE);
pan2.add(LOGINL);
JLabel PASSL =new JLabel("PASSWORD");
PASSL.setFont(f1);
PASSL.setForeground(Color.WHITE);
PASSL.setBounds(30,130,200,30);
pan2.add(PASSL);
LOGINT=new JTextField();
Font f2=new Font("Times New Roman",Font.ITALIC,20);
LOGINT.setFont(f2);
LOGINT.setBounds(160,70,200,30);
pan2.add(LOGINT);
PASST=new JTextField();
PASST.setFont(f2);
PASST.setBounds(160,130,200,30);
pan2.add(PASST);
SigninB = new JButton("Login");
SigninB.setFont(f1);
SigninB.setBackground(new Color(40,80,70));
SigninB.setForeground(Color.BLACK);
SigninB.setBounds(185,180,150,50);
pan2.add(SigninB);
Invalid=new JLabel();
Invalid.setForeground(Color.RED);
Invalid.setBounds(200,240,100,15);
pan2.add(Invalid);

SigninB.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==SigninB){try{
int a=0;
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/HOTEL","root","root");

Statement p=conn.createStatement();
ResultSet rs=null;
rs=p.executeQuery("select * from HOTEL where NAME='"+LOGINT.getText()+"' AND PASSWORD='"+PASST.getText()+"'");
String name=null,pass=null;
while(rs.next()){
name=rs.getString("name");
pass=rs.getString("password");
System.out.println(name+pass);
}

if(name!=null && pass!=null){
setVisible(false);
AllM h=new AllM();

}else{
try{
Invalid.setText("invalid password");

}catch(Exception e){}
}
}catch(Exception e){}}}});
setDefaultCloseOperation(EXIT_ON_CLOSE);

setVisible(true);
}


public static void main(String[]args){
new login();
}

}