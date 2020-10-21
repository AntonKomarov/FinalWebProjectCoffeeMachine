package dao;

import dao.exception.DAOException;
import entity.Authorization;
import entity.Registration;
import entity.User;

public interface UserDAO {
    User authorization(Authorization authorization) throws DAOException;
    boolean registration(Registration registration) throws DAOException;
}
