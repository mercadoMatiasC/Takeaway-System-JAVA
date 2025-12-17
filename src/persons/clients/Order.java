package persons.clients;

import persons.clients.Client;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;

    private static int localID = 1;
    private int id;

    private Client client;
    private Cart cart;
    private LocalDate date;

    public Order() {
        this.id = localID;
        localID += 1;
        this.date = LocalDate.now();
    }

    public Order(Client client, Cart cart) {
        this.id = localID;
        localID += 1;

        this.client = client;
        this.cart = cart;
        this.date = LocalDate.now();
    }

    //region GET/SET

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //endregion

    @Override
    public String toString() {
        return  "ORDER: #" + this.id +
                "\nClient ID: #" + this.client.getId() +
                "\nDate: " + this.date +
                this.cart +
                "\n---------------------------------------------------------------";
    }
}
