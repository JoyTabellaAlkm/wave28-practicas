package ej1;

public class EJ1 {

    public static int[] burbuja(int[] array) {
        int n = array.length;

        int i=0;
        boolean ok = false;
        while(i<n-1 && !ok) {
            ok = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] <= array[j + 1]) {
                    continue;
                }
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                ok = false;
            }
            i++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        burbuja(array);
        imprimirArreglo(array);
    }

    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }
}