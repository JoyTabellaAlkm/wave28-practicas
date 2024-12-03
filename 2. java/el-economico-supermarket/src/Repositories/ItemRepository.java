package Repositories;

import Entities.Item;
import Repositories.Interfaces.IItemRepository;

import java.util.List;
import java.util.Optional;

public class ItemRepository extends Repository<Item> implements IItemRepository {

    public ItemRepository(List<Item> data) {
        super(data);
    }

    @Override
    public Optional<List<Item>> readAll() {
        Optional<List<Item>> toReturn = Optional.ofNullable(_data);
        return toReturn;
    }

    @Override
    public Optional<Item> readById(int id) {
        Optional<Item> toReturn = _data.stream()
                .filter(x -> x.getCodeId() == id)
                .findFirst();
        return toReturn;
    }

    @Override
    public void create(Item entity) {
        _data.add(entity);
    }

    @Override
    public void update(Item entity, int id) {
        int indexToModify = 0;
        for (Item item: _data) {
            if(item.getCodeId() == id){
                _data.set(indexToModify, item);
            }
            indexToModify++;
        }
    }

    @Override
    public void delete(int id) {
        int indexToModify = 0;
        for (Item item: _data) {
            if(item.getCodeId() == id){
                _data.remove(indexToModify);
            }
            indexToModify++;
        }
    }


}
