package Hospital.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn
{
    Connection connection;
    Statement statement;

    public Conn()
    {
        try
        {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","System");
            statement=connection.createStatement();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
