package bankmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener
{
    JButton fastcash,ministmt,deposite,changepin,withdrawal,balanceEnq,exit;
    JLabel text;
    String pinnumber;
    Transaction(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("atm.jpg")));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,700);
        add(image);

        text = new JLabel("Please select your Transaction");
        text.setBounds(240,250,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposite = new JButton("Deposite");
        deposite.setBounds(180,350,170,25);
        deposite.setFont(new Font("Raleway",Font.BOLD,16));
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(400,350,170,25);
        withdrawal.setFont(new Font("Raleway",Font.BOLD,16));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(180,380,170,25);
        fastcash.setFont(new Font("Raleway",Font.BOLD,16));
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministmt = new JButton("Mini Statement");
        ministmt.setBounds(400,380,170,25);
        ministmt.setFont(new Font("Raleway",Font.BOLD,16));
        ministmt.addActionListener(this);
        image.add(ministmt);


        changepin = new JButton("PIN Change");
        changepin.setBounds(180,410,170,25);
        changepin.setFont(new Font("Raleway",Font.BOLD,16));
        changepin.addActionListener(this);
        image.add(changepin);

        balanceEnq = new JButton("Balance Enquiry");
        balanceEnq.setBounds(400,410,170,25);
        balanceEnq.setFont(new Font("Raleway",Font.BOLD,16));
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);

        exit = new JButton("Exit");
        exit.setBounds(400,440,170,25);
        exit.setFont(new Font("Raleway",Font.BOLD,16));
        exit.addActionListener(this);
        image.add(exit);

        setSize(1000,1000);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if (ae.getSource()==deposite)
        {
            setVisible(false);
            new deposite(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawal)
        {
            setVisible(false);
            new withdrawal(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==changepin)
        {
            setVisible(false);
            new Pin_Change(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==balanceEnq)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==ministmt)
        {
            //setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Transaction("");
    }
}
