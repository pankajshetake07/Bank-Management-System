package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame
{
    String pinnumber;
    MiniStatement(String pinnumber)
    {
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel bal = new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);

        try
        {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from Login where PIN_Number = '"+pinnumber+"' ");
            while (rs.next())
            {
                card.setText("Card Number : "+rs.getString("Card_Number").substring(0,4)+ "xxxx" + rs.getString("Card_Number").substring(8));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            conn c1 = new conn();
            int balance = 0;
            ResultSet rs1 = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
            while (rs1.next())
            {
                text.setText(text.getText() + "<html>" + rs1.getString("Date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("Amount")+"<br><br><html>");
                if (rs1.getString("Type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs1.getString("Amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs1.getString("Amount"));
                }
            }
            bal.setText("Your current account balance is Rs "+balance);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        text.setBounds(20,140,400,200);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new MiniStatement("");
    }
}
