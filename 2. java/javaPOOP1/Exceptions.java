public class Exceptions{
     
    public  static void main(String[] args) {
        String mensajeFinal = "Este es el último mensaje";
        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println(mensajeFinal);
        }
    }
}
