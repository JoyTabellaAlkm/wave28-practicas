public class App {
    public static void main(String[] args) throws Exception {
        String[] ciudades = {"Londres", "Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de chile","Lisboa","Tokio"};
        int[][] temperaturas = {
            {-2,33},
            {-3,32},
            {-8,27},
            {4,37},
            {6,42},
            {5,43},
            {0,39},
            {-7,26},
            {-1,31},
            {-10,35}
        };
        int minima_t=100;
        int maxima_t=-100;
        String ciudad_minima_T="";
        String ciudad_maxima_T="";
        for(int i = 0; i<ciudades.length; i++){
            if(temperaturas[i][0]<minima_t){
                ciudad_minima_T = ciudades[i];
                minima_t = temperaturas[i][0];
            }
        
            if(temperaturas[i][1]>maxima_t){
                ciudad_maxima_T = ciudades[i];
                maxima_t=temperaturas[i][1];
            }
        }
        
        System.out.println("La ciudad con la temperatura minima es: " + ciudad_minima_T);
        System.out.println("La ciudad con la temperatura maxima es: "+ ciudad_maxima_T);
    }
}
