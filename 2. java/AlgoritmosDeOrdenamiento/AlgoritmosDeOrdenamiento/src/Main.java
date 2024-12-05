
class Ejercicio1 {

    public Ejercicio1() {}
    public static int[] burbuja(int[] array) {
        int n = array.length;
        boolean intercambio;

        for (int paso = 0; paso < n - 1; paso++) {
            intercambio = false;
            for (int i = 0; i < n - paso - 1; i++) {
                System.out.println("Paso: " + paso + ", i: " + i);

                if (array[i] > array[i + 1]) {
                    System.out.println("array[i]: " + array[i] + ", array[i + 1]: " + array[i + 1]);

                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    System.out.println("Cambio: " + array[i] + ", " + array[i + 1]);

                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] burbuja = {5, 2, 9, 1, 5, 6};
        Ejercicio1 ejercicio1 = new Ejercicio1();
        System.out.println(ejercicio1);
        int[] arregloOrdenado = ejercicio1.burbuja(burbuja);
        System.out.println();
        Ejercicio1.imprimirArreglo(arregloOrdenado);
    }

    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }
}