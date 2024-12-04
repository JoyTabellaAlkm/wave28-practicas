package Entities;

import Interfaces.ITransaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Client {
    private List<ITransaction> availableActions;

    // CONSTRUCTOR

    public Client(List<ITransaction> availableActions){
        this.availableActions = availableActions;
    }

    public Client() {

    }


    // GETS & SETS
    public List<ITransaction> getAvailableActions() {
        return availableActions;
    }

    public void setAvailableActions(List<ITransaction> availableActions) {
        this.availableActions = availableActions;
    }
}
