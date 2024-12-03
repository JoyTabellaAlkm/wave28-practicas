package Services;

import Entities.Item;
import Entities.Receipt;
import Repositories.ClientRepository;
import Repositories.ItemRepository;
import Repositories.ReceiptRepository;

import java.util.ArrayList;

public class UnitOfWorkService implements IUnitOfWork{
    private ClientRepository _clientRepository = new ClientRepository(new ArrayList<>());
    private ReceiptRepository _receiptRepository = new ReceiptRepository(new ArrayList<>());
    private ItemRepository _itemRepository = new ItemRepository(new ArrayList<>());

    @Override
    public ClientRepository getClientRepository() {
        return _clientRepository;
    }

    @Override
    public ItemRepository getItemRepository() {
        return _itemRepository;
    }

    @Override
    public ReceiptRepository getReceiptRepository() {
        return _receiptRepository;
    }

    public boolean validateReceipt(Receipt receipt){
        if(getClientRepository().readById(receipt.getClient().getDocumentId()).isPresent()){
            return true;
        } else{
            return false;
        }
    }

    public void customReceiptCreate(Receipt receipt){
        if (validateReceipt(receipt)) {
            for (Item item: receipt.getItems()){
                getItemRepository().create(item);
            }
            getReceiptRepository().create(receipt);
        }else{
            getClientRepository().create(receipt.getClient());
        }
    }
}
