package service;

import dao.exception.DAOException;
import entity.Coffee;
import service.exception.ServiceException;

import java.util.List;

public interface CoffeeService {
     boolean addCoffee(Coffee coffee) throws ServiceException;
     boolean deleteCoffee(Coffee coffee) throws ServiceException;
}
