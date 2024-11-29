import java.util.Scanner;

class Salario {
    public static void main(String[] args) {
        Scanner employer = new Scanner(System.in);
        System.out.println("""
        ************************************************************
        ********** WELCOME TO SALARY CALCULATOR  **********
        ************************************************************
        """);

        String dni;
        System.out.println("Ingresa el DNI: ");

        dni = employer.next();

        double salary ;
        System.out.println("Ingresa el salario: ");
        salary = employer.nextInt();

        double newSalary;

        if(salary <= 20000){
            newSalary = salary * 1.20;
        }else if(salary >= 20000 && salary <= 45000){
            newSalary = salary * 1.10;
        }else{
            newSalary = salary * 1.05;
        }
        System.out.println("El salario "+ " del " + "DNI " + dni + " es " +newSalary);
    }
}