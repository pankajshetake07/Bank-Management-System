package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(90,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,34));
        text.setBounds(220,40,400,40);
        add(text);

        JLabel CardNo = new JLabel("Card No:");
        CardNo.setFont(new Font("Raleway",Font.BOLD,26));
        CardNo.setBounds(120,150,150,30);
        add(CardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);

        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway",Font.BOLD,26));
        Pin.setBounds(120,220,250,30);
        add(Pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


        clear = new JButton("Clear");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            conn c1 = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from Login where Card_Number = '"+cardnumber+"' and PIN_Number = '"+pinnumber+"'";
            try
            {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect card Number or PIN");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new signup1().setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Login();
    }
}