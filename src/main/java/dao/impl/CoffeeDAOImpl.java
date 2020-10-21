package dao.impl;

import dao.CoffeeDAO;
import dao.connection.ConnectionDB;
import dao.exception.DAOException;
import entity.Coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffeeDAOImpl implements CoffeeDAO {

    private static final String INSERT_COFFEE = "INSERT INTO beverages (name,cost,coffee_machines_idcoffee_machine) VALUES (?,?,?)";

    @Override
    public boolean addCoffee(Coffee coffee) throws DAOException {

        ConnectionDB connectionDB = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isAdded = false;

        try {
            connectionDB = ConnectionDB.getInstance();
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_COFFEE);

            preparedStatement.setString(1, coffee.getName());
            preparedStatement.setString(2, coffee.getCost());
            preparedStatement.setInt(3, coffee.getCoffee_machines_idcoffee_machine());

            if (preparedStatement.executeUpdate() == 1){
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
        }

        return isAdded;
    }

    @Override
    public boolean deleteCoffee(Coffee coffee) throws DAOException {
        ConnectionDB connectionDB = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isDeleted = false;

        try {
            connectionDB = ConnectionDB.getInstance();
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM beverages WHERE name='" + coffee.getName() + "';");

            if (preparedStatement.executeUpdate() == 1){
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
