package przyklad5;

import util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class przyklad5 {
    public static void main(String[] args) {
        String sqlInsert = "Insert into country " +
                "(CO_NAME, CO_ALIAS) " +
                "VALUES (?,?)";

        Country[] countries = {new Country("Albania", "AL"),
                new Country("China", "CN"),
                new Country("Ukraina", "UA")
        };

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlInsert)) {
            DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
            for (int i = 0; i < countries.length; i++) {
                preparedStatement.setString(1, countries[i].getCountryName());
                preparedStatement.setString(2, countries[i].getCountryAlias());
                preparedStatement.execute();
            }
            DatabaseConnection.getInstance().getConnection().commit();
        } catch (SQLException e) {
            try {
                DatabaseConnection.getInstance().getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
