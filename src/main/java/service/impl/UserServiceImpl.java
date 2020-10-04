package service.impl;

import dao.UserDAO;
import dao.exception.DaoException;
import dao.provider.DAOProvider;
import entity.Authorization;
import entity.User;
import entity.Registration;
import service.validator.GredentionalValidator;
import service.exception.ServiceException;
import service.UserService;


public class UserServiceImpl implements UserService {
    // внутри сервиса можно проводить техническую валидацию
    @Override
    public User authorization(Authorization authorizationData) throws ServiceException {

        if(!GredentionalValidator.isCorrect(authorizationData)){
            throw new ServiceException("login or password isn't correct");
        }

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();
        User user = null;

        try {
            user = userDAO.authorization(authorizationData);
        } catch (DaoException exception){
            throw new ServiceException(exception);
        }

        return user;
    }

    @Override
    public boolean registration(Registration registrationData) throws ServiceException {
        boolean isRegistration = false;

//        if (!GredentionalValidator.isCorrect(registration){
//            throw new ServiceException("information isn't correct");
//        }

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try {
            isRegistration = userDAO.registration(registrationData);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
        return isRegistration;
    }
}
