package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame
{  Reception()
    {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(Color.white);
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

//        aading doctor image on reception first panel
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(image);
        JLabel label=new JLabel(i2);
        label.setBounds(1300,0,250,250);
        panel1.add(label);
//        aading ambulance image on reception first panel
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1=i3.getImage().getScaledInstance(300,100 ,Image.SCALE_DEFAULT);
        ImageIcon i4=new ImageIcon(image1);
        JLabel label1=new JLabel(i4);
        label1.setBounds(1000,50,300,100);
        panel1.add(label1);

   // Adding image to second panel
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/sai-hospital.png"));
        Image image2 = i5.getImage().getScaledInstance(1525, 670, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(image2);
        JLabel label2 = new JLabel(i6);
        label2.setBounds(20, 20, 1485, 630);
        panel.add(label2);

//        adding new petient button
       JButton btn1=new JButton("Add new Petient");
       btn1.setBounds(30,15,200,30);
       btn1.setBackground(new Color(246,215,118));
       panel1.add(btn1);
       btn1.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
           }
       });

//       aading room button
       JButton btn2=new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(246,215,118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3=new JButton("Department ");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(246,215,118));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new Department();
            }
        });

        JButton btn4=new JButton(" All Employee Information ");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(246,215,118));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new Employee_Info();
            }
        });

        JButton btn5=new JButton("Petient Informataion ");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(new Color(246,215,118));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Info();
            }
        });

        JButton btn6=new JButton("Petient Discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(new Color(246,215,118));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  new Patient_Discharge();
            }
        });


        JButton btn7=new JButton("Update Petient  detail");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(246,215,118));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Patient();
            }
        });


        JButton btn8=new JButton("Hospital Ambulance");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(new Color(246,215,118));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulancee();
            }
        });


        JButton btn9=new JButton("Search Button ");
        btn9.setBounds(510,100,200,30);
        btn9.setBackground(new Color(246,215,118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_Room();

            }
        });


        JButton btn10=new JButton("Logout ");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(new Color(246,215,118));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });



        setSize(1550,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
    new Reception();
    }
}
