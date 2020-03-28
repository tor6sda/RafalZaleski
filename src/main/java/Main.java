import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        String url = "jdbc.mysql://localhost:3306/shop";
        connection = DriverManager.getConnection()

    }
}
