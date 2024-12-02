public interface IImprimible {

     static void Imprimir(Documento doc){
        System.out.println("Imprimiendo " + doc.getTipo());
        System.out.println(doc.ToString());
    }
}
