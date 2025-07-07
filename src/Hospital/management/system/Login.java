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
        nameLabel.setBounds(40,100,150,30);
        nameLabel.setFont(new Font("Tohoma",Font.BOLD,20));
        nameLabel.setForeground(new Color(13, 11, 11));
        add(nameLabel);

//password label
        JLabel password=new JLabel("Password  -");
        password.setBounds(40,140,150,30);
        password.setFont(new Font("Tohoma",Font.BOLD,20));
        password.setForeground(new Color(0,0,0));
        add(password);

//username field
        textField=new JTextField();
        textField.setBounds(200,100,250,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,20));
        textField.setBackground(new Color(236, 234, 228));
        add(textField);

//passwordFiled
        passwordFiled=new JPasswordField();
        passwordFiled.setBounds(200,140,250,30);
        passwordFiled.setFont(new Font("Tohoma",Font.PLAIN,20));
        passwordFiled.setBackground(new Color(236,234,228));
        add(passwordFiled);

//Image
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(-110,-100,400,300);
        add(label);
//Button

        b1=new JButton("Login");
        b1.setBounds(70,200,100,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(200,200,100,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164,170));
        setSize(500,400);
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
