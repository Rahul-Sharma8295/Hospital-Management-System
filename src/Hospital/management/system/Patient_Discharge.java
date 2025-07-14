package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame
{
    Patient_Discharge()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JLabel label=new JLabel("Check out");
        label.setBounds(250,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2=new JLabel(" Patient ID : ");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try
        {
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next())
            {
                choice.add(resultSet.getString("Number"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        JLabel label3=new JLabel("Room Number :");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel Rn=new JLabel();
        Rn.setBounds(200,130,150,15);
        Rn.setFont(new Font("Tahoma",Font.BOLD,15));
        Rn.setForeground(Color.white);
        panel.add(Rn);


        JLabel label4=new JLabel("IN Time: ");
        label4.setBounds(30,180,350,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        label4.setForeground(Color.white);
        panel.add(label4);


        JLabel INTIME=new JLabel();
        INTIME.setBounds(200,180,150,20);
        INTIME.setFont(new Font("Tahoma",Font.BOLD,15));
        INTIME.setForeground(Color.white);
        panel.add(INTIME);

        JLabel label5=new JLabel("Out Time : ");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        label5.setForeground(Color.white);
        panel.add(label5);


        Date date=new Date();

        JLabel OUTTIME=new JLabel(""+date);
        OUTTIME.setBounds(200,230,350,15);
        OUTTIME.setFont(new Font("Tahoma",Font.BOLD,15));
        OUTTIME.setForeground(Color.white);
        panel.add(OUTTIME);

        JButton dischage=new JButton("Dischage");
        dischage.setBounds(30,300,130,30);
        dischage.setForeground(Color.white);
        dischage.setBackground(Color.BLACK);
        panel.add(dischage);
        dischage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    c.statement.executeUpdate("delete from Patient_Info where Number='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update Room set Availability='Available' where Room_no='"+Rn.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });



        JButton check=new JButton("Check");
        check.setBounds(165,300,130,30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Conn c=new Conn();
                try {
                    ResultSet resultSet=c.statement.executeQuery("Select * from Patient_Info where Number='"+choice.getSelectedItem()+"'");
                    while (resultSet.next())
                    {
                        Rn.setText(resultSet.getString("Room_Number"));
                        INTIME.setText(resultSet.getString("Time"));
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });


        JButton button=new JButton("Back");
        button.setBounds(300,300,130,30);
        button.setForeground(Color.white);
        button.setBackground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Patient_Discharge();
    }

}
