package bankManagement;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4,r5;
    JButton next;

    JTextField textName,textFName,textEmail,textAdd,textCity,textPcode,textState;
    JDateChooser datechooser;

    Random ran = new Random();

    long first4 = (ran.nextLong() % 9000L) + 1000L;

    String first = " " + Math.abs(first4);

    Signup(){

        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));  // for bank logo in the head
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Ralway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330,70,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290,90,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(100,160,100,30);
        labelName.setFont(new Font("Ralway",Font.BOLD,20));
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,160,400,30);
        add(textName);

        JLabel labelFName = new JLabel("Father's Name :");
        labelFName.setBounds(100,210,200,30);
        labelFName.setFont(new Font("Ralway",Font.BOLD,20));
        add(labelFName);

        textFName = new JTextField();
        textFName.setFont(new Font("Raleway",Font.BOLD,14));
        textFName.setBounds(300,210,400,30);
        add(textFName);

        JLabel DOB = new JLabel("Date of Birth");
        DOB.setBounds(100,310,200,30);
        DOB.setFont(new Font("Ralway",Font.BOLD,20));
        add(DOB);

        datechooser = new JDateChooser();
        datechooser.setForeground(new Color(105,105,105));
        datechooser.setBounds(300,310,400,30);
        add(datechooser);

        JLabel labelG = new JLabel("Gender");
        labelG.setBounds(100,260,100,30);
        labelG.setFont(new Font("Ralway",Font.BOLD,20));
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Ralway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,260,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222,255,228));
        r2.setFont(new Font("Ralway",Font.BOLD,14));
        r2.setBounds(450,260,90,30);
        add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        JLabel labelEmail = new JLabel("Email Address :");
        labelEmail.setFont(new Font("Ralway",Font.BOLD,20));
        labelEmail.setBounds(100,360,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,360,400,30);
        add(textEmail);

        JLabel labelMarital = new JLabel("Marital Status :");
        labelMarital.setFont(new Font("Ralway",Font.BOLD,20));
        labelMarital.setBounds(100,410,200,30);
        add(labelMarital);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(new Color(222,255,228));
        r3.setBounds(300,410,100,30);
        add(r3);

        r4 = new JRadioButton("UnMarried");
        r4.setBackground(new Color(222,255,228));
        r4.setFont(new Font("Ralway",Font.BOLD,14));
        r4.setBounds(450,410,100,30);
        add(r4);

        r5 = new JRadioButton("Other");
        r5.setBackground(new Color(222,255,228));
        r5.setFont(new Font("Ralway",Font.BOLD,14));
        r5.setBounds(600,410,100,30);
        add(r5);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(r3);
        buttonGroup2.add(r4);
        buttonGroup2.add(r5);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Ralway",Font.BOLD,20));
        labelAdd.setBounds(100,460,200,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,460,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Ralway",Font.BOLD,20));
        labelCity.setBounds(100,510,200,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,510,400,30);
        add(textCity);

        JLabel labelPcode = new JLabel("Pin Code :");
        labelPcode.setFont(new Font("Ralway",Font.BOLD,20));
        labelPcode.setBounds(100,560,200,30);
        add(labelPcode);

        textPcode = new JTextField();
        textPcode.setFont(new Font("Raleway",Font.BOLD,14));
        textPcode.setBounds(300,560,400,30);
        add(textPcode);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Ralway",Font.BOLD,20));
        labelState.setBounds(100,610,200,30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,610,400,30);
        add(textState);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Ralway",Font.BOLD,14));
        next.setForeground(Color.white);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,750);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String fname = textFName.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;

        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital = null;

        if (r3.isSelected()) {
            marital = "Married";
        } else if (r4.isSelected()) {
            marital = "unMarried";
        } else if (r5.isSelected()) {
            marital = "Other";
        }

        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPcode.getText();
        String state = textState.getText();

        try {
            if (textName.equals("")) {
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            } else {
                conn con1 = new conn();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                con1.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }

        } catch (Exception E) {

        }



    }

    public static void main(String[] args) {
        new Signup();
    }
}
