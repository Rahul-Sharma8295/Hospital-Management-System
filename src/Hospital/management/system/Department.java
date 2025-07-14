package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame
{
  Department()
  {
      JPanel panel=new JPanel();
      panel.setBounds(5,5,690,490);
      panel.setLayout(null);
      panel.setBackground(new Color(90,156,163));
      add(panel);

      JTable table=new JTable();
      table.setBounds(0,40,700,250);
      table.setForeground(new Color(90,156,163));
      table.setFont(new Font("Tahoma",Font.BOLD,14));
      panel.add(table);


      try
      {
        Conn c=new Conn();
        String q="Select * from Department";
          ResultSet resultSet=c.statement.executeQuery(q);
          {
              table.setModel(DbUtils.resultSetToTableModel(resultSet));
          }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }


      JLabel label=new JLabel("Department");
      label.setBounds(130,11,105,20);
      label.setFont(new Font("Tahoma",Font.BOLD,14));
      panel.add(label);

      JLabel label1=new JLabel("Phone number");
      label1.setBounds(390,11,120,20);
      label1.setFont(new Font("Tahoma",Font.BOLD,14));
      panel.add(label1);

        JButton button=new JButton("Back");
        button.setBounds(280,350,130,30);
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
    setSize(700,500);
    setLayout(null);
    setLocation(350,250);
    setVisible(true);

  }

    public static void main(String[] args) {
        new Department();
    }

}
