import clasesAbstractas.ejGrupal1.ej1.clientes.Basic;
import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.*;
import clasesAbstractas.ejGrupal1.ej2.Curriculum;
import clasesAbstractas.ejGrupal1.ej2.IImprimible;
import clasesAbstractas.ejGrupal1.ej2.Informe;
import clasesAbstractas.ejGrupal1.ej2.LibroPDF;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Ejercicio 1
        // Creamos transacciones
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        Deposito deposito = new Deposito();
        PagoServicio pagoServicio  = new PagoServicio();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        Transferencia transferencia = new Transferencia();

        // Creamos clientes
        Basic basic = new Basic(consultaSaldo,pagoServicio,retiroEfectivo);

        basic.getConsultaSaldo().transaccionOk();

        // Ejercicio 2

        // Creamos documentos
        Curriculum curriculum = new Curriculum("Guillermo", "Kalniker", 25, "Hola soy Guille...");
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Trabajo en equipo");
        habilidades.add("Programar");
        curriculum.setHabilidades(habilidades);

        Informe informe = new Informe("Este es el texto del doc", 4, "Guillermo", "Mariela");
        LibroPDF libroPDF = new LibroPDF(2,"Guille", "Titulo Falso", "Ciencia ficcion");

        // Imprimimos documentos
        IImprimible.imprimir(curriculum);
        IImprimible.imprimir(informe);
        IImprimible.imprimir(libroPDF);
    }
}