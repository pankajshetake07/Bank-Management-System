package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdrawal extends JFrame implements ActionListener
{
    JLabel text;
    JTextField j1;
    JButton with,back;
    String pinnumber;
    withdrawal(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,700);
        add(image);

        text = new JLabel("Please enter your amount you want to withdraw");
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(195,280,400,30);
        image.add(text);

        j1 = new JTextField();
        j1.setBounds(195,320,350,25);
        j1.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(j1);

        with = new JButton("Withdraw");
        with.setBounds(420,405,140,25);
        with.setFont(new Font("Raleway",Font.BOLD,16));
        with.addActionListener(this);
        image.add(with);

        back = new JButton("Back");
        back.setBounds(420,435,140,25);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);

        setSize(1000,700);
        setLocation(200,0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==with)
        {
            String number = j1.getText();
            Date date = new Date();
            if (number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter amount you want to withdraw");
            }
            else
            {
                try
                {
                    conn c1 = new conn();
                    String query = "Insert into bank values('" + pinnumber + "' , '" + date + "' , 'Withdraw' , '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number+" Withdraw Successfully");
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
    public static void main(String[] args) {
        new withdrawal("");
    }
}
