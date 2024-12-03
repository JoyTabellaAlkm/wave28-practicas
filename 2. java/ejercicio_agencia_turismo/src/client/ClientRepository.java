package client;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class ClientRepository implements IRepository<Client> {

    private List<Client> clientList;


    public Optional<Client> getBy(String clientName) {
        return clientList.stream().filter(clientToFind -> Objects.equals(clientToFind.name, clientName)).findAny();
    }

    @Override
    public Optional<Client> get(Client clientToFind) {
        return clientList.stream().filter(clientToFind::equals).findAny();
    }

    @Override
    public List<Client> add(Client client) {
        clientList.add(client);
        return clientList;
    }
}