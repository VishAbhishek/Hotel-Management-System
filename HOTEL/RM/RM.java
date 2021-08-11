package RM;
import login.*;
import AllM.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
public class RM extends JFrame implements ActionListener {
JPanel pan1,pan2,pan3;
JLabel imgL,label1;
JTextField text1,text2,text3;
JLabel l1,l2,l3,l4,l5,l6;
JRadioButton Yes,No;
JRadioButton rb1,rb2,rb3,rb4,rb5;
ButtonGroup rbg1;
int a=1;
JButton submit,back,add,remove,edit,clear;
JComboBox cb1;
ImageIcon imgback =new ImageIcon("Image.jpg");
Font fo1 =new Font("Cooper Black",Font.BOLD,40);
Font fo2 =new Font("Times New Roman",Font.BOLD,25);
Font fo3=new Font("Times New Roman",Font.ITALIC,20);
Font fo4=new Font("Times New Roman",Font.BOLD,15);
Font f1=new Font("Times New Roman",Font.BOLD,20);
String radio,radio1;
String cid=null;
String column[]={"CID","ROOMNO","TYPE","PHONENO","RESERVE"};
String data[][]={{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};
JTable t1;
String roomno=null,type,phone,reserve;
public RM(){

setLayout(null);

//background
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
label1=new JLabel("ROOM MANAGEMENT");
label1.setBounds(220,10,500,50);
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


//Panel2
pan2 =new JPanel();
pan2.setLayout(null);
pan2.setBounds(20,120,350,400);
pan2.setBackground(new Color(0,0,0,80));
imgL.add(pan2);


l5=new JLabel("Client Id:");
l5.setForeground(Color.WHITE);
l5.setFont(fo2);
l5.setBounds(15,65,150,30);
pan2.add(l5);

text3=new JTextField();
text3.setBounds(130,65,150,25);
text3.setFont(fo3);
pan2.add(text3);

l1=new JLabel("Room No:");
l1.setForeground(Color.WHITE);
l1.setFont(fo2);
l1.setBounds(15,100,150,30);
pan2.add(l1);

l6=new JLabel("");
l6.setForeground(Color.BLACK);
l6.setFont(fo4);
text1=new JTextField();
text1.setBounds(130,105,150,25);
text1.setFont(fo3);
text1.setEnabled(false);
text1.setLayout(new FlowLayout());
text1.add(l6);
pan2.add(text1);

l2=new JLabel("Type:");
l2.setForeground(Color.WHITE);
l2.setFont(fo2);
l2.setBounds(60,140,150,30);
pan2.add(l2);


ButtonGroup rbg=new ButtonGroup();

rb1=new JRadioButton(".1",true);
rb1.setBounds(129,150,40,20);
rb1.setForeground(Color.BLACK);
rb2=new JRadioButton(".2",false);
rb2.setBounds(165,150,40,20);
rb2.setForeground(Color.BLACK);
rb3=new JRadioButton(".3",false);
rb3.setBounds(205,150,40,20);
rb3.setForeground(Color.BLACK);
rb4=new JRadioButton(".4",false);
rb4.setBounds(245,150,40,20);
rb4.setForeground(Color.BLACK);
rb5=new JRadioButton(".5",false);
rb5.setBounds(285,150,40,20);
rb5.setForeground(Color.BLACK);

rbg.add(rb1);
rbg.add(rb2);
rbg.add(rb3);
rbg.add(rb4);
rbg.add(rb5);
rb1.setEnabled(false);
rb2.setEnabled(false);
rb3.setEnabled(false);
rb4.setEnabled(false);
rb5.setEnabled(false);

pan2.add(rb1);
pan2.add(rb2);
pan2.add(rb3);
pan2.add(rb4);
pan2.add(rb5);
l3=new JLabel("Phone No:");
l3.setForeground(Color.WHITE);
l3.setFont(fo2);
l3.setBounds(10,180,150,30);
pan2.add(l3);
text2 =new JTextField();
text2.setBounds(130,185,150,25);
text2.setFont(fo3);
text2.setEnabled(false);
pan2.add(text2);
l4=new JLabel("Reserve:");
l4.setBounds(26,215,150,30);
l4.setForeground(Color.WHITE);
l4.setFont(fo2);
pan2.add(l4);
rbg1=new ButtonGroup();
Yes=new JRadioButton("Yes",true);
Yes.setBounds(130,225,50,20);
Yes.setForeground(Color.BLACK);
rbg1.add(Yes);
No=new JRadioButton("No",false);
No.setBounds(180,225,40,20);
No.setForeground(Color.BLACK);
rbg1.add(No);
pan2.add(Yes);
pan2.add(No);
Yes.setEnabled(false);
No.setEnabled(false);
submit=new JButton("Add New Room");
submit.setBackground(Color.YELLOW);
submit.setBounds(36,300,120,30);
submit.setEnabled(false);
pan2.add(submit);
edit=new JButton("Edit");
edit.setBackground(Color.YELLOW);
edit.setBounds(160,300,60,30);
pan2.add(edit);
remove=new JButton("Remove");
remove.setBackground(Color.YELLOW);
remove.setBounds(223,300,90,30);
pan2.add(remove);
clear=new JButton("Clear All Field");
clear.setBounds(36,340,277,30);
clear.setBackground(Color.RED);
pan2.add(clear);
text3.addKeyListener(new KeyAdapter(){
public void keyPressed(KeyEvent key){
if(key.getKeyChar()==KeyEvent.VK_ENTER){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement p=conn.createStatement();
ResultSet rst;
rst=p.executeQuery("select cid from MR where cid='"+text3.getText()+"'");
while(rst.next()){
cid=rst.getString("cid");}
if(cid!=null){
text1.setEnabled(true);
//text2.setEnabled(true);
//submit.setEnabled(true);
}
}catch(Exception e){}

}
else{
cid=null;
text1.setEnabled(false);
text2.setEnabled(false);
submit.setEnabled(false);}}});

text1.addKeyListener(new KeyAdapter(){
public void keyPressed(KeyEvent text){
String room=null,roomRM=null,type=null,phone=null,reserve=null;
try{

try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root") ;
Statement st1=conn1.createStatement();
ResultSet rst1=st1.executeQuery("select * from RM where roomno='"+text1.getText()+"'");
while(rst1.next()){
roomRM=rst1.getString("roomno");
type=rst1.getString("type");
phone=rst1.getString("phoneno");
reserve=rst1.getString("reserve");
System.out.println("ok"+type);
}
}catch(Exception ea){}


Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root") ;
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select * from MR where cid='"+text3.getText()+"' and roomno='"+text1.getText()+"'");

while(rst.next()){
room=rst.getString("roomno");
}

if(room!=null&&text.getKeyChar()==KeyEvent.VK_ENTER){
Yes.setEnabled(true);
No.setEnabled(true);
rb1.setEnabled(true);
rb2.setEnabled(true);
rb3.setEnabled(true);
rb4.setEnabled(true);
rb5.setEnabled(true);
text2.setEnabled(true);
submit.setEnabled(true);
l6.setText("Reserved");
if(roomRM!=null){

if(rb1.getText().equals(type)){rb1.setSelected(true);}
else if(rb2.getText().equals(type)){rb2.setSelected(true);}
else if(rb3.getText().equals(type)){rb3.setSelected(true);}
else if(rb4.getText().equals(type)){rb4.setSelected(true);}
else if(rb5.getText().equals(type)){rb5.setSelected(true);
System.out.println(rb1.getText());}

text2.setText(phone);
if(Yes.getText().equals(reserve)){Yes.setSelected(true);}
else if(No.getText().equals(reserve)){No.setSelected(true);}
l6.setText("Already Booked");
if(l6.getText().equals("Already Booked")){
Yes.setEnabled(false);
No.setEnabled(false);
rb1.setEnabled(false);
rb2.setEnabled(false);
rb3.setEnabled(false);
rb4.setEnabled(false);
rb5.setEnabled(false);
text2.setEnabled(false);
submit.setEnabled(false);

}
}
}else{
if(!text1.getText().equals(""))
Yes.setEnabled(false);
No.setEnabled(false);
rb1.setEnabled(false);
rb2.setEnabled(false);
rb3.setEnabled(false);
rb4.setEnabled(false);
rb5.setEnabled(false);
text2.setEnabled(false);
submit.setEnabled(false);
//text1.setText("");
text2.setText("");
//text3.setText("");
rb1.setSelected(true);
Yes.setSelected(true);
//l6.setText("");
l6.setText("");
}


}catch(Exception e){System.out.print(e);}
}
});


submit.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent submita){
int a=0;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
if(rb1.isSelected()){radio=rb1.getText();}
else if(rb2.isSelected()){radio=rb2.getText();}
else if(rb3.isSelected()){radio=rb3.getText();	}
else if(rb4.isSelected()){radio=rb4.getText();}
else {radio=rb5.getText();}
if(Yes.isSelected()){radio1=Yes.getText();}
else {radio1=No.getText();}
PreparedStatement p=conn.prepareStatement("create table if not exists RM (CID INT,ROOMNO INT NOT NULL PRIMARY KEY,TYPE VARCHAR(11),PHONENO BIGINT,RESERVE VARCHAR(5))");
p.executeUpdate();
PreparedStatement p1=conn.prepareStatement("insert into RM values("+text3.getText()+","+text1.getText()+",'"+radio+"',"+text2.getText()+",'"+radio1+"')");
a=p1.executeUpdate();
}catch(Exception e){}}});

remove.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent removea){
try{

Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
PreparedStatement rem=conn.prepareStatement("delete from RM where roomno="+text1.getText()+"");
rem.executeUpdate();
}catch(Exception e){}}});


edit.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent action){
String radio=null,radio1=null,roomno=null;

if(action.getSource()==edit){

try{

Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select *from rm where roomno="+text1.getText()+"");
while(rst.next()){
roomno=rst.getString("roomno");
}
System.out.println(roomno);
if(roomno!=null){
Yes.setEnabled(true);
No.setEnabled(true);
rb1.setEnabled(true);
rb2.setEnabled(true);
rb3.setEnabled(true);
rb4.setEnabled(true);
rb5.setEnabled(true);
text2.setEnabled(true);
submit.setEnabled(true);
}}catch(Exception ea){System.out.println(ea);}
a++;
if(a>2){
try{
if(rb1.isSelected()){radio=rb1.getText();}
else if(rb2.isSelected()){radio=rb2.getText();}
else if(rb3.isSelected()){radio=rb3.getText();	}
else if(rb4.isSelected()){radio=rb4.getText();}
else {radio=rb5.getText();}
if(Yes.isSelected()){radio1=Yes.getText();}
else {radio1=No.getText();}
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
PreparedStatement p1=conn.prepareStatement("update RM set type='"+radio+"',phoneno="+text2.getText()+",reserve='"+radio1+"'  where roomno="+text1.getText()+"");
p1.executeUpdate();
}catch(Exception e){System.out.println(e);}}

}}});

clear.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent cleara){
text1.setText("");
text2.setText("");
text3.setText("");
l6.setText("");
rb1.setSelected(true);
Yes.setSelected(true);
}});


//Panel3
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
ResultSet rst=st.executeQuery("select * from RM");
while(rst.next()){
cid=rst.getString("cid");
first=rst.getString("roomno");
last=rst.getString("type");
phone=rst.getString("phoneno");
age=rst.getString("reserve");
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
ResultSet rst=st.executeQuery("select * from RM");
while(rst.next()){
cid=rst.getString("cid");
first=rst.getString("roomno");
last=rst.getString("type");
phone=rst.getString("phoneno");
age=rst.getString("reserve");
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
RM h=new RM();
}
}