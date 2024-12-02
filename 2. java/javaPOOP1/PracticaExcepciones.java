class PracticaExcepciones{
    int a = 0;
    int b = 300;

    public static void main(String[] args){
        PracticaExcepciones practica = new PracticaExcepciones();

        practica.calcularConcienteReq1();
        //practica.calcularConcienteReq2();

    }

    //Req 1
    public  void calcularConcienteReq1(){
        try{
            double conciente = b/a;
            System.out.println(conciente);
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }

    //Req 2
    public  void calcularConcienteReq2(){
        PracticaExcepciones practica = new PracticaExcepciones();
        try{
            double conciente = b/a;
            System.out.println(conciente);
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
