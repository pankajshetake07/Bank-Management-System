package bankmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton f1,f2,f3,f4,f5,f6,back;
    JLabel text;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("atm.jpg")));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,700);
        add(image);

        text = new JLabel("Select withdrawal amount");
        text.setBounds(240,250,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setForeground(Color.WHITE);
        image.add(text);

        f1 = new JButton("Rs 500");
        f1.setBounds(180,350,170,25);
        f1.setFont(new Font("Raleway",Font.BOLD,16));
        f1.addActionListener(this);
        image.add(f1);

        f2 = new JButton("Rs 1000");
        f2.setBounds(400,350,170,25);
        f2.setFont(new Font("Raleway",Font.BOLD,16));
        f2.addActionListener(this);
        image.add(f2);

        f3 = new JButton("Rs 2000");
        f3.setBounds(180,380,170,25);
        f3.setFont(new Font("Raleway",Font.BOLD,16));
        f3.addActionListener(this);
        image.add(f3);

        f4 = new JButton("Rs 3000");
        f4.setBounds(400,380,170,25);
        f4.setFont(new Font("Raleway",Font.BOLD,16));
        f4.addActionListener(this);
        image.add(f4);


        f5 = new JButton("Rs 5000");
        f5.setBounds(180,410,170,25);
        f5.setFont(new Font("Raleway",Font.BOLD,16));
        f5.addActionListener(this);
        image.add(f5);

        f6 = new JButton("Rs 10,000");
        f6.setBounds(400,410,170,25);
        f6.setFont(new Font("Raleway",Font.BOLD,16));
        f6.addActionListener(this);
        image.add(f6);

        back = new JButton("Back");
        back.setBounds(400,440,170,25);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);

        setSize(1000,1000);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c = new conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance = 0;
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

                if (ae.getSource()!=back && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }

                Date date = new Date();
                String query = "Insert into bank values ('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args)
    {
        new FastCash("");
    }
}
