package se.lexicon.laurita_charles.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL="jdbc:mysql://localhost:3306/library";
    private static final String USERNAME= "root";
    private static final String PASSWORD ="Hello world12";

    private static final MySQLConnection instance=new MySQLConnection();

    private MySQLConnection(){}


    public static MySQLConnection getInstance() {
        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return connection;
    }

}
