package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("atm.jpg")));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,700);
        add(image);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(440,440,130,25);
        back.addActionListener(this);
        image.add(back);

        conn c = new conn() ;
        int balance = 0;
        try
        {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "' ");
            while (rs.next())
            {
                if (rs.getString("Type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("Amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current Account Balance is Rs "+balance);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(180,300,400,30);
        image.add(text);

        setSize(1000,1000);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }


    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
