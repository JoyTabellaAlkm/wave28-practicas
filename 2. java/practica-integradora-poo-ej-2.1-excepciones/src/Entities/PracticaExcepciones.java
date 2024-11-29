package Entities;

public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void calculaCociente(){
        try{
            System.out.println(b%a);
        } catch (Exception e){
            throw new IllegalArgumentException("You can't divide by zero");
        } finally {
            System.out.println("Program finalized");
        }
    }


}
