package se.lexicon.laurita_charles.data;

import se.lexicon.laurita_charles.db.MySQLConnection;
import se.lexicon.laurita_charles.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleImplementation implements People{
    @Override

    public boolean create(Person person) {
String createSQL= "INSERT INTO person( lastName,firstName,personId)VALUES(?,?,?)";

         Connection connection= null;
         PreparedStatement preparedStatement=null;
        int rowsChanged = 0;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement= connection.prepareStatement(createSQL);
            preparedStatement.setString(1, person.getLastName());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setInt(3, person.getPersonId());

            rowsChanged= preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

if(rowsChanged>=1){
    return true;
}else
        return false;
    }

    @Override
    public Collection<Person> findAll() {

        Collection<Person> personFound = new ArrayList<>();

        String findAll = "SELECT * FROM person ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection= MySQLConnection.getInstance().getConnection();

            preparedStatement= connection.prepareStatement(findAll);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                personFound.add(
                        new Person(
                                resultSet.getString("lastName"),
                                resultSet.getString("firstName"),
                                resultSet.getInt("personId")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personFound;
    }

    @Override
    public Person findById(int personId) {
        Person personFound =null;

        String findById = "SELECT * FROM person WHERE personId =? ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = MySQLConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setInt(1, personId);

            if (resultSet.next()) {
                personFound = new Person(
                        resultSet.getString("lastName"),
                        resultSet.getString("firstName "),
                        resultSet.getInt("personId")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return personFound;
    }

    @Override
    public Collection<Person> findByName(String name) {

        Collection<Person> personFound = new ArrayList<>();

        String findByName = "SELECT * FROM person WHERE name =? ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement= connection.prepareStatement(findByName);

            preparedStatement.setString(1,name);
            resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                personFound.add(
                        new Person(
                                resultSet.getString("lastName"),
                                resultSet.getString("firstName "),
                                resultSet.getInt("personId")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personFound;
    }

    @Override
    public Person update(Person person) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsChanged = 0;
       Person updatedPerson = null;


        try {
            connection = MySQLConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("UPDATE person SET lastName = ?, firstName = ?, WHERE personId = ?");
            preparedStatement.setString(1, person.getLastName());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setInt(3,person.getPersonId());
            rowsChanged= preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rowsChanged>=1){
            return person;
        }else {
        return null;
    }}

    @Override
    public boolean deleteById(int personId) {
        String deleteById = "DELETE FROM person WHERE personId = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isDeleted = false;


        try {
            connection=MySQLConnection.getInstance().getConnection();
            preparedStatement =connection.prepareStatement(deleteById);

            preparedStatement.setInt(1,personId);

            isDeleted=preparedStatement.executeUpdate()>=1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }
}
