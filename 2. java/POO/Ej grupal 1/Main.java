import com.company.model.Persona;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona("Guille", 25, "33333333", 75.5, 1.80);
        Persona p2 = new Persona("Fer", 25, "33343333");
//        Persona p3 = new Persona("Fer", 25 ); No es posible porque no hay un constructor definido con estos parametros
        Persona p3 = new Persona();

        System.out.println(p1);

        int imc = p1.calcularImc();
        switch (imc){
            case -1:
                System.out.println("Estas bajo peso");
                break;
            case 0:
                System.out.println("Estas en un peso saludable");
                break;
            case 1:
                System.out.println("Estas en sobre peso");
                break;
        }


        if(p1.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("No es mayor de edad");
        }
    }
}