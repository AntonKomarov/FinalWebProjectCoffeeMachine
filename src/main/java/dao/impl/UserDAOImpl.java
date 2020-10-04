package dao.impl;

import dao.ConnectionDB;
import dao.exception.DaoException;
import dao.UserDAO;
import entity.Authorization;
import entity.Registration;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static final String SELECT_USER_BY_LOGIN = "SELECT login FROM users WHERE login=? and password=?";
    private static final String INSERT_USER = "INSERT INTO users (login, password, phone_number, email) VALUES (?,?,?,?)";

    @Override
    public User authorization(Authorization authorization) throws DaoException {

        ConnectionDB connectionDB = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connectionDB = ConnectionDB.getInstance();
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);

            preparedStatement.setString(1, authorization.getLogin());
            preparedStatement.setString(2, authorization.getPassword());

            resultSet = preparedStatement.executeQuery();

            // может стоит через authorization
            if (resultSet.next()) {
                String login = resultSet.getString(1);
                user = new User();
                user.setLogin(login);
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        } catch (ClassNotFoundException e) {
            throw new DaoException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException exception) {
                    throw new DaoException(exception);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    throw new DaoException(exception);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    throw new DaoException(exception);
                }
            }
        }
        return user;
    }

    @Override
    public boolean registration(Registration registration) throws DaoException {

        ConnectionDB connectionDB = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isRegistration = false;

        try {
            connectionDB = ConnectionDB.getInstance();
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_USER);

            preparedStatement.setString(1, registration.getLogin());
            preparedStatement.setString(2, registration.getPassword());
            preparedStatement.setString(3, registration.getPhone());
            preparedStatement.setString(4, registration.getEmail());

            if (preparedStatement.executeUpdate() == 1) {
                isRegistration = true;
            }

        } catch (SQLException exception) {
            throw new DaoException(exception);
        } catch (ClassNotFoundException e) {
            throw new DaoException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    throw new DaoException(exception);
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new DaoException(e);
                    }
                }
            }
        }
        return isRegistration;
    }
}
