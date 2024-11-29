
public class Main {
  
  public static void main(String[] args) {
      try {
          int a = 0, b = 300;
          int resultado = b / a;
      } catch(ArithmeticException e) {
          throw new IllegalArgumentException("No se puede dividir por cero");
      } finally {
          System.out.println("Programa finalizado");
      }
  }
}
