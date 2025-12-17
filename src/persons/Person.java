package persons;

import persons.clients.Client;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;

    private boolean active;
    private String name;
    private String phone;
    private String email;
    private String address;
    private LocalDate registeredDate;

    //region GET/SET

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
    //endregion

    public abstract void newID();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        return this.getPhone().equals(client.getPhone()) &&
                this.getEmail().equals(client.getEmail());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 0;

        result = result + prime * Integer.valueOf(this.getPhone());
        result = result + prime * Integer.valueOf(this.getEmail());
        return result;
    }

}
