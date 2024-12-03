package Entities;

public class Client {

    // ATTRIBUTES
    private int documentId;
    private String name;
    private String surname;

    // CONSTRUCTORS
    public Client(int documentId, String name, String surname) {
        this.documentId = documentId;
        this.name = name;
        this.surname = surname;
    }

    public Client(){

    }

    // TO STRING


    @Override
    public String toString() {
        return "[Client] " +
                "\n documentId: " + documentId +
                "\n name: " + name  +
                "\n surname: " + surname +
                "\n \n";
    }

    // GETS & SETS
    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
