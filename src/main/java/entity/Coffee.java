package entity;

import java.io.Serializable;
import java.util.Objects;

public class Coffee implements Serializable {

    private String name;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return cost == coffee.cost &&
                name.equals(coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
