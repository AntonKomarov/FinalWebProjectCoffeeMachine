package service;

import entity.CoffeeMachine;
import service.exception.ServiceException;

public interface CoffeeMachineService {
    boolean addCoffeeMachine(CoffeeMachine coffeeMachine) throws ServiceException;
    boolean deleteCoffeeMachineByModel(CoffeeMachine coffeeMachine) throws ServiceException;
}
