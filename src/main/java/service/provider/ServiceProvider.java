package service.provider;

import service.UserService;
import service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final UserService userService = new UserServiceImpl();

    public ServiceProvider(){}

    public static ServiceProvider getInstance(){
        return instance;
    }

    public UserService getUserService(){
        return userService;
    }
}
