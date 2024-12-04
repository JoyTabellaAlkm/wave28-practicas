/*Inicia creando una clase Vehículo con los atributos modelo, marca y costo. Luego crea una clase garaje con los atributos
id o identificador único y una lista de vehículos. Crea además los constructores de las clases y los métodos Setter y Getter.*/


import java.util.List;

public class Garage {
    int id;
    List<Vehiculo> vehiculoList;

    public Garage(int id, List<Vehiculo> vehiculoList) {
        this.id = id;
        this.vehiculoList = vehiculoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

}
