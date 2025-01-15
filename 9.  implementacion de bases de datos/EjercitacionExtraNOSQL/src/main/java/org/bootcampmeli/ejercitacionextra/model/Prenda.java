package org.bootcampmeli.ejercitacionextra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.lang.reflect.Type;
import java.util.Objects;

@Document(indexName = "prenda")

@AllArgsConstructor
@NoArgsConstructor
public class Prenda {

        @Id
        private String codigo;

        @Field(type = FieldType.Text)
        private String nombre;

        private String tipo;

        private String marca;

        private String talle;

        private String color;


        @Field(type = FieldType.Integer, name = "cantidad_ventas")
        private Integer cantidadVentas;

        @Field(type = FieldType.Double)
        private Double precio;

        public String getCodigo() {
                return codigo;
        }

        public void setCodigo(String codigo) {
                this.codigo = codigo;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public String getMarca() {
                return marca;
        }

        public void setMarca(String marca) {
                this.marca = marca;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public Integer getCantidadVentas() {
                return cantidadVentas;
        }

        public void setCantidadVentas(Integer cantidadVentas) {
                this.cantidadVentas = cantidadVentas;
        }

        public Double getPrecio() {
                return precio;
        }

        public void setPrecio(Double precio) {
                this.precio = precio;
        }

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                Prenda prenda = (Prenda) o;
                return Objects.equals(codigo, prenda.codigo) && Objects.equals(nombre, prenda.nombre) && Objects.equals(tipo, prenda.tipo) && Objects.equals(marca, prenda.marca) && Objects.equals(color, prenda.color) && Objects.equals(cantidadVentas, prenda.cantidadVentas) && Objects.equals(precio, prenda.precio);
        }

        @Override
        public int hashCode() {
                return Objects.hash(codigo, nombre, tipo, marca, color, cantidadVentas, precio);
        }

        public String getTalle() {
                return talle;
        }

        public void setTalle(String talle) {
                this.talle = talle;
        }
}
