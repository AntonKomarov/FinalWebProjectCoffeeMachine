package dao;

import dao.exception.DAOException;
import entity.CoffeeMachine;

public interface CoffeeMachineDAO {
    boolean addCoffeeMachine(CoffeeMachine coffeeMachine) throws DAOException;
    boolean deleteCoffeeMachineByModel(CoffeeMachine coffeeMachine) throws DAOException;
}
