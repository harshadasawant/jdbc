import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class PraparedStatmentTest {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            int id= sc.nextInt();
            String name = sc.next();
            int age = sc.nextInt();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1","root","root");
            PreparedStatement stmt=con.prepareStatement("insert into emp values (?, ?,?,2)");
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setInt(3,age);
           int record =  stmt.executeUpdate();
            System.out.println(record +" are inserted ");
            stmt.close();
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
