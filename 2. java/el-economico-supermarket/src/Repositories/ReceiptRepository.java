package Repositories;

import Entities.Receipt;
import Repositories.Interfaces.IReceiptRepository;

import java.util.List;
import java.util.Optional;

public class ReceiptRepository extends Repository<Receipt> implements IReceiptRepository {

    public ReceiptRepository(List<Receipt> data) {
        super(data);
    }

    @Override
    public Optional<List<Receipt>> readAll() {
        Optional<List<Receipt>> toReturn = Optional.ofNullable(_data);
        return toReturn;
    }

    @Override
    public Optional<Receipt> readById(int id) {
        Optional<Receipt> toReturn = _data.stream()
                .filter(x -> x.getReceiptId() == id)
                .findFirst();
        return toReturn;
    }

    @Override
    public void create(Receipt entity) {
        _data.add(entity);
    }

    @Override
    public void update(Receipt entity, int id) {
        int indexToModify = 0;
        for (Receipt receipt: _data) {
            if(receipt.getReceiptId() == id){
                _data.set(indexToModify, receipt);
            }
            indexToModify++;
        }
    }

    @Override
    public void delete(int id) {
        int indexToModify = 0;
        for (Receipt receipt: _data) {
            if(receipt.getReceiptId() == id){
                _data.remove(indexToModify);
            }
            indexToModify++;
        }
    }


}