package Repositories;

import Entities.Client;
import Repositories.Interfaces.IClientRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ClientRepository extends Repository<Client> implements IClientRepository {

    public ClientRepository(List<Client> data) {
        super(data);
    }

    @Override
    public Optional<List<Client>> readAll() {
        Optional<List<Client>> toReturn = Optional.ofNullable(_data);
        return toReturn;
    }

    @Override
    public Optional<Client> readById(int id) {
        Optional<Client> toReturn = _data.stream()
                .filter(x -> x.getDocumentId() == id)
                .findFirst();
        return toReturn;
    }

    @Override
    public void create(Client entity) {
        _data.add(entity);
    }

    @Override
    public void update(Client entity, int id) {
        int indexToModify = 0;
        for (Client client: _data) {
            if(client.getDocumentId() == id){
                _data.set(indexToModify, client);
            }
            indexToModify++;
        }
    }

    @Override
    public void delete(int id) {
        int indexToModify = 0;
        for (Client client: _data) {
            if(client.getDocumentId() == id){
                _data.remove(indexToModify);
            }
            indexToModify++;
        }
    }


}
