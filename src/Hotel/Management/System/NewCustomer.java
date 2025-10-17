package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonWritableChannelException;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber,textName,textCountry,textDepoite;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton add,back;

    NewCustomer(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(550,150,200,200);
        panel.add(imageLabel);


        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.white);
        panel.add(labelName);


        JLabel labelId = new JLabel("ID: ");
        labelId.setBounds(35,76,200,14);
        labelId.setForeground(Color.white);
        labelId.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelId);

        comboBox = new JComboBox(new String[] {"PassPort","Aadhar Card","Voter ID","Diving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(comboBox);

        JLabel labelNo = new JLabel("NUMBER: ");
        labelNo.setBounds(35,111,200,14);
        labelNo.setForeground(Color.white);
        labelNo.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelNo);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("NAME: ");
        labelName1.setBounds(35,151,200,14);
        labelName1.setForeground(Color.white);
        labelName1.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelName1);
        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);


        JLabel gender = new JLabel("GENDER: ");
        gender.setBounds(35,191,200,14);
        gender.setForeground(Color.white);
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(gender);
        r1 = new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3,45,48));
        r1.setBounds(271,191,80,12);
        panel.add(r1);
        r2 = new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3,45,48));
        r2.setBounds(350,191,110,12);
        panel.add(r2);

        JLabel labelCountry = new JLabel("COUNTRY: ");
        labelCountry.setBounds(35,231,200,14);
        labelCountry.setForeground(Color.white);
        labelCountry.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelCountry);
        textCountry = new JTextField();
        textCountry.setBounds(271,231,150,20);
        panel.add(textCountry);

        JLabel labelRoom = new JLabel("Allocated Room Number: ");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setForeground(Color.white);
        labelRoom.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelRoom);
        c1 = new Choice();
        try{
            DBcon c = new DBcon();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setBackground(new Color(3,45,48));
        c1.setForeground(Color.white);
        panel.add(c1);

        JLabel labelCIS = new JLabel("Check-In: ");
        labelCIS.setBounds(35,316,200,14);
        labelCIS.setForeground(Color.white);
        labelCIS.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelCIS);
        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(271,316,200,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(date);


        JLabel labelDeposite = new JLabel("Deposite: ");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setForeground(Color.white);
        labelDeposite.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelDeposite);
        textDepoite = new JTextField();
        textDepoite.setBounds(271,359,150,20);
        panel.add(textDepoite);

        add = new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260,430,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            DBcon c = new DBcon();
            String radioBTn = null;
            if(r1.isSelected()){
                radioBTn = "MALE";
            } else if (r2.isSelected()) {
                radioBTn = "FEMALE";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTn;
            String s5 = textCountry.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textDepoite.getText();

            try{
                String q = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set availability = 'Occupied' where roomnumber = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
