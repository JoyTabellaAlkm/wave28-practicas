package printer;

public interface IPrintable {

    void print();

    static void printDocument(IPrintable document){
        document.print();
    }
}
