package MR;
import login.*;
import AllM.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
//import java.sql.Date;
import javax.swing.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import javax.swing.border.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class MR extends JFrame implements ActionListener {
JPanel pan1,pan2,pan3;
JLabel imgL,label1;
JLabel l1,l2,l3,l4,l5,l6;
JTextField text1,text2,text3,text4,text5;
JRadioButton Yes,No;
JRadioButton rb1,rb2,rb3,rb4,rb5;
JButton submit,back,add,remove,find,clear,show;
JComboBox cb1;
ImageIcon imgback =new ImageIcon("Image.jpg");
Font fo1 =new Font("Cooper Black",Font.BOLD,40);
Font fo2 =new Font("Times New Roman",Font.BOLD,25);
Font fo3=new Font("Times New Roman",Font.ITALIC,20);
Font fo4=new Font("Times New Roman",Font.BOLD,15);
Font f1=new Font("Times New Roman",Font.BOLD,20);
int a=1;
String column[]={"CID","ROOMNO","ONDATE","EXPDATE","TIME"};
String data[][]={{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};
JTable t1;
public MR(){

setLayout(null);

/*background*/
imgL=new JLabel("",imgback,JLabel.CENTER);
imgL.setBounds(0,0,960,628);
add(imgL);

//PANEL 1
pan1=new JPanel();
pan1.setSize(200,0);
pan1.setLayout(null);
pan1.setBackground(new Color(0,0,0,80));
pan1.setBounds(0,0,960,70);
imgL.add(pan1);
label1=new JLabel("MANAGE RESERVATION");
label1.setBounds(190,10,600,50);
label1.setFont(fo1);
label1.setForeground(Color.WHITE);
pan1.add(label1);
back=new JButton("BACK");
back.setBackground(new Color(40,80,70));
back.setFont(f1);
back.setForeground(Color.BLACK);
back.setBounds(805,15,120,40);
pan1.add(back);
back.addActionListener(this);


/*Panel2*/
pan2 =new JPanel();
pan2.setLayout(null);
pan2.setBounds(20,120,350,400);
pan2.setBackground(new Color(0,0,0,80));
imgL.add(pan2);
l1=new JLabel();
l1.setForeground(new Color(0,0,0,80));
l1.setVisible(false);
/*pan2.add(l1);
text1=new JTextField(2);
text1.setBounds(150,100,150,20);
pan2.add(text1);*/
l2=new JLabel("Client ID:");
l2.setBounds(30,130,120,20);
l2.setForeground(Color.WHITE);
l2.setFont(fo2);
pan2.add(l2);
text2=new JTextField(2);
text2.setBounds(150,130,150,20);
pan2.add(text2);

l3=new JLabel("Room No:");
l3.setFont(fo2);
l3.setForeground(Color.WHITE);
l3.setBounds(29,160,120,20);
pan2.add(l3);
text3=new JTextField();
text3.setBounds(150,160,150,20);
text3.setEnabled(false);
text3.setLayout(new FlowLayout());
text3.add(l1);
pan2.add(text3);
l4=new JLabel("On_Date:");
l4.setBounds(32,190,120,20);
l4.setForeground(Color.WHITE);
l4.setFont(fo2);
pan2.add(l4);
Date date=new Date();
SimpleDateFormat format = new SimpleDateFormat("dd--MM--yy");
String strDate= format.format(date);
JFormattedTextField txtf=new JFormattedTextField(strDate);
//txtf.setLayout(new FlowLayout(JFormattedTextField.CENTER));
//System.out.println(strDate);
txtf.setBounds(150,190,150,20);
txtf.setEnabled(false);
pan2.add(txtf);
l5=new JLabel("Exp Date:");
l5.setForeground(Color.WHITE);
l5.setFont(fo2);
l5.setBounds(29,220,120,20);
pan2.add(l5);
text4=new JTextField();
text4.setBounds(150,220,150,20);
text4.setEnabled(false);
pan2.add(text4);
LocalDateTime now = LocalDateTime.now();
l6=new JLabel("Time:");
l6.setForeground(Color.WHITE);
l6.setBounds(72,250,120,20);
l6.setFont(fo2);
pan2.add(l6);


DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
LocalDateTime Now = LocalDateTime.now();
JFormattedTextField txtf1=new JFormattedTextField(dtf.format(Now));
txtf1.setBounds(150,250,150,20);
txtf1.setEnabled(false);
pan2.add(txtf1);



submit=new JButton("Add New Room");
submit.setBackground(Color.YELLOW);
submit.setBounds(36,300,120,30);
submit.setEnabled(false);
pan2.add(submit);
find=new JButton("Edit");
find.setBackground(Color.YELLOW);
find.setBounds(160,300,60,30);
pan2.add(find);
show=new JButton("show");
show.setBackground(Color.YELLOW);
show.setBounds(158,275,65,20);
pan2.add(show);
remove=new JButton("Remove");
remove.setBackground(Color.YELLOW);
remove.setBounds(223,300,90,30);
pan2.add(remove);
clear=new JButton("Clear All Field");
clear.setBounds(36,340,277,30);
clear.setBackground(Color.RED);
pan2.add(clear);

/*Panel3*/
pan3 =new JPanel();
pan3.setLayout(new BorderLayout());
pan3.setBounds(400,120,500,400);
pan3.setBackground(new Color(254,254,254,80));
imgL.add(pan3);

t1=new JTable(data,column);
t1.setBounds(50,50,200,300);
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
JScrollPane sp = new JScrollPane(t1,v,h);
pan3.add(sp,BorderLayout.CENTER);
try{
String cid=null,first=null,last=null,phone=null,age=null,gender=null;
int a=0;
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select * from MR");
while(rst.next()){
cid=rst.getString("cid");
first=rst.getString("roomno");
last=rst.getString("ONDATE");
phone=rst.getString("EXPDATE");
age=rst.getString("TIME");
for(int col=0;col<=6;col++){
for(int row=0;row<=6;row++){

data[0+a][0]=cid;
data[0+a][1]=first;
data[0+a][2]=last;
data[0+a][3]=phone;
data[0+a][4]=age;

break;

}break;

}a++;
}

}catch(Exception e){System.out.println(e);}
addMouseMotionListener(new mymouse());

text2.addKeyListener(new KeyAdapter(){
public void keyPressed(KeyEvent text){
String cid=null;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
PreparedStatement ps=conn.prepareStatement(" create table if not exists MR(cid int,roomno int not null primary key, ondate varchar(25), expdate varchar(25), time varchar(25))");
ps.executeUpdate();
Statement p=conn.createStatement();
ResultSet rst=p.executeQuery("select cid from cm where cid="+text2.getText()+"");
while(rst.next()){
cid=rst.getString("cid");
}
if(text.getKeyChar()==KeyEvent.VK_ENTER&&cid!=null){

text3.setEnabled(true);

}

else{
if(!text2.getText().equals("")){

text3.setEnabled(false);

}}
}catch(Exception e){}}});



text3.addKeyListener(new KeyAdapter(){
public void keyPressed(KeyEvent rrom){
String room=null,room1=null;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement st=conn.createStatement();
Statement st1=conn.createStatement();
ResultSet rst1=st1.executeQuery("select roomno from mr where roomno="+text3.getText()+"");
while(rst1.next()){room1=rst1.getString("roomno");}
try{ResultSet rst=st.executeQuery("select roomno from rm where roomno="+text3.getText()+"");
while(rst.next()){room=rst.getString("roomno");}}catch(Exception e){}

if(room!=null||room1!=null&&rrom.getKeyChar()==KeyEvent.VK_ENTER){
l1.setText("NOT AVAILABLE");
l1.setVisible(true);
if(room!=null){
l1.setText("room permly-reserved");
l1.setVisible(true);
txtf.setEnabled(false);
text4.setEnabled(false);
txtf1.setEnabled(false);
submit.setEnabled(false);


}
}
else{
if(!text3.getText().equals("")){
a=1;
txtf.setEnabled(false);
text4.setEnabled(false);
txtf1.setEnabled(false);
submit.setEnabled(false);
l1.setVisible(false);
}}

if(room1==null&&rrom.getKeyChar()==KeyEvent.VK_ENTER){

l1.setVisible(false);
txtf.setEnabled(true);
text4.setEnabled(true);
txtf1.setEnabled(true);
submit.setEnabled(true);
if(room==null){

l1.setVisible(false);}
else{
l1.setVisible(true);
txtf.setEnabled(false);
text4.setEnabled(false);
txtf1.setEnabled(false);
submit.setEnabled(false);
}
}




}catch(Exception ea){}

}});

submit.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent sub){
try{
int a=0;
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
PreparedStatement p=conn.prepareStatement(" create table if not exists MR(cid int,roomno int not null primary key, ondate varchar(25), expdate varchar(25), time varchar(25))");
p.executeUpdate();
PreparedStatement p1=conn.prepareStatement("insert into MR values("+text2.getText()+","+text3.getText()+",'"+txtf.getText()+"','"+text4.getText()+"','"+txtf1.getText()+"')");
//PreparedStatement p1=conn.prepareStatement("insert into MR values(1,3,'454-456-46','78-456-456','465-545-45')");
a=p1.executeUpdate();
if(a!=0){
}
}catch(Exception e){}
}});

find.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent action){
String roomno=null,ondate=null,expdate=null,time=null;
if(action.getSource()==find){

try{

Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select *from mr where roomno="+text3.getText()+"");
while(rst.next()){
roomno=rst.getString("roomno");
//ondate=rst.getString("ondate");
//	expdate=rst.getString("expdate");
//	time=rst.getString("time");
}
System.out.println(roomno);
if(roomno!=null){
txtf.setEnabled(true);
text4.setEnabled(true);
txtf1.setEnabled(true);
submit.setEnabled(true);
//		txtf.setText(ondate);
//		text4.setText(expdate);
//		txtf1.setText(time);
}}catch(Exception ea){System.out.println(ea);}
a++;
if(a>2){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
PreparedStatement p1=conn.prepareStatement("update MR set ondate='"+txtf.getText()+"',expdate='"+text4.getText()+"',time='"+txtf1.getText()+"' where roomno="+text3.getText()+"");
p1.executeUpdate();
}catch(Exception e){System.out.println(e);}}

}}});


remove.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){

System.out.println(a);
int ab=0;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
PreparedStatement p1=conn.prepareStatement("delete from MR where roomno="+text3.getText()+"");
ab=p1.executeUpdate();

}catch(Exception e){System.out.println(e+""+ab);}
}
});

show.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent showa){
String roomno=null,ondate=null,expdate=null,time=null;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select *from MR where roomno="+text3.getText()+"");
while(rst.next()){
ondate=rst.getString("ondate");
expdate=rst.getString("expdate");
time=rst.getString("time");
}
txtf.setText(ondate);
text4.setText(expdate);
txtf1.setText(time);
}catch(Exception e){}
}
});

clear.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent cleara){
text2.setText("");
text3.setText("");
txtf.setText("");
text4.setText("");
txtf1.setText("");
l1.setText("");
}
});
setSize(960,628);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
}

class mymouse extends MouseAdapter{
public void mouseMoved(MouseEvent me){
try{
String cid=null,first=null,last=null,phone=null,age=null,gender=null;
int a=0;
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select * from MR");
while(rst.next()){
cid=rst.getString("cid");
first=rst.getString("roomno");
last=rst.getString("ONDATE");
phone=rst.getString("EXPDATE");
age=rst.getString("TIME");
for(int col=0;col<=6;col++){
for(int row=0;row<=6;row++){

data[0+a][0]=cid;
data[0+a][1]=first;
data[0+a][2]=last;
data[0+a][3]=phone;
data[0+a][4]=age;

break;

}break;

}a++;
}

}catch(Exception e){System.out.println(e);}
}
}


public void actionPerformed(ActionEvent ea){
if(ea.getSource()==back){
AllM h=new AllM();
setVisible(false);
}
}

public static void main(String[]args){
MR h=new MR();
}
}


