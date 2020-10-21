package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoffeeMachine {

      private int idUser;
      private String model;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeMachine that = (CoffeeMachine) o;
        return idUser == that.idUser &&
                model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, model);
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "idUser=" + idUser +
                ", model='" + model + '\'' +
                '}';
    }
}
