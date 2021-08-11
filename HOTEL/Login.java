import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login {
private String name;

public Login() {
    JFrame main = new JFrame("LOGIN");
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setResizable(false);
    main.setLayout(null);
    main.setPreferredSize(new Dimension(200, 300));
    main.setLocation(400, 200);

    // Heading: LOGIN
    JLabel heading = new JLabel("LOGIN");
    heading.setBounds(80, 20, 50, 20);
    main.add(heading);

    // Label Username
    JLabel username_label = new JLabel("username: ");
    username_label.setBounds(5, 70, 80, 20);
    main.add(username_label);
    // Textfield Username
    final JTextField username_field = new JTextField();
    username_field.setBounds(70, 70, 120, 20);
    main.add(username_field);
    this.name = username_field.getText();

    // Button Login
    JButton loginBtn = new JButton("LOGIN");
    loginBtn.setBounds(40, 150, 120, 25);
    main.add(loginBtn);
    main.pack();
    main.setVisible(true);

    loginBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            name = username_field.getText();
            System.out.println(name); //IT WORKS
        }
    });
}

public static void main(String[] args) {
    Login me = new Login();
    me.print();//I EXPECT IT WILL PRINT @name BUT NO, WHY? 
}

public void print() {
    System.out.println(name);
}
}