package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
public class Client {

    private int loyalty;
    private final Individual individual;

    private static final List<Client> clients = new ArrayList<>();

    public Client(@NotNull Individual individual, int loyalty) throws Exception {
        if (individual.isClient()) {
            throw new Exception("Provided person is already has a client");
        }
        this.individual = individual;
        this.loyalty = loyalty;
        individual.addClient(this);

        clients.add(this);
    }

    public static void removeClient(@NotNull Client client) {
        client.individual.setClient(null);
        clients.remove(client);
    }

    // Getters ad setters
    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public Individual getIndividual() {
        return individual;
    }

    @Override
    public String toString() {
        return "Client {" +
                individual.toString() +
                ", loyalty rating = '" + getLoyalty() + '\'' +
                '}';
    }
}
