package service;

import entity.Authorization;
import entity.Registration;
import entity.User;
import service.exception.ServiceException;

public interface UserService {
    User authorization(Authorization authorization) throws ServiceException;
    boolean registration(Registration registration) throws ServiceException;
}
