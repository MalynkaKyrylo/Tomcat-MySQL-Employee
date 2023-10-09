package org.example.app.database;

import org.example.app.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Класс-конектор до БД.
public class DBConn {

    private static final Logger LOGGER =
            Logger.getLogger(DBConn.class.getName());

    public static Connection connect() throws SQLException {

        Connection conn = null;

        try {
            Class.forName(Constants.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }

        try {
            conn = DriverManager.getConnection(Constants.DB_URL + Constants.DB_NAME,
                    Constants.DB_USER, Constants.DB_PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return conn;
    }
}
