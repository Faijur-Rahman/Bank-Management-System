package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1,b2;
    Deposit(String pin) {

        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));  // for bank logo in the head
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel label1 = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,13));
        label1.setBounds(170,250,400,35);
        image.add(label1);

        textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setBounds(170,290,290,25);
        textField.setFont(new Font("Raleway",Font.BOLD,19));
        image.add(textField);

        b1 = new JButton("Deposit");
        b1.setBounds(350,405,150,30);
        b1.setFont(new Font("Raleway",Font.BOLD,13));
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(350,440,150,30);
        b2.setFont(new Font("Raleway",Font.BOLD,13));
        b2.addActionListener(this);
        image.add(b2);



        setSize(900,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
                } else {
                    conn con1 = new conn();
                    con1.statement.executeUpdate ("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully ");
                    setVisible(false);
                    new main_Class(pin);
                }
            } else if (e.getSource()==b2) {
                setVisible(false);
                new main_Class(pin);

            }

        }catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
