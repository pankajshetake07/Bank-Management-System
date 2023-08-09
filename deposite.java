package bankmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Date;
import java.sql.*;

public class deposite extends JFrame implements ActionListener
{
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    deposite(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(220,280,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(220,320,300,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,16));
        deposit.setBounds(455,390,100,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(455,420,100,25);
        back.addActionListener(this);
        image.add(back);

        setSize(1000,700);
        setLocation(200,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==deposit)
        {
            String number = amount.getText();
            Date date =  new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to deposit");
            }
            else
            {
                try {
                    conn c1 = new conn();
                    String query = "Insert into bank values('" + pinnumber + "' , '" + date + "' , 'Deposit' , '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }

            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new deposite("");
    }
}
