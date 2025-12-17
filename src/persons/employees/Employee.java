package persons.employees;

import persons.Person;
import persons.clients.Client;

import java.time.LocalDate;

public class Employee extends Person {

    private static int localID = 0;
    private int id;
    private typeEmployeeArea area;

    public Employee() {
        super.setActive(true);
        super.setRegisteredDate(LocalDate.now());
        newID();
    }

    public Employee(String name, String phone, String email, String address, typeEmployeeArea area) {
        super.setActive(true);
        super.setRegisteredDate(LocalDate.now());
        newID();

        super.setName(name);
        super.setPhone(phone);
        super.setEmail(email);
        super.setAddress(address);
        this.area = area;
    }

    //region GET/SET
    public typeEmployeeArea getArea() {
        return area;
    }

    public void setArea(typeEmployeeArea area) {
        this.area = area;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return super.getPhone() == employee.getPhone() &&
               super.getEmail() == employee.getEmail();
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int result = 1;

        result = prime + result * Integer.valueOf(super.getPhone());
        result = prime + result * Integer.valueOf(super.getEmail());
        return result;
    }

    @Override
    public void newID() {
        this.id = localID;
        localID += 1;
    }

    @Override
    public String toString() {
        return  "\nID: #" + id +
                "\nActive status: " + isActive() +
                "\nName: " + super.getName()  +
                "\nPhone: " + super.getPhone()  +
                "\nE-mail: " + super.getEmail() +
                "\nAddress: " + super.getAddress() +
                "\nArea: " + area +
                "\nRegistered date: " + super.getRegisteredDate();
    }
}
