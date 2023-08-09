package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener
{
    JLabel type,card,number,pin,pinnumber,services;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton submit,cancel;
    String formno;
    signup3(String formno)
    {
        this.formno = formno;
        setLayout(null);

        JLabel j1 = new JLabel("Page 3 : Account Details");
        j1.setFont(new Font("Raleway",Font.BOLD,22));
        j1.setBounds(280,40,400,40);
        add(j1);

        type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Fixed Deposite Account");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4 = new JRadioButton("Reccurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);


        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,270,200,30);
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBounds(300,270,300,30);
        add(number);

        pin = new JLabel("Pin :");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,320,200,30);
        add(pin);

        pinnumber = new JLabel("1234");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pinnumber.setBounds(300,320,300,30);
        add(pinnumber);

        services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100,370,200,30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,420,200,30);
        add(c1);


        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,420,200,30);
        add(c2);


        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,460,200,30);
        add(c3);

        c4 = new JCheckBox("Email and SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,460,200,30);
        add(c4);

        c5 = new JCheckBox("Checkbook");
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,500,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,500,200,30);
        add(c6);

        submit = new JButton("Submit");
        submit.setBounds(100,570,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accounttype = null;
            if(r1.isSelected())
            {
                accounttype = "Saving Account";
            }
            else if(r2.isSelected())
            {
                accounttype = "Current Account";
            }
            else if(r3.isSelected())
            {
                accounttype = "Fixed Deposite Account";
            }
            else if(r4.isSelected())
            {
                accounttype = "Reccurring Account";
            }

            Random random = new Random();
            String cardnumber = ""+Math.abs((random.nextLong() % 90000000L)+504093600000L);
            String pinnumber = ""+Math.abs((random.nextLong() %9000L)+1000L);

            String facility =  "";
            if(c1.isSelected())
            {
                facility = facility + "ATM Card";
            }
            else if(c2.isSelected())
            {
                facility = facility + "Internet Banking";
            }
            else if(c3.isSelected())
            {
                facility = facility + "Mobile Banking";
            }
            else if(c4.isSelected())
            {
                facility = facility + "Email and SMS Alerts";
            }
            else if(c5.isSelected())
            {
                facility = facility + "Checkbook";
            }
            else if(c6.isSelected())
            {
                facility = facility + "E-Statement";
            }
            try
            {
                if(accounttype.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                conn c = new conn();
                String query = "insert into signup3 values('" + formno + "','" + accounttype + "','" + cardnumber + "','" + pinnumber + "','" + facility  + "')";
                c.s.executeUpdate(query);
                String query2 = "insert into Login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber + "\n PIN Number : "+pinnumber);

                setVisible(false);
                new deposite(pinnumber).setVisible(false);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args)
    {
        new signup3("");
    }
}