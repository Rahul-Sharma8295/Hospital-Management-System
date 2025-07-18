package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;
import java.sql.ResultSet;

public class Employee_Info extends JFrame {
    Employee_Info()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try
        {
            Conn conn=new Conn();
            String q="Select * from Emp_Info";
            ResultSet resultSet=conn.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Name");
        label1.setBounds(41,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);


        JLabel label2=new JLabel("Age");
        label2.setBounds(180,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Mobile  number");
        label3.setBounds(330,9,200,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);



        JLabel label4=new JLabel("Salary");
        label4.setBounds(500,9,200,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);



        JLabel label5=new JLabel("Gmail ID");
        label5.setBounds(670,9,200,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);


        JLabel label6=new JLabel("Addhar Number");
        label6.setBounds(830,9,200,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);


        JButton button=new JButton("Back");
        button.setBounds(400,500,150,50);
        button.setForeground(Color.red);
        button.setBackground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(1000,600);
        setLayout(null);
        setLocation(350,230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_Info();
    }
}
