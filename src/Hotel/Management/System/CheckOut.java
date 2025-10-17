package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,100,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel UserId = new JLabel("Customer ID");
        UserId.setBounds(30,80,150,30);
        UserId.setFont(new Font("Tahoma",Font.BOLD,14));
        UserId.setForeground(Color.white);
        panel.add(UserId);

        Choice customer = new Choice();
        customer.setBounds(200,80,150,25);
        panel.add(customer);

        JLabel room = new JLabel("Room Nummber");
        room.setBounds(30,130,150,30);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        room.setForeground(Color.white);
        panel.add(room);

        JLabel labelRoomNumber = new JLabel();
        labelRoomNumber.setBounds(200,130,150,30);
        labelRoomNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoomNumber.setForeground(Color.white);
        panel.add(labelRoomNumber);

        JLabel checkInTime = new JLabel("Check-In Time");
        checkInTime.setBounds(30,180,150,30);
        checkInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkInTime.setForeground(Color.white);
        panel.add(checkInTime);

        JLabel labelcheckInTime = new JLabel();
        labelcheckInTime.setBounds(200,180,200,30);
        labelcheckInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckInTime.setForeground(Color.white);
        panel.add(labelcheckInTime);

        JLabel checkOutTime = new JLabel("Check-Out Time");
        checkOutTime.setBounds(30,230,150,30);
        checkOutTime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkOutTime.setForeground(Color.white);
        panel.add(checkOutTime);

        Date date = new Date();


        JLabel labelcheckOutTime = new JLabel(""+date);
        labelcheckOutTime.setBounds(200,230,200,30);
        labelcheckOutTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckOutTime.setForeground(Color.white);
        panel.add(labelcheckOutTime);

        try{
            DBcon C = new DBcon();
            ResultSet resultSet = C.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                customer.add(resultSet.getString("number"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30,300,120,30);
        checkOut.setForeground(Color.white);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DBcon cv = new DBcon();
                    cv.statement.executeUpdate("delete from customer where number = '"+customer.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update room set availability = 'Available' where roomnumber = '"+labelRoomNumber.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBcon c = new DBcon();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where number = '"+customer.getSelectedItem()+"'");
                    while (resultSet.next()){
                        labelRoomNumber.setText(resultSet.getString("room"));
                        labelcheckInTime.setText(resultSet.getString("checkintime"));

                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
