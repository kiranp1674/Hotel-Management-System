package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUP extends JFrame {
    PickUP(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel PUS = new JLabel("PICK UP SERVICE");
        PUS.setBounds(90,11,260,20);
        PUS.setForeground(Color.WHITE);
        PUS.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(PUS);

        JLabel TOC = new JLabel("Type Of Car");
        TOC.setBounds(32,97,89,14);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(TOC);

        Choice c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try{
            DBcon C = new DBcon();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while(resultSet.next()){
                c.add(resultSet.getString("carname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            DBcon C = new DBcon();
            String q = " select * from driver";
            ResultSet resultSet = C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("NAME");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.white);
        panel.add(name);

        JLabel age = new JLabel("AGE");
        age.setBounds(165,208,46,14);
        age.setForeground(Color.white);
        panel.add(age);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(264,208,100,14);
        gender.setForeground(Color.white);
        panel.add(gender);

        JLabel company = new JLabel("COMPANY");
        company.setBounds(366,208,100,14);
        company.setForeground(Color.white);
        panel.add(company);

        JLabel CarName = new JLabel("CAR NAME");
        CarName.setBounds(486,208,100,14);
        CarName.setForeground(Color.white);
        panel.add(CarName);

        JLabel available = new JLabel("AVAILABILITY");
        available.setBounds(600,208,100,14);
        available.setForeground(Color.white);
        panel.add(available);

        JLabel location = new JLabel("LOCATION");
        location.setBounds(700,208,100,14);
        location.setForeground(Color.white);
        panel.add(location);


        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.white);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '"+c.getSelectedItem()+"'";
                try{
                    DBcon c = new DBcon();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setLayout(null);
        setLocation(500,100);
        setSize(800,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PickUP();
    }
}
