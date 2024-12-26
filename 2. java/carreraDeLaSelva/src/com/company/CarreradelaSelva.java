package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreradelaSelva {

    public static void main(String[] args) {

        //Definicion de circuitos
        Map<Integer, String[]> circuitos= new HashMap<>();
        String[] cirChico= {"1", "Circuito chico","2km","Selva y arroyos", "0"};
        String[] cirMedio= {"2", "Circuito medio","5km","Selva, arroyos y barro", "0"};
        String[] cirAvanz= {"3", "Circuito avanzado","10km","Selva, arroyos, baro y escalada en piedra", "0"};

        circuitos.put(Integer.parseInt(cirChico[0]), cirChico);
        circuitos.put(Integer.parseInt(cirMedio[0]), cirMedio);
        circuitos.put(Integer.parseInt(cirAvanz[0]), cirAvanz);

        //Tabla de participantes
        Map<Integer, String[]> participantes= new HashMap<>();

        String[] participante1= {"","3214","Juan","Sosa","23", "celular1","nroEmergencia","A+"};
        String[] participante2= {"","4322","Juan","Perez","15", "celular2","nroEmergencia","A+"};
        String[] participante3= {"","5433","Juan","Fernandez","28", "celular3","nroEmergencia","A+"};
        String[] participante4= {"","6543","Juan","Gomez","16", "celular4","nroEmergencia","A+"};

        participantes.put(Integer.parseInt(participante1[1]), participante1);
        participantes.put(Integer.parseInt(participante2[1]), participante2);
        participantes.put(Integer.parseInt(participante3[1]), participante3);
        participantes.put(Integer.parseInt(participante4[1]), participante4);


        //Tabla de costos
        Map<Integer, Integer[]> costos=new HashMap<>();

        Integer[] costoChica= {1300,1500};
        Integer[] costoMedio= {2000,2300};
        Integer[] costoAvanzada= {0,2800};

        costos.put(1, costoChica);
        costos.put(2, costoMedio);
        costos.put(3, costoAvanzada);

        //Inscripciones
        Map<Integer,String[]> inscripciones=new HashMap<>();

        int secuenciaInscripcion=1;

        secuenciaInscripcion=inscribir(secuenciaInscripcion, inscripciones, costos, participantes.get(3214), circuitos.get(1));
        secuenciaInscripcion=inscribir(secuenciaInscripcion, inscripciones, costos, participantes.get(4322), circuitos.get(2));
        secuenciaInscripcion=inscribir(secuenciaInscripcion, inscripciones, costos, participantes.get(5433), circuitos.get(3));
        secuenciaInscripcion=inscribir(secuenciaInscripcion, inscripciones, costos, participantes.get(6543), circuitos.get(3));
        secuenciaInscripcion=inscribir(secuenciaInscripcion, inscripciones, costos, participantes.get(5433), circuitos.get(2));//Ya esta inscripto
        secuenciaInscripcion=inscribir(secuenciaInscripcion, inscripciones, costos, participantes.get(6543), circuitos.get(1));//Se inscribe pq no le dio la edad para el circuito avanzado

        //Imprimo los participantes por categor�a
        for(Integer circuito : circuitos.keySet()) {
            imprimirPorCategoria(inscripciones, circuitos, participantes, circuito);
        }

        //Imprimo total recaudado por circuito
        sumarRecaudadoPorCategoria(circuitos);

        //Imprimo total recaudado en la carrera
        int total = sumarTotalRecaudadoCarrera(circuitos);
        System.out.println("Total recaudado en la carrera: $" + total);

        //Desinscribo a uno
        desinscribir(inscripciones, circuitos, participantes.get(3214));

        //Imprimo participantes del circuito
        imprimirPorCategoria(inscripciones, circuitos, participantes, 1);


        //Imprimo total recaudado por circuito
        sumarRecaudadoPorCategoria(circuitos);

        //Imprimo total recaudado en la carrera
        total = sumarTotalRecaudadoCarrera(circuitos);
        System.out.println("Total recaudado en la carrera: $" + total);

    }

    private static int inscribir(int secuenciaInscripcion, Map<Integer, String[]> inscripciones, Map<Integer, Integer[]> costos,
                                 String[] participante, String[] circuito) {

        //Chequeo que no est� inscripto el participante
        if(!inscripciones.containsKey(Integer.parseInt(participante[1]))) {

            //Sete Nro de inscripcion, Nro Circuito, Nro DNI Participante
            String[] inscripcion= {String.valueOf(secuenciaInscripcion), circuito[0], participante[1],""};

            //Calculo costo de la inscripcion
            int categoriaEdad=Integer.parseInt(participante[4])<18?0:1;

            inscripcion[3]=String.valueOf(costos.get(Integer.parseInt(circuito[0]))[categoriaEdad]);

            //Si se puede inscribir, seteo nro de inscripcion al participante, confirmo la inscripcion y sumo la recaudaci�n al circuito
            if(Integer.parseInt(inscripcion[3])!=0) {
                participante[0]=inscripcion[0];
                inscripciones.put(Integer.parseInt(participante[1]), inscripcion);
                circuito[4]=String.valueOf(Integer.parseInt(circuito[4]) + Integer.parseInt(inscripcion[3]));
            }
        }
        return ++secuenciaInscripcion;
    }

    private static void desinscribir (Map<Integer, String[]> inscripciones, Map<Integer, String[]> circuitos, String[] participante) {
        int key=Integer.parseInt(participante[1]);
        if(inscripciones.containsKey(key)) {
            System.out.println("Desinscribimos al participante nro " + participante[0] + ", " + participante[2] + participante[3]);

            //Resto el costo de esta inscripcion
            int nroDeCircuito=Integer.parseInt(inscripciones.get(key)[1]);
            int recaudacionActualCircuito=Integer.parseInt(circuitos.get(nroDeCircuito)[4]);
            int costoARestarPorDesinscripcion=Integer.parseInt(inscripciones.get(key)[3]);
            String[] circuitoTemp=circuitos.get(nroDeCircuito);
            circuitoTemp[4]= String.valueOf(recaudacionActualCircuito-costoARestarPorDesinscripcion);

            circuitos.put(nroDeCircuito, circuitoTemp);

            //Borro la inscripcion
            inscripciones.remove(key);
        }
    }

    private static void imprimirPorCategoria(Map<Integer, String[]> inscripciones, Map<Integer, String[]> circuitos,
                                             Map<Integer, String[]> participantes, int categoria) {
        System.out.println("Participantes del " + circuitos.get(categoria)[1]+": ");
        for(String[] inscripcion : inscripciones.values()) {
            if(Integer.parseInt(inscripcion[1])==categoria) {
                String[] participante=participantes.get(Integer.parseInt(inscripcion[2]));

                System.out.println("	Nro Inscripcion: " +  participante[0] + " | DNI: " + participante[1] +
                        " | Nombre: " + participante[2] + " | Apellido: " +participante[3] + " | etc");
            }
        }
    }

    //La suma por categoria dentro de un m�todo
    private static int sumarCategoria(Map<Integer, String[]> inscripciones, Map<Integer, String[]> circuitos,
                                      Map<Integer, String[]> participantes, int categoria) {
        System.out.println("Total recaudado por el " + circuitos.get(categoria)[1]+": ");

        int suma=0;

        for(String[] inscripcion : inscripciones.values()) {
            if(inscripcion[1].equals(categoria)) {
                suma+=Integer.valueOf(inscripcion[3]);
            }

        }
        return suma;
    }

    //La suma por categoria dentro de un m�todo
    private static void sumarRecaudadoPorCategoria( Map<Integer, String[]> circuitos) {
        for(String[] circuito : circuitos.values()) {
            int recaudacion=Integer.parseInt(circuito[4]);
            System.out.println("Recaudacion del " + circuito[1] + ": $" + recaudacion);
        }
    }


    //Suma del total
    private static int sumarTotalRecaudadoCarrera( Map<Integer, String[]> circuitos) {
        int total = 0;
        for(String[] circuito : circuitos.values()) {
            int recaudacion=Integer.parseInt(circuito[4]);
            total+=recaudacion;
        }
        return total;
    }
}
