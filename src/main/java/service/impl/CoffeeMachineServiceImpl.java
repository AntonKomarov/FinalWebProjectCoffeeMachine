package service.impl;

import dao.CoffeeMachineDAO;
import dao.exception.DAOException;
import dao.provider.DAOProvider;
import entity.CoffeeMachine;
import service.CoffeeMachineService;
import service.exception.ServiceException;

public class CoffeeMachineServiceImpl implements CoffeeMachineService {
    @Override
    public boolean addCoffeeMachine(CoffeeMachine coffeeMachine) throws ServiceException {
        boolean isAdded = false;

        DAOProvider daoProvider = DAOProvider.getInstance();
        CoffeeMachineDAO coffeeMachineDAO = daoProvider.getCoffeeMachineDAO();

        try{
            isAdded = coffeeMachineDAO.addCoffeeMachine(coffeeMachine);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isAdded;
    }
}
