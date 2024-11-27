package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;

    String pin;

    main_Class(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));  // for bank logo in the head
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel label1 = new JLabel("Please select Your Transaction");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,22));
        label1.setBounds(170,250,400,35);
        image.add(label1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(155,335,150,30);
        b1.setFont(new Font("Raleway",Font.BOLD,12));
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setBounds(350,335,150,30);
        b2.setFont(new Font("Raleway",Font.BOLD,12));
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(155,370,150,30);
        b3.setFont(new Font("Raleway",Font.BOLD,12));
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(350,370,150,30);
        b4.setFont(new Font("Raleway",Font.BOLD,12));
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(155,405,150,30);
        b5.setFont(new Font("Raleway",Font.BOLD,12));
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
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
        if (e.getSource()==b1) {
            new Deposit(pin);
            setVisible(false);

        } else if (e.getSource()==b2) {
            new Withdrawal(pin);
            setVisible(false);

        } else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);


        } else if (e.getSource()==b4) {
            new mini(pin);
            setVisible(true);
            

        } else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);

        } else if (e.getSource()==b6) {
            new BalanceEnquiry(pin);
            setVisible(false);
        } else if (e.getSource()==b7) {
            System.exit(0);
        }


    }

    public static void main(String[] args) {

        new main_Class("");

    }
}
