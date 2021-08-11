package signup;
import AllM.*;
import login.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class signup extends JFrame {
Connection conn;
Statement s;
ResultSet rs;
public static JTextField FirstT,LastT;
JButton SignupB,BackB;
JLabel imgL;
public static JTextField MobileT;
public static JTextField PassT;
JPanel win1,pan2,pan1,win1pan1,win1pan2;
ImageIcon imgback =new ImageIcon("Image.jpg");
Font f1=new Font("Times New Roman",Font.BOLD,20);
Font f2=new Font("Times New Roman",Font.ITALIC,20);
Font f=new Font("Cooper Black",Font.BOLD,40);
public static String name,pass,last,mobile;
int a;
public signup(){

setSize(960,628);
setTitle("HOTEL MANAGEMENT");
setLayout(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);

//BACK AREA
imgL=new JLabel("",imgback,JLabel.CENTER);
imgL.setBounds(0,0,960,628);
add(imgL);


// HOTEL PANEL AREA
pan1=new JPanel();
pan1.setLayout(null);
pan1.setBackground(new Color(23, 32, 42	 ,80));
pan1.setBounds(0,0,900,70);
JLabel Hname =new JLabel("HOTEL MANAGEMENT")	;
Hname.setForeground(Color.WHITE);
Hname.setFont(f);
Hname.setBounds(220,20,700,30);
pan1.add(Hname);

//USERNAME AREA
pan2= new JPanel();
pan2.setLayout(null);
pan2.setBackground(new Color(0,0,0,80));
pan2.setBounds(280,200,400,300);
JLabel UserL =new JLabel("FIRST NAME");
UserL.setBounds(30,70,200,20);
UserL.setFont(f1);
UserL.setForeground(Color.WHITE);
pan2.add(UserL);
JLabel PASS =new JLabel("LAST NAME");
PASS.setFont(f1);
PASS.setForeground(Color.WHITE);
PASS.setBounds(30,110,200,20);
pan2.add(PASS);
JTextField FirstT=new JTextField();
FirstT.setFont(f2);
FirstT.setBounds(160,70,200,20);
pan2.add(FirstT);
JTextField LastT=new JTextField();
LastT.setFont(f2);
LastT.setBounds(160,110,200,20);
pan2.add(LastT);
JLabel MobileL =new JLabel("MOBILE NO.");
MobileL.setForeground(Color.WHITE);
MobileL.setFont(f1);
MobileL.setBounds(30,150,200,20);
pan2.add(MobileL);
MobileT=new JTextField();
MobileT.setFont(f2);
MobileT.setBounds(160,150,200,20);
pan2.add(MobileT);
JLabel PassL =new JLabel("PASSWORD");
PassL.setForeground(Color.WHITE);
PassL.setFont(f1);
PassL.setBounds(30,190,200,20);
pan2.add(PassL);
PassT=new JTextField();
PassT.setFont(f2);
PassT.setBounds(160,190,200,20);
pan2.add(PassT);
SignupB=new JButton("SIGNUP");
SignupB.setFont(f1);
SignupB.setBackground(new Color(40,80,70));
SignupB.setForeground(Color.BLACK);
SignupB.setBounds(180,230,150,50);
pan2.add(SignupB);


///ADD AREA OF PANEL

imgL.add(pan1);
imgL.add(pan2);



SignupB.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){
if(ae.getSource()==SignupB){
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
PreparedStatement p=conn.prepareStatement("insert into hotel values('"+FirstT.getText()+"','"+LastT.getText()+"',"+MobileT.getText()+",'"+PassT.getText()+"')");
a=p.executeUpdate();
if(a!=0){
System.out.println("done");	 }
}catch(Exception e){ System.out.println(e);}
setVisible(false);
login l=new login();
}}});

setVisible(true);

}
public static void main(String[]args){
signup s=new signup();	}}
