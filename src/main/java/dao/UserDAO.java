package dao;

import dao.exception.DaoException;
import entity.Authorization;
import entity.Registration;
import entity.User;

public interface UserDAO {
    User authorization(Authorization authorization) throws DaoException;
    boolean registration(Registration registration) throws DaoException;
}
