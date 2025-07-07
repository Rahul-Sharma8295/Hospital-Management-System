package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {
        JComboBox ComboBox;
        JTextField textFieldNumber,textName,textFieldDisease,textFieldDeposite;
        JRadioButton r1,r2;
        Choice c1;
        JLabel date;
        JButton b1,b2;


    NEW_PATIENT()
    {

        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);


        JLabel labelName=new JLabel("New Patient Form");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID=new JLabel("ID : ");
        labelID.setBounds(135,90,300,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        ComboBox=new JComboBox(new String[]{"Aadhar Card","Voter ID","Driving Licence","Mobile Number "});
        ComboBox.setBounds(250,90,150,20);
        ComboBox.setBackground(new Color(3,45,48));
        ComboBox.setForeground(Color.white);
        ComboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(ComboBox);



        JLabel labelNumber=new JLabel("Number : ");
        labelNumber.setBounds(135,120,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);


        textFieldNumber=new JTextField();
        textFieldNumber.setBounds(250,120,175,20);
        panel.add(textFieldNumber);





        JLabel labelName1=new JLabel("Name : ");
        labelName1.setBounds(135,150,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);


        textName=new JTextField();
        textName.setBounds(250,150,175,20);
        panel.add(textName);






        JLabel labelGender=new JLabel("Gender : ");
        labelGender.setBounds(135,190,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);


        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(250,191,80,15);
        panel.add(r1);



        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);



        JLabel labelDisease=new JLabel("Disease : ");
        labelDisease.setBounds(135,230,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);


        textFieldDisease=new JTextField();
        textFieldDisease.setBounds(250,231,175,20);
        panel.add(textFieldDisease);





        JLabel labelRoom=new JLabel("Room : ");
        labelRoom.setBounds(140,270,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        //Room choice

        c1=new Choice();
        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("Select * from room");
            while (resultSet.next())
            {
                c1.add(resultSet.getString("Room_no"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        c1.setBounds(250,280,160,40);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);






        JLabel labelDate=new JLabel("Time : ");
        labelDate.setBounds(140,310,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1=new Date();
        date=new JLabel(""+date1);
        date.setBounds(245,310,200,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tohoma",Font.BOLD,14));
        panel.add(date);








        JLabel labelDeposite=new JLabel("Deposite : ");
        labelDeposite.setBounds(135,340,200,14);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);


        textFieldDeposite=new JTextField();
        textFieldDeposite.setBounds(250,341,175,20);
        panel.add(textFieldDeposite);


        b1=new JButton("Add");
        b1.setBounds(260,430,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("Back");
        b2.setBounds(400,430,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);



        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            Conn c=new Conn();
            String radioBTN=null;
            if(r1.isSelected())
            {
                radioBTN="MALE";
            } else if (r2.isSelected())
            {
                radioBTN="FEMALE";
            }

            String s1=(String)ComboBox.getSelectedItem();
            String s2=textFieldNumber.getText();
            String s3=textName.getText();
            String s4=radioBTN;
            String s5=textFieldDisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=textFieldDeposite.getText();
;
            try{
//                String q="insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q = "INSERT INTO patient_info (ID, Number, name, Gender, Patient_Disease, Room_Number, Time, Deposite) VALUES ('"
                        + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";

                String q1="update Room set Availability='Occupied' where Room_no="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }

        }
        else
        {
            setVisible(false);
        }


    }


    public static void main(String[] args) {
    new NEW_PATIENT();
    }

}
