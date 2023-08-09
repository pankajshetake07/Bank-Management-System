package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class signup1 extends JFrame implements ActionListener
{
    JLabel fname,mname,lname,dob,gender,address,city,state,pincode,email;
    JTextField fnameTextField,mnameTextField,lnameTextField,addressField,cityTextField,stateTextField,pinTextField,mailTextField;
    JButton next,back;
    JRadioButton  male,female,other;
    ButtonGroup genderGroup;
    JDateChooser dateChooser;
    long random;
    signup1()
    {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno = new JLabel("Application form no . "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,34));
        formno.setBounds(180,10,600,40);
        add(formno);

        JLabel personaldetails = new JLabel("Page 1:Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,60,400,30);
        add(personaldetails);

        fname = new JLabel("First Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(200,120,400,30);
        add(fname);

        fnameTextField = new JTextField();
        //fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(400,120,350,30);
        add(fnameTextField);

        mname = new JLabel("Middle Name:");
        mname.setFont(new Font("Raleway",Font.BOLD,20));
        mname.setBounds(200,170,400,30);
        add(mname);

        mnameTextField = new JTextField();
        mnameTextField.setBounds(400,170,350,30);
        add(mnameTextField);

        lname = new JLabel("Last Name:");
        lname.setFont(new Font("Raleway",Font.BOLD,20));
        lname.setBounds(200,220,400,30);
        add(lname);

        lnameTextField = new JTextField();
        lnameTextField.setBounds(400,220,350,30);
        add(lnameTextField);

        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(200,270,400,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(400,270,350,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(200,320,400,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(400,320,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(500,320,70,30);
        female.setBackground(Color.WHITE);
        add(female);
        other = new JRadioButton("Other");
        other.setBounds(600,320,70,30);
        other.setBackground(Color.WHITE);
        add(other);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(200,370,400,30);
        add(email);

        mailTextField = new JTextField();
        mailTextField.setBounds(400,370,350,30);
        add(mailTextField);

        address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(200,420,400,30);
        add(address);

        addressField = new JTextField();
        addressField.setBounds(400,420,350,30);
        add(addressField);

        city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(200,470,400,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(400,470,350,30);
        add(cityTextField);

        state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(200,520,400,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(400,520,350,30);
        add(stateTextField);

        pincode = new JLabel("Pin code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(200,570,400,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setBounds(400,570,350,30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBounds(500,630,70,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBounds(400,630,70,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String formno1 = String.valueOf(random);
        String firstname = fnameTextField.getText();
        String middlename = mnameTextField.getText();
        String lastname = lnameTextField.getText();
        String dateofbirth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender1 = null;
        if(male.isSelected())
        {
            gender1="Male";
        }
        else if(female.isSelected())
        {
            gender1="Female";
        }
        else
        {
            gender1="Other";
        }
        String Email = mailTextField.getText();
        String address1 = addressField.getText();
        String city1 = cityTextField.getText();
        String state1 = stateTextField.getText();
        String pincode1 = pinTextField.getText();
//        if(ae.getSource()==next)
//        {
//            setVisible(false);
//            new signup2().setVisible(true);
//        }
//        else if(ae.getSource()==back)
//        {
//            setVisible(false);
//            new Login().setVisible(true);
//        }
        try
        {
            if(firstname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"First name is required");
                new signup2(formno1).setVisible(false);
            }
            else {
                conn c = new conn();
                String query = "insert into signup1 values('" + formno1 + "','" + firstname + "','" + middlename + "','" + lastname + "','" + dateofbirth + "','" + gender1 + "','" + Email + "','" + address1 + "','" + city1 + "','" + state1 + "','" + pincode1 + "')";
                c.s.executeUpdate(query);
                if(ae.getSource()==next)
                {
                    setVisible(false);
                    new signup2(formno1).setVisible(true);
                }
                else if(ae.getSource()==back)
                {
                    setVisible(false);
                    new Login().setVisible(true);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        new signup1();
    }
}