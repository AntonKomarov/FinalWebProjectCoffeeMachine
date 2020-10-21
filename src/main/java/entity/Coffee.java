package entity;

import java.io.Serializable;
import java.util.Objects;

public class Coffee implements Serializable {

    private String name;
    private String cost;
    private int coffee_machines_idcoffee_machine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


    public int getCoffee_machines_idcoffee_machine() {
        return coffee_machines_idcoffee_machine;
    }

    public void setCoffee_machines_idcoffee_machine(int coffee_machines_idcoffee_machine) {
        this.coffee_machines_idcoffee_machine = coffee_machines_idcoffee_machine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return coffee_machines_idcoffee_machine == coffee.coffee_machines_idcoffee_machine &&
                name.equals(coffee.name) &&
                cost.equals(coffee.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, coffee_machines_idcoffee_machine);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", coffee_machines_idcoffee_machine=" + coffee_machines_idcoffee_machine +
                '}';
    }
}
