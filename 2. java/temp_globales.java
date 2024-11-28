import org.xml.sax.SAXException;

public class temp_globales {
    public static void main(String[] args) {
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires", "Asunción","São Paulo",
                        "Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] ={{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int mayor = temperaturas[0][0];
        int menor = temperaturas[0][0];
        String paismayor = ciudades[0];
        String paismenor=ciudades[0];
        for (int i=0;i<=9;i++){
            for (int j=0;j<=1;j++){
            
            if (menor>temperaturas[i][j]) {
                menor=temperaturas[i][j];
                 paismenor = ciudades[i];
            }
            if (mayor<temperaturas[i][1]) {
                mayor=temperaturas[i][1];
                 paismayor = ciudades[i];
            }    

        }
        }
        System.out.println("La MAYOR temp. la tuvo: " + paismayor + ", con " + mayor+"°");
        System.out.println("La MENOR temp. la tuvo: " + paismenor + ", con " + menor+"°");

                    }
}
