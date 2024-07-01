package dados;

import dados.Cliente;

import java.util.ArrayList;

public class Lists {
    private ArrayList<Cliente> clients;
    private ArrayList<Robo> robots;

    public Lists() {
        this.clients = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    public void addClient(Cliente client) {
        clients.add(client);
    }

    public void addClient(ArrayList<Cliente> clients) {
        for (Cliente client : clients) {
            addClient(client);
        }
    }

    public void addClient(Cliente client1, Cliente client2, Cliente client3) {
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
    }

    public void addRobot(Robo robot) {
        robots.add(robot);
    }

    public void addRobot(ArrayList<Robo> robots) {
        for (Robo robot : robots) {
            addRobot(robot);
        }
    }

    public void addRobot(Robo robot1, Robo robot2, Robo robot3) {
        robots.add(robot1);
        robots.add(robot2);
        robots.add(robot3);
    }

    public ArrayList<Cliente> getClients() {
        return clients;
    }

    public ArrayList<Robo> getRobots() {
        return robots;
    }

    public Cliente getByName(String name) {
        for (Cliente client : clients) {
            if (client.getNome().equals(name)) {
                return client;
            }
        }
        return null;
    }
}
