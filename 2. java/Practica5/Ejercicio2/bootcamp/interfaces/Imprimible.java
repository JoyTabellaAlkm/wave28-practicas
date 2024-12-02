package bootcamp.interfaces;

import bootcamp.classes.Document;

public interface Imprimible {

    static void printDocument(Document document){
        document.print();
    };
}
