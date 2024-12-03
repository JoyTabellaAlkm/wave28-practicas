package clases;

public class Cliente {
    private int id;
    private String name;
    private String lastName;

    public Cliente(int id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", Nombre: " + this.name + ", Apellido: " + this.lastName;
    }
}
