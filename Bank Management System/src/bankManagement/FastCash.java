package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;

    String pin;

    FastCash(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));  // for bank logo in the head
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel label1 = new JLabel("Select your withdraw amount");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,19));
        label1.setBounds(190,250,400,35);
        image.add(label1);

        b1 = new JButton("Rs.100");
        b1.setBounds(155,335,150,30);
        b1.setFont(new Font("Raleway",Font.BOLD,12));
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs.500");
        b2.setBounds(350,335,150,30);
        b2.setFont(new Font("Raleway",Font.BOLD,12));
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs.1000");
        b3.setBounds(155,370,150,30);
        b3.setFont(new Font("Raleway",Font.BOLD,12));
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs.2000");
        b4.setBounds(350,370,150,30);
        b4.setFont(new Font("Raleway",Font.BOLD,12));
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs.5000");
        b5.setBounds(155,405,150,30);
        b5.setFont(new Font("Raleway",Font.BOLD,12));
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs.10000");
        b6.setBounds(350,405,150,30);
        b6.setFont(new Font("Raleway",Font.BOLD,12));
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(350,440,150,30);
        b7.setFont(new Font("Raleway",Font.BOLD,12));
        b7.addActionListener(this);
        image.add(b7);






        setSize(900,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

         if (e.getSource()==b7) {
            new main_Class(pin);
            setVisible(false);
        } else {
             String amount = ((JButton)e.getSource()).getText().substring(3);
             conn c = new conn();
             Date date = new Date();
             try {
                 ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                 int balance = 0;
                 while (resultSet.next()) {
                     if(resultSet.getString("type").equals("Deposit")) {
                         balance += Long.parseLong(resultSet.getString("amount"));
                     } else  {
                         balance -= Long.parseLong(resultSet.getString("amount"));
                     }
                 }
                 String num ="17";

                 if (e.getSource() != b7 && balance < Integer.parseInt(amount)) {
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                 }

                 c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawal','" + amount + "')");
                 JOptionPane.showMessageDialog(null,"Rs. " +amount+" Debited successfully");


             } catch (Exception E) {
                 E.printStackTrace();

             }
             setVisible(false);
             new main_Class(pin);

         }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
