package bankmanagement;

import com.sun.org.apache.xerces.internal.impl.xs.SubstitutionGroupHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin_Change extends JFrame implements ActionListener
{

    JButton change,back;
    String pinnumber;
    JLabel text,pinchange,repin;
    JPasswordField j1,j2;
    Pin_Change(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("atm.jpg")));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,700);
        add(image);

        text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(300,250,200,25);
        image.add(text);

        pinchange = new JLabel("Enter new PIN");
        pinchange.setForeground(Color.WHITE);
        pinchange.setFont(new Font("Raleway",Font.BOLD,16));
        pinchange.setBounds(200,300,200,25);
        image.add(pinchange);

        j1 = new JPasswordField();
        j1.setBounds(350,300,200,25);
        j1.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(j1);

        repin = new JLabel("Re-Enter new PIN");
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(200,350,200,25);
        image.add(repin);

        j2 = new JPasswordField();
        j2.setBounds(350,350,200,25);
        j2.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(j2);

        change = new JButton("Change");
        change.setFont(new Font("Raleway",Font.BOLD,16));
        change.setBounds(455,410,100,25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(455,440,100,25);
        back.addActionListener(this);
        image.add(back);

        setSize(1000,1000);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==change)
        {
            try
            {
                String npin = j1.getText();
                String rpin = j2.getText();
                if(!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enter correct PIN");
                    return;
                }
                if (npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter correct PIN");
                    return;
                }
                if (rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter correct PIN");
                    return;
                }

                conn c1 = new conn();
                String query1 = "update bank set pin = '"+rpin+"'where pin = '"+pinnumber+"'";
                String query2 = "update Login set PIN_Number = '"+rpin+"'where PIN_Number = '"+pinnumber+"'";
                String query3 = "update signup3 set PIN_Number = '"+rpin+"'where PIN_Number = '"+pinnumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Pin_Change("").setVisible(true);
    }
}
