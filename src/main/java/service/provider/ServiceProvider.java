package service.provider;

import entity.CoffeeMachine;
import service.CoffeeMachineService;
import service.CoffeeService;
import service.OrderService;
import service.UserService;
import service.impl.CoffeeMachineServiceImpl;
import service.impl.CoffeeServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final UserService userService = new UserServiceImpl();
    private final CoffeeService coffeeService = new CoffeeServiceImpl();
    private final CoffeeMachineService coffeeMachineService = new CoffeeMachineServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    public ServiceProvider(){}

    public static ServiceProvider getInstance(){
        return instance;
    }

    public UserService getUserService(){
        return userService;
    }

    public CoffeeService getCoffeeService(){
        return coffeeService;
    }

    public CoffeeMachineService getCoffeeMachineService() {
        return coffeeMachineService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
