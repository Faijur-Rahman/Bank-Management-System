package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton b1;
    JLabel label2;
    String pin;

    BalanceEnquiry(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel label1 = new JLabel("Your current balance is Rs ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,13));
        label1.setBounds(170,235,700,35);
        image.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,13));
        label2.setBounds(170,270,400,35);
        image.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(350,335,150,30);
        b1.setFont(new Font("Raleway",Font.BOLD,13));
        b1.addActionListener(this);
        image.add(b1);

        int balance = 0;
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()) {

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Long.parseLong(resultSet.getString("amount"));
                } else {
                    balance -= Long.parseLong(resultSet.getString("amount"));
                }

            }


        }catch (Exception E){
            E.printStackTrace();

        }

        label2.setText(""+balance);



        setSize(900,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new main_Class(pin);

    }

    public static void main(String[] args) {

        new BalanceEnquiry("");

    }
}
