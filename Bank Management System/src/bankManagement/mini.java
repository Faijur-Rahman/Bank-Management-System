package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {

    String pin;

    mini(String pin) {

        //this.pin = pin;
        setTitle("Mini Statement");

        setLayout(null);

        JButton b1;

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Yuki Bank");
       // bank.setForeground(Color.WHITE);
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
       // card.setForeground(Color.WHITE);
        card.setBounds(20,80,300,20);
        add(card);

        JLabel mini = new JLabel();
        //mini.setForeground(Color.WHITE);
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel balance = new JLabel();
        //balance.setForeground(Color.WHITE);
        balance.setBounds(20,400,300,20);
        add(balance);


        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next()) {
                card.setText("Card Number: "+ "XXXXXXXXXX"+resultSet.getString("card_no").substring(10));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int bal = 0;
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()) {
                mini.setText(mini.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");
                if(resultSet.getString("type").equals("Deposit")) {
                    bal += (int) Long.parseLong(resultSet.getString("amount"));
                } else  {
                    bal -= (int) Long.parseLong(resultSet.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs. "+bal);



        }catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("EXIT");
        b1.setBounds(20,500,100,25);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);


        setSize(400,600);
        setLocation(20,20);
        //setBackground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
//        new main_Class(pin);

    }

    public static void main(String[] args) {
        new mini("");



    }

}
