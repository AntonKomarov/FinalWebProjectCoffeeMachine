package dao;

import dao.exception.DAOException;
import entity.Coffee;

import java.util.List;

public interface CoffeeDAO {
       boolean addCoffee(Coffee coffee) throws DAOException;
       boolean deleteCoffee(Coffee coffee) throws DAOException;
}
