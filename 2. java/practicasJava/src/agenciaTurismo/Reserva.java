package agenciaTurismo;

public abstract class  Reserva {
    private int id ;
    private String descripcion;
    private int clases;
    private Double precio;

    public Reserva(int id, String descripcion,Double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getClases() {
        return clases;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setClases(int clases) {
        this.clases = clases;
    }

    public  abstract void  crearReserva();




}
