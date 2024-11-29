# Ejercicio practico P2 

```java
public class Main {
    public static void main(String[] args) {
        //Código que arroja excepción
        int[] numeros = new int[5];
        
        try {
            numeros[5] = 10;    
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            //Mensaje final
            String mensajeFinal = "Este es el último mensaje";
            System.out.println(mensajeFinal);
        }   
    }   
}
```