package client;

import products.Locator;
import java.util.List;
import java.util.Optional;

public class LocatorRepository implements IRepository<Locator> {

    List<Locator> locatorList;

    @Override
    public Optional<Locator> get(Locator locatorToFind) {
        return locatorList.stream().filter(locatorToFind::equals).findAny();
    }

    @Override
    public List<Locator> add(Locator locatorToAdd) {
        locatorList.add(locatorToAdd);
        return locatorList;
    }

    public int getAmount(){
        return locatorList.size();
    }
}
