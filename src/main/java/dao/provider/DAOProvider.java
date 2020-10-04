package dao.provider;

import dao.UserDAO;
import dao.impl.UserDAOImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new UserDAOImpl();
    //добавить кофе

    public DAOProvider(){}

    public static DAOProvider getInstance(){
        return instance;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }
}
