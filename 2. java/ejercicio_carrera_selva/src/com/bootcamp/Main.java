package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Insciption> insciptionList = new ArrayList<>();

        //        Categories
        Category chico = new Category(1, "Circuito chico", "2 km por selva y arroyos.");
        Category medio = new Category(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Category avanzado = new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        //        Competitores
        Competitor competitor1 = new Competitor(1,123,"name1","last1",15,"12345678","12345678", "A");
        Competitor competitor2 = new Competitor(2,1234,"name2","last2",25,"12345678","12345678", "A");
        Competitor competitor3 = new Competitor(3,1235,"name3","last3",15,"12345678","12345678", "A");
        Competitor competitor4 = new Competitor(4,1236,"name4","last4",25,"12345678","12345678", "A");
        Competitor competitor5 = new Competitor(5,1237,"name5","last5",15,"12345678","12345678", "A");
        Competitor competitor6 = new Competitor(6,1238,"name6","last6",25,"12345678","12345678", "A");


        insciptionList.add(new Insciption(1,chico,competitor1));
        insciptionList.add(new Insciption(2,chico,competitor2));
        insciptionList.add(new Insciption(3,medio,competitor3));
        insciptionList.add(new Insciption(4,medio,competitor4));
        insciptionList.add(new Insciption(5,avanzado,competitor6));
        insciptionList.add(new Insciption(6,avanzado,competitor5));

        System.out.println("\n************************INSCRIPTSOS************************");
        for (Insciption insciption:
             insciptionList) {
            System.out.println(insciption.toString());
        }

        insciptionList.remove(5);

        System.out.println("\n************************INSCRIPTSOS - 1************************");
        for (Insciption insciption:
             insciptionList) {
            System.out.println(insciption.toString());
        }

        System.out.println("\n************************TOTALES************************");
        double chicoTotal = 0,medioTotal = 0, avanzadoTotal =0, total = 0;
        for (Insciption insciption:
             insciptionList) {
            double price = insciption.getPrice();
            switch (insciption.getCategoryName()) {
                case "Circuito chico":
                    chicoTotal += price;
                    total += price;
                    break;
                case "Circuito medio":
                    medioTotal += price;
                    total += price;
                    break;
                case "Circuito avanzado":
                    avanzadoTotal += price;
                    total += price;
                    break;
                default:

            }
        }
            System.out.println("Total recaudado en el Circuito chico: " + chicoTotal);
            System.out.println("Total recaudado en el Circuito medio: " + medioTotal);
            System.out.println("Total recaudado en el Circuito avanzado: " + avanzadoTotal);
            System.out.println("Total recaudado en todos los circuitos: " + total);
    }

}

