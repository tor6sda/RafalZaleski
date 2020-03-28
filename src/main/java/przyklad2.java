import util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class przyklad2 {
    public static void main(String[] args) {

        String query = "SELECT * from address where ADD_CITY like \"%\"?\"%\";";

        try (
                PreparedStatement preStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)
        ) {
            preStatement.setString(1, "Paris");
            ResultSet resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ADD_ID");
                String street = resultSet.getString("ADD_STREET");
                String city = resultSet.getString("ADD_CITY");
                System.out.println("Address ID: " + id + " Address Street: " + street + " Address City: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

