package ok;
import login.*;
import CM.*;
import MR.*;
import RM.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ok extends JFrame implements ActionListener{
JButton b1,b2,b3,b4,b5,b6;
JButton back;
ImageIcon img=new ImageIcon("Image.jpg");
JLabel imgl;
JPanel pan1,pan2;
Font fo1 =new Font("Cooper Black",Font.BOLD,40);
Font fo2 =new Font("Cooper Black",Font.BOLD,20);
Font f1=new Font("Times New Roman",Font.BOLD,15);
JLabel label1;
public ok(){
setSize(970,662);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setTitle("HOTEL MANAGEMENT");
setLayout(null);
imgl=new JLabel("",img,JLabel.CENTER);
imgl.setBounds(0,0,960,628);	
add(imgl);
//pan2
pan2 =new JPanel();
pan2.setSize(800,500);
pan2.setLayout(null);
pan2.setBackground(new Color(0,0,0,80));
pan2.setBounds(75,100,800,500);
b1=new JButton("CLIENT MANAGEMENT");
b1.setFont(fo2);
b1.setBounds(0,0,400,250);
pan2.add(b1);
b2=new JButton("ROOM MANAGEMENT");
b2.setBounds(400,0,400,250);
b2.setFont(fo2);
pan2.add(b2);
b3=new JButton("MANAGE RESERVATION");
b3.setBounds(0,250,400,250);
b3.setFont(fo2);
pan2.add(b3);
b4=new JButton("HELLO");
b4.setBounds(400,250,400,250);
b4.setFont(fo2);
pan2.add(b4);

//pan1
pan1=new JPanel();
pan1.setSize(200,0);
pan1.setLayout(null);
pan1.setBackground(new Color(0,0,0,80));
pan1.setBounds(0,0,960,70);
imgl.add(pan1); 
label1=new JLabel("Welcome to Hotel TPOLY");
label1.setBounds(150,10,550,50);
label1.setFont(fo1);
label1.setForeground(Color.WHITE);
back=new JButton("LogOut");	
back.setBackground(new Color(40,80,70));
back.setFont(f1);
	back.setForeground(Color.BLACK);
	back.setBounds(805,15,120,40);
pan1.add(back);
pan1.add(label1);	


imgl.add(pan2);
imgl.add(pan1);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
back.addActionListener(this);
setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			CM c=new CM();
			setVisible(false);
					}
					else if(ae.getSource()==b2){
					RM c=new RM();
						setVisible(false);
						
					}		
						else if(ae.getSource()==b3){
						MR C=new MR();
						setVisible(false);
					}
					else if(ae.getSource()==b4){
						
						setVisible(false);
					}
					else if(ae.getSource()==back) {
						login l=new login();
						setVisible(false);
					}
	}



public static void main(String[]args){
ok h=new ok();
}}