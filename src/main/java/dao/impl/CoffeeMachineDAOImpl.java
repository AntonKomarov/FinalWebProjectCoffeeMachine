package dao.impl;

import dao.CoffeeMachineDAO;
import dao.connection.ConnectionDB;
import dao.exception.DAOException;
import entity.CoffeeMachine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffeeMachineDAOImpl implements CoffeeMachineDAO {

    private static final String INSERT_COFFEE_MACHINE = "INSERT INTO coffee_machines(users_idUser, model) VALUES (?,?)";

    @Override
    public boolean addCoffeeMachine(CoffeeMachine coffeeMachine) throws DAOException {

        ConnectionDB connectionDB = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isAdded = false;

        try {
            connectionDB = ConnectionDB.getInstance();
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_COFFEE_MACHINE);

            preparedStatement.setInt(1, coffeeMachine.getIdUser());
            preparedStatement.setString(2, coffeeMachine.getModel());

            if (preparedStatement.executeUpdate() == 1) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    throw new DAOException(exception);
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new DAOException(e);
                    }
                }
            }

            return isAdded;
        }
    }

    @Override
    public boolean deleteCoffeeMachineByModel(CoffeeMachine coffeeMachine) throws DAOException {
        ConnectionDB connectionDB = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isDeleted = false;

        try {
            connectionDB = ConnectionDB.getInstance();
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM coffee_machines WHERE model='" + coffeeMachine.getModel() + "';");

            if (preparedStatement.executeUpdate() == 1) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    throw new DAOException(exception);
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new DAOException(e);
                    }
                }
            }
        }
        return isDeleted;
    }
}
