package se.lexicon.laurita_charles.data;

import se.lexicon.laurita_charles.db.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PeopleDAO {

    public static void printOutAll() {
        try {
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            String findAll = "SELECT * FROM person";

            ResultSet resultSet = statement.executeQuery(findAll);

            while (resultSet.next()) {
                System.out.println("LASTNAME: " + resultSet.getString("lastName"));
                System.out.println("FIRSTnAME: " + resultSet.getString("firstName"));
                System.out.println("ID: " + resultSet.getString("personId"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }
