package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_Room extends JFrame {
    Choice choice;
    JTable table;
    JButton b1, b2;

    Search_Room() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250, 11, 186, 31);
        For.setFont(new Font("Tahoma", Font.BOLD, 20));
        For.setForeground(Color.white);
        panel.add(For);

        JLabel status = new JLabel("Status");
        status.setBounds(70, 70, 100, 20);
        status.setFont(new Font("Tahoma", Font.PLAIN, 20));
        status.setForeground(Color.white);
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 187, 700, 210);
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.white);
        panel.add(table);

        try {
            Conn c = new Conn();
            String q = "SELECT * FROM Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel room = new JLabel("Room Number");
        room.setBounds(23, 162, 150, 20);
        room.setFont(new Font("Tahoma", Font.PLAIN, 20));
        room.setForeground(Color.white);
        panel.add(room);

        JLabel available = new JLabel("Available");
        available.setBounds(175, 162, 150, 20);
        available.setFont(new Font("Tahoma", Font.PLAIN, 20));
        available.setForeground(Color.white);
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(400, 162, 150, 20);
        price.setFont(new Font("Tahoma", Font.PLAIN, 20));
        price.setForeground(Color.white);
        panel.add(price);

        JLabel bed = new JLabel("Bed");
        bed.setBounds(580, 162, 150, 20);
        bed.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bed.setForeground(Color.white);
        panel.add(bed);

        b1 = new JButton("Search");
        b1.setBounds(200, 420, 120, 20);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "SELECT * FROM Room WHERE Availability = '" + choice.getSelectedItem() + "'";
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        b2 = new JButton("Back");
        b2.setBounds(380, 420, 120, 20);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              setVisible(false);
            }
        });

        setSize(700, 500);
        setLayout(null);
        setVisible(true);
        setLocation(450, 250);
    }

    public static void main(String[] args) {
        new Search_Room();
    }
}
