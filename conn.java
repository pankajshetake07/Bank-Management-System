package bankmanagement;

import java.sql.*;
public class conn
{
    Connection c;
    static Statement s;
    public conn()
    {
        try
        {
            //Class.forName(com.mysql.cj.jdbc.Driver);  //register driver
            c = DriverManager.getConnection("jdbc:mysql:///bank_management","root","pankajshetake");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}