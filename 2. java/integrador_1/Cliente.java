package integrador_1;

import java.util.*;

public class Cliente{
 private int id;
 private String nombre;
 private String apellido; 
 double descuento = 0;


 Cliente(int id, String nombre, String apellido){
  this.id = id;
  this.nombre = nombre;
  this.apellido = apellido;
 }

 void setId(int id){
  this.id = id;
 }
 void setNombre(String nombre){
  this.nombre = nombre;
 }
 void setApellido(String apellido){
  this.apellido = apellido;
 }
 void setDescuento(double descuento){
  this.descuento = descuento;
 }

 int getId(){
  return id;
 }
 String getNombre(){
  return nombre;
 }
 String getApellido(){
  return apellido;
 }
 double getDescuento(){
  return descuento;
 }

}
