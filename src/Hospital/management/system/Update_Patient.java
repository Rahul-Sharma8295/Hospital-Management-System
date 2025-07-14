package Hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient extends JFrame {
    Update_Patient()
    {

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);


        JLabel label1=new JLabel("Update Patient Detail");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);


        JLabel label2=new JLabel("Name :");
        label2.setBounds(20,88,200,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,20));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(248,80,150,25);
        panel.add(choice);

        try
        {
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next())
            {
                choice.add(resultSet.getString("Name"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number :");
        label3.setBounds(25,129,240,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,20));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldr=new JTextField();
        textFieldr.setBounds(248,129,140,20);
        panel.add(textFieldr);

        JLabel label4=new JLabel("In Time :");
        label4.setBounds(25,174,240,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,20));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldInTime=new JTextField();
        textFieldInTime.setBounds(248,174,140,20);
        panel.add(textFieldInTime);


        JLabel label5=new JLabel("Amount Paid (RS) :");
        label5.setBounds(25,216,240,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,20));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount=new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);


        JLabel label6=new JLabel("Pending Amount (RS) :");
        label6.setBounds(25,261,240,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,20));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending =new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

//
        JButton button=new JButton("Check");
        button.setBounds(270,310,89,23);
        button.setForeground(Color.white);
        button.setBackground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = choice.getSelectedItem();
                String q = "SELECT * FROM patient_info WHERE name='" + name + "'";

                try {
                    Conn c = new Conn();

                    ResultSet resultSet = c.statement.executeQuery(q);
                    if (resultSet.next()) {
                        String roomNumber = resultSet.getString("Room_Number");
                        textFieldr.setText(roomNumber);
                        textFieldInTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));

                        ResultSet resultSet1 = c.statement.executeQuery("SELECT * FROM Room WHERE Room_no='" + roomNumber + "'");
                        if (resultSet1.next()) {
                            String price = resultSet1.getString("Price");
                            int pendingAmount = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                            textFieldPending.setText(String.valueOf(pendingAmount));
                        } else {
                            JOptionPane.showMessageDialog(null, "Room not found in Room table.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient not found.");
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + E.getMessage());
                }
            }
        });



        JButton button2=new JButton("Update");
        button2.setBounds(120,378,130,30);
        button2.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                    Conn c=new Conn();
                    String q=choice.getSelectedItem();
                    String room=textFieldr.getText();
                    String time=textFieldInTime.getText();
                    String amount=textFieldAmount.getText();
                    c.statement.executeUpdate("update Patient_Info set Room_Number='"+room+"',Time='"+time+"',Deposite='"+amount+"' where Name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });


        JButton button3=new JButton("Back");
        button3.setBounds(270,378,130,30);
        button3.setForeground(Color.white);
        button3.setBackground(Color.BLACK);
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Update_Patient();
    }
}
