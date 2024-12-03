package Services;

import Repositories.*;

public interface IUnitOfWork {
    public ClientRepository getClientRepository();
    public ItemRepository getItemRepository();
    public ReceiptRepository getReceiptRepository();
}
