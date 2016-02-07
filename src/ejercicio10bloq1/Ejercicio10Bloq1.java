package ejercicio10bloq1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ejercicio10Bloq1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        int numero;
        System.out.print("INTRODUCE EL NUMERO : ");
        numero=Integer.parseInt(teclado.readLine());
        int factorial=1;
        while ( numero!=0 )
        {
            factorial=factorial*numero;
            numero--;
        }
        System.out.println("El factorial es =: "+factorial);
    }
   
}
