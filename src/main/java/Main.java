import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=CET";
        String user = "root";
        String password = "K0czk0d4n!";

        try {
            String query = "SELECT * from country;";
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("CO_ID"));
                System.out.println(resultSet.getString("CO_NAME"));
                System.out.println(resultSet.getString("CO_ALIAS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
