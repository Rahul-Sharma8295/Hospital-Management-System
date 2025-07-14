package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JTextField passwordFiled;
    JButton b1,b2;

    Login()
    {
//username Label
        JLabel nameLabel=new JLabel("USER NAME - ");
        nameLabel.setBounds(150,200,150,30);
        nameLabel.setFont(new Font("Tohoma",Font.BOLD,20));
        nameLabel.setForeground(new Color(13, 11, 11));
        add(nameLabel);

//password label
        JLabel password=new JLabel("Password  -");
        password.setBounds(150,250,150,30);
        password.setFont(new Font("Tohoma",Font.BOLD,20));
        password.setForeground(new Color(0,0,0));
        add(password);

//username field
        textField=new JTextField();
        textField.setBounds(300,200,250,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,20));
        textField.setBackground(new Color(236, 234, 228));
        add(textField);

//passwordFiled
        passwordFiled=new JPasswordField();
        passwordFiled.setBounds(300,250,250,30);
        passwordFiled.setFont(new Font("Tohoma",Font.PLAIN,20));
        passwordFiled.setBackground(new Color(236,234,228));
        add(passwordFiled);

//Image
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/download.jpeg"));
        Image i1=imageIcon.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(-90,-50,400,300);
        add(label);
//Button

        b1=new JButton("Login");
        b1.setBounds(220,350,100,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(350,350,100,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164,170));
        setSize(700,600);
        setLocation(500,150);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try{
                Conn c=new Conn();
                String user=textField.getText();
                String pass=passwordFiled.getText();
                String q="select * from login where ID='"+user+"' and PW='"+pass+"'";
                ResultSet resultSet=c.statement.executeQuery(q);

                if(resultSet.next())
                {
                    new Reception();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else
        {
            System.exit(10);
        }

    }
    public static void main(String[] args) {
        new Login();
    }


}



