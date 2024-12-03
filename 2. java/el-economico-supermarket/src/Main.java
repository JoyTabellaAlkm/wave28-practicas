import Entities.Client;
import Entities.Item;
import Entities.Receipt;
import Repositories.ClientRepository;
import Repositories.ItemRepository;
import Repositories.ReceiptRepository;
import Services.UnitOfWorkService;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        // ##############
        // ### PART 2 ###
        // ##############

        UnitOfWorkService unitOfWork = new UnitOfWorkService();

        Client client1 = new Client(13123123, "Horacio", "Quiroga");
        Client client2 = new Client(54354321, "Rene", "Descartes");
        Client client3 = new Client(33444333, "Nolan", "Bushnell");

        unitOfWork.getClientRepository().create(client1);
        unitOfWork.getClientRepository().create(client2);
        unitOfWork.getClientRepository().create(client3);

        Client newClient = new Client(
                11222333,
                "Cosme",
                "Fulanito"
        );

        Item item1 =new Item(1,"Purple",3,20);
        Item item2 = new Item(2, "Yellow", 6, 10);
        Item item3 = new Item(3, "Blue",25, 1);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);


        Receipt receipt1 = new Receipt(
                1,
                newClient,
                items
        );

        items.remove(2);

        Receipt receipt2 = new Receipt(
                2,
                client1,
                items
        );

        //Validate if the receipt's client is in the collection (repo)
        unitOfWork.customReceiptCreate(receipt1);
        unitOfWork.customReceiptCreate(receipt2);

        unitOfWork.getItemRepository().readAll().stream()
                .forEach(System.out::println);

        System.out.println("=========");

        unitOfWork.getReceiptRepository().readAll().stream()
                .forEach(System.out::println);

        System.out.println("=========");

        unitOfWork.getClientRepository().readAll().stream()
                .forEach(System.out::println);
        
    }



    public static void part1(){

        Client client1 = new Client(13123123, "Horacio", "Quiroga");
        Client client2 = new Client(54354321, "Rene", "Descartes");
        Client client3 = new Client(33444333, "Nolan", "Bushnell");

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

        System.out.println("=============");
        clients.stream()
                .forEach(System.out::println);

        clients.remove(1);

        System.out.println("=============");
        clients.stream()
                .forEach(System.out::println);

        searchForClient(clients);
    }

    public static void searchForClient(List<Client> clients){
        System.out.println("Ingrese DNI a buscar: ");

        try{
            Scanner toScan = new Scanner(System.in);
            int i = toScan.nextInt();
            if(clients.stream().anyMatch( x -> x.getDocumentId() == i)){
                clients.stream()
                        .filter( x -> x.getDocumentId() == i)
                        .forEach(System.out::println);
            }else {
                throw new Exception();
            }
        } catch (InputMismatchException e){
            System.out.println("Por favor ingrese un dato valido");
        }
        catch (Exception e){
            System.out.println("No se encontro ese cliente");
        }

    }
}
