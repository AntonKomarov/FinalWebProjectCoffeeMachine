package entity;

import java.io.Serializable;
import java.util.Objects;

public class Registration implements Serializable {
    private static final long serialVersionUID = -2323534513452412334L;

    private int id;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String surname;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration registration = (Registration) o;
        return id == registration.id &&
                login.equals(registration.login) &&
                password.equals(registration.password) &&
                email.equals(registration.email) &&
                phone.equals(registration.phone) &&
                name.equals(registration.name) &&
                surname.equals(registration.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, phone, name, surname);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
