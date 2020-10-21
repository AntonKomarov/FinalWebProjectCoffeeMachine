package dao.provider;

import dao.CoffeeDAO;
import dao.CoffeeMachineDAO;
import dao.UserDAO;
import dao.impl.CoffeeDAOImpl;
import dao.impl.CoffeeMachineDAOImpl;
import dao.impl.UserDAOImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new UserDAOImpl();
    private final CoffeeDAO coffeeDAO = new CoffeeDAOImpl();
    private final CoffeeMachineDAO coffeeMachineDAO = new CoffeeMachineDAOImpl();
    //добавить кофе

    public DAOProvider(){}

    public static DAOProvider getInstance(){
        return instance;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }

    public CoffeeDAO getCoffeeDAO(){
        return coffeeDAO;
    }

    public CoffeeMachineDAO getCoffeeMachineDAO(){
        return coffeeMachineDAO;
    }
}
