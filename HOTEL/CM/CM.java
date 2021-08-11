package CM;
import login.*;
import AllM.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JTable.*;
import java.sql.*;
public class CM extends JFrame implements ActionListener {
JPanel pan1,pan2,pan3;
JLabel imgL;
JLabel l1,l2,l3,l4;
JRadioButton rb1,rb2;
JButton submit,back,refresh,delete;
JComboBox li;
JLabel label1,clientid,fname,lname,mobile,age,gender,clientr;
JTextField text1,text2,text3,text4,text5,text6,ageT;
ImageIcon imgback =new ImageIcon("Image.jpg");
Font fo1 =new Font("Cooper Black",Font.BOLD,40);
Font fo2 =new Font("Times New Roman",Font.BOLD,25);
Font fo3=new Font("Times New Roman",Font.ITALIC,20);
Font fo4=new Font("Times New Roman",Font.BOLD,15);
Font f1=new Font("Times New Roman",Font.BOLD,20);
String column[]={"CLIENT_ID","FIRSTNAME","LASTNAME","MOBILE","AGE","GENDER"};
String data[][]={{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""},{"","","","","",""}};
JTable t1;

String cidvalue;
int intvalue;
public CM(){

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
label1=new JLabel("Manage Client");
label1.setBounds(300,10,500,50);
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
l1=new JLabel("1");
l2=new JLabel("Enter first name");
l3=new JLabel("Enter Last name");
l4=new JLabel("Enter Mobile");
l1.setForeground(new Color(0,0,0,80));
l2.setForeground(new Color(0,0,0,80));
l3.setForeground(new Color(0,0,0,80));
l4.setForeground(new Color(0,0,0,80));
l1.setFont(fo4);
l2.setFont(fo4);
l3.setFont(fo4);
l4.setFont(fo4);

clientid=new JLabel("Client ID:");
clientid.setForeground(Color.WHITE);
clientid.setBounds(20,100,150,20);
clientid.setFont(fo2);
pan2.add(clientid);
fname=new JLabel("First Name:");
fname.setForeground(Color.WHITE);
fname.setBounds(20,140,150,20);
fname.setFont(fo2);
pan2.add(fname);
lname=new JLabel("Last Name:");
lname.setForeground(Color.WHITE);
lname.setBounds(20,180,150,20);
lname.setFont(fo2);
pan2.add(lname);
mobile=new JLabel("Mobile:");
mobile.setForeground(Color.WHITE);
mobile.setBounds(20,220,150,20);
mobile.setFont(fo2);
pan2.add(mobile);
age=new JLabel("Age:");
age.setForeground(Color.WHITE);
age.setBounds(20,270,150,30);
age.setFont(fo2);
pan2.add(age);
gender=new JLabel("Gender:");
gender.setForeground(Color.WHITE);
gender.setBounds(160,270,150,30);
gender.setFont(fo2);
pan2.add(gender);
text1=new JTextField();
text1.setBounds(160,100,170,25);
text1.setFont(fo3);
text1.setEnabled(false);
text1.setLayout(new FlowLayout());
text1.add(l1);

pan2.add(text1);
text2=new JTextField();
text2.setBounds(160,140,170,25);
text2.setFont(fo3);
pan2.add(text2);
text2.setLayout(new FlowLayout());
text2.add(l2);

text3=new JTextField();
text3.setBounds(160,180,170,25);
text3.setFont(fo3);
text3.setLayout(new FlowLayout());
text3.add(l3);

pan2.add(text3);
text4=new JTextField();
text4.setBounds(160,220,170,25);
text4.setFont(fo3);
pan2.add(text4);
text4.setLayout(new FlowLayout());
text4.add(l4);

try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement cre=conn.createStatement();
ResultSet res=cre.executeQuery("SELECT cid FROM CM ORDER BY cid DESC LIMIT 1");
while(res.next()){
cidvalue=res.getString("cid");
intvalue=Integer.parseInt(cidvalue)+1;
cidvalue=Integer.toString(intvalue);
l1.setText(cidvalue);
}
}catch(Exception e){}

ButtonGroup rbg=new ButtonGroup();
JRadioButton rb1=new JRadioButton("MALE",true);
rb1.setBounds(260,265,70,20);
rb1.setForeground(Color.BLACK);
//rb1.setBackground(new Color(45,54,0,40));
JRadioButton rb2=new JRadioButton("FEMALE",false);
rb2.setBounds(260,295,70,20);
rb2.setForeground(Color.BLACK);
//rb2.setBackground(new Color(0,0,0,40));
rbg.add(rb1);
rbg.add(rb2);
pan2.add(rb2);
pan2.add(rb1);
ageT = new JTextField(2);
ageT.setBounds(90,277,40,20);
ageT.setLayout(new FlowLayout());
pan2.add(ageT);
submit = new JButton("SUBMIT");
submit.setBounds(130,340,100,30);
submit.setFont(fo4);
submit.setBackground(new Color(40,80,70));
submit.setForeground(Color.BLACK);
pan2.add(submit);
/*delete=new JButton("DELETE");
delete.setBounds(20,340,105,30);
delete.setFont(fo4);
delete.setBackground(new Color(40,80,70));
delete.setForeground(Color.BLACK);
pan2.add(delete);
*/
clientr=new JLabel();
clientr.setBounds(120,350,100,30);
clientr.setFont(fo4);
pan2.add(clientr);
submit.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent submita){
if(submita.getSource()==submit){
int a=0;

try{

Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
PreparedStatement cre=conn.prepareStatement("create table if not exists CM(cid int not null AUTO_INCREMENT  PRIMARY KEY,FIRSTNAME VARCHAR(255),LASTNAME VARCHAR(255),MOBILE BIGINT,AGE INT,GENDER VARCHAR(255))");
cre.executeUpdate();
String radio;
if(rb2.isSelected()){
radio=rb2.getText();
}else{
radio=rb1.getText();
}
PreparedStatement p=conn.prepareStatement("insert into CM(firstname,lastname,mobile,age,gender) values('"+text2.getText()+"','"+text3.getText()+"',"+text4.getText()+","+ageT.getText()+",'"+radio+"')");
//PreparedStatement p=conn.prepareStatement("insert into CM (firstname,lastname,mobile,age,gender) values('abhishek','vishwakarma',8828287533,12,'male')");
a=p.executeUpdate();

}catch(Exception e){}


if(a!=0){
System.out.println("client successfully Registored");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement cre=conn.createStatement();
ResultSet res=cre.executeQuery("SELECT cid FROM CM ORDER BY cid DESC LIMIT 1");
while(res.next()){
cidvalue=res.getString("cid");
intvalue=Integer.parseInt(cidvalue)+1;
cidvalue=Integer.toString(intvalue);
l1.setText(cidvalue);
text2.setText("");
text3.setText("");
text4.setText("");
ageT.setText("");
}
}catch(Exception e){}
}
else{System.out.println("client UNsuccessfully Registored");}

}}});


text1.addKeyListener(new KeyAdapter(){
public void keyTyped(KeyEvent ae){
if(ae.getKeyChar()!=KeyEvent.VK_BACK_SPACE){l1.setVisible(false);	}
else {	if(text1.getText().equals("")){l1.setVisible(true);}}}});


text2.addKeyListener(new KeyAdapter(){
public void keyTyped(KeyEvent ae){
if(ae.getKeyChar()!=KeyEvent.VK_BACK_SPACE){l2.setVisible(false);}
else {	if(text2.getText().equals("")){l2.setVisible(true);}}}});


text3.addKeyListener(new KeyAdapter(){
public void keyTyped(KeyEvent ae){
if(ae.getKeyChar()!=KeyEvent.VK_BACK_SPACE){l3.setVisible(false);}
else {	if(text3.getText().equals("")){l3.setVisible(true);}}}});


text4.addKeyListener(new KeyAdapter(){
public void keyTyped(KeyEvent ae){

if(ae.getKeyChar()!=KeyEvent.VK_BACK_SPACE){l4.setVisible(false);}
else {	if(text4.getText().equals("")){l4.setVisible(true);}}}});

//Panel3
pan3 =new JPanel();
pan3.setLayout(new BorderLayout());
pan3.setBounds(400,120,500,400);
pan3.setBackground(new Color(254,254,254,80));


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
ResultSet rst=st.executeQuery("select * from CM");
while(rst.next()){
cid=rst.getString("cid");
first=rst.getString("firstname");
last=rst.getString("lastname");
phone=rst.getString("mobile");
age=rst.getString("age");
gender=rst.getString("gender");
for(int col=0;col<=6;col++){
for(int row=0;row<=6;row++){

data[0+a][0]=cid;
data[0+a][1]=first;
data[0+a][2]=last;
data[0+a][3]=phone;
data[0+a][4]=age;
data[0+a][5]=gender;
break;

}break;

}a++;
}

}catch(Exception e){System.out.println(e);}
//pan3.add(t1);

imgL.add(pan3);
addMouseMotionListener(new mymouse());


setSize(960,628);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
}


public void actionPerformed(ActionEvent ea){
if(ea.getSource()==back){
AllM h=new AllM();
setVisible(false);
}
}
public class mymouse extends MouseAdapter{
public void mouseMoved(MouseEvent move){
try{
String cid=null,first=null,last=null,phone=null,age=null,gender=null;
int a=0;
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select * from CM");
while(rst.next()){
cid=rst.getString("cid");
first=rst.getString("firstname");
last=rst.getString("lastname");
phone=rst.getString("mobile");
age=rst.getString("age");
gender=rst.getString("gender");
for(int col=0;col<=6;col++){
for(int row=0;row<=6;row++){

data[0+a][0]=cid;
data[0+a][1]=first;
data[0+a][2]=last;
data[0+a][3]=phone;
data[0+a][4]=age;
data[0+a][5]=gender;
break;

}break;

}a++;
}

}catch(Exception e){System.out.println(e);}
}
}

public static void main(String[]args){
CM h=new CM();
}
}