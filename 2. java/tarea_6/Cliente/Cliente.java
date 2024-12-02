package tarea_6.Cliente;

public class Cliente {
  String nombre;
  String dni;

  Cliente(String nombre, String dni){
    this.nombre = nombre;
    this.dni = dni;
  }

  void setNombre(String nombre){
    this.nombre = nombre;
  }
  
  void setDni(String dni){
    this.dni = dni;
  }

  String getNombre(){ return nombre; }

  String getDni(){ return dni; }
}
