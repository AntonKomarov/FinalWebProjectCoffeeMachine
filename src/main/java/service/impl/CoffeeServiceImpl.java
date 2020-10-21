package service.impl;

import dao.CoffeeDAO;
import dao.exception.DAOException;
import dao.provider.DAOProvider;
import entity.Coffee;
import service.CoffeeService;
import service.exception.ServiceException;

import java.util.List;

public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public boolean addCoffee(Coffee coffee) throws ServiceException{
        boolean isAdded = false;

        DAOProvider daoProvider = DAOProvider.getInstance();
        CoffeeDAO coffeeDAO = daoProvider.getCoffeeDAO();

        try {
            isAdded = coffeeDAO.addCoffee(coffee);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isAdded;
    }

    @Override
    public boolean deleteCoffee(Coffee coffee) throws ServiceException {
        boolean isDelete = false;

        DAOProvider daoProvider = DAOProvider.getInstance();
        CoffeeDAO coffeeDAO = daoProvider.getCoffeeDAO();

        try{
            isDelete = coffeeDAO.deleteCoffee(coffee);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return isDelete;
    }


}
