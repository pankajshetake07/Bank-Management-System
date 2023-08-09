package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class signup2 extends JFrame implements ActionListener
{
    JLabel rel,cat,incm,education,qualification,pan_number,adhar_number,citizen,existion_acc,occu;
    JTextField pan_numberField,adhar_numberTextField;
    JButton next,back;
    JRadioButton  eyes,syes,eno,sno;
    JComboBox religion,category,income,eduqual,occupation;
    ButtonGroup citizenGroup,accGroup;
   // long random;
    String formno;
    signup2(String formno)
    {
        this.formno = formno;
        setLayout(null);


        JLabel personaldetails = new JLabel("Page 2:Additional Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,60,400,30);
        add(personaldetails);

        rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(200,120,400,30);
        add(rel);

        String[] religionval = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(religionval);
        religion.setBounds(400,120,350,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(200,170,400,30);
        add(cat);

        String[] catval = {"Open","OBC","SC","SC","EBC","Other"};
        category = new JComboBox(catval);
        category.setBounds(400,170,350,30);
        category.setBackground(Color.WHITE);
        add(category);


        incm = new JLabel("Annual Income:");
        incm.setFont(new Font("Raleway",Font.BOLD,20));
        incm.setBounds(200,220,400,30);
        add(incm);

        String[] incomeval = {"10000-50000","51000-100000","100000-300000","400000-500000","Above 500000"};
        income = new JComboBox(incomeval);
        income.setBounds(400,220,350,30);
        income.setBackground(Color.WHITE);
        add(income);

        education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(200,270,400,30);
        add(education);

        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(200,300,400,30);
        add(qualification);

        String[] eduval = {"Non-Graduation","Graduate","Post Graduation","Doctrate","Other"};
        eduqual = new JComboBox(eduval);
        eduqual.setBounds(400,280,350,30);
        eduqual.setBackground(Color.WHITE);
        add(eduqual);


        occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        occu.setBounds(200,350,400,30);
        add(occu);

        String[] occupationval = {"Farmer","Teacher","Manager","Clerk","Student","Businessman"};
        occupation = new JComboBox(occupationval);
        occupation.setBounds(400,350,350,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        pan_number = new JLabel("PAN Number:");
        pan_number.setFont(new Font("Raleway",Font.BOLD,20));
        pan_number.setBounds(200,400,400,30);
        add(pan_number);

        pan_numberField = new JTextField();
        pan_numberField.setBounds(400,400,350,30);
        add(pan_numberField);

        adhar_number = new JLabel("Adhar Number:");
        adhar_number.setFont(new Font("Raleway",Font.BOLD,20));
        adhar_number.setBounds(200,450,400,30);
        add(adhar_number);

        adhar_numberTextField = new JTextField();
        adhar_numberTextField.setBounds(400,450,350,30);
        add(adhar_numberTextField);

        citizen = new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Raleway",Font.BOLD,20));
        citizen.setBounds(200,500,400,30);
        add(citizen);


        syes = new JRadioButton("Yes");
        syes.setBounds(400,500,50,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(500,500,50,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        citizenGroup = new ButtonGroup();
        citizenGroup.add(syes);
        citizenGroup.add(sno);

        existion_acc = new JLabel("Existing Account:");
        existion_acc.setFont(new Font("Raleway",Font.BOLD,20));
        existion_acc.setBounds(200,550,400,30);
        add(existion_acc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(400,550,50,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(500,550,50,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        accGroup = new ButtonGroup();
        accGroup.add(eyes);
        accGroup.add(eno);

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

        String religion1 = (String) religion.getSelectedItem();
        String category1 = (String) category.getSelectedItem();
        String incm1 = (String) income.getSelectedItem();
        String seduction = (String) eduqual.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String pan_number1 = pan_numberField.getText();
        String adhar_number1 = adhar_numberTextField.getText();
        String citizen1 = null;
        if(syes.isSelected())
        {
            citizen1 = "Yes";
        }
        else if(sno.isSelected())
        {
            citizen1 = "No";
        }
        String acc = null;
        if(eyes.isSelected())
        {
            acc = "Yes";
        }
        else if(eno.isSelected())
        {
            acc = "No";
        }

//        if(ae.getSource()==back)
//        {
//            setVisible(false);
//            new signup1().setVisible(true);
//        }
//        else if(ae.getSource()==next)
//        {
//            setVisible(false);
//            new signup3().setVisible(true);
//        }

        try
        {
            if(pan_number1.equals(""))
            {
                JOptionPane.showMessageDialog(null,"PAN Number is required");
            }
            if(adhar_number1.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Aadhar Number is required");
            }
            else
            {
                conn c = new conn();
                String query = "insert into signup2 values('" + formno + "','" + religion1 + "','" + category1 + "','" + incm1 + "','" + seduction + "','" + soccupation + "','" + pan_number1 + "','" + adhar_number1 + "','" + citizen1 + "','" + acc + "')";
                c.s.executeUpdate(query);
                if(ae.getSource()==back)
                {
                    setVisible(false);
                    new signup1().setVisible(true);
                }
                else if(ae.getSource()==next)
                {
                    setVisible(false);
                    new signup3(formno).setVisible(true);
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
        new signup2("");
    }
}