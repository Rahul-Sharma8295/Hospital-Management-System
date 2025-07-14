package Hospital.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulancee extends JFrame {
    Ambulancee()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,2000,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,1300,450);
        table.setBackground(Color.white);
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try
        {
            Conn conn=new Conn();
            String q="Select * from Ambulance";
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


        JLabel label2=new JLabel("Gender");
        label2.setBounds(280,9,200,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Car Name");
        label3.setBounds(550,9,200,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);



        JLabel label4=new JLabel("Availabe");
        label4.setBounds(800,9,200,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5=new JLabel("Location");
        label5.setBounds(1050,9,200,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);


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
//        setUndecorated(true);
        setSize(1400,600);
        setLayout(null);
        setLocation(100,100);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Ambulancee();
    }
}

