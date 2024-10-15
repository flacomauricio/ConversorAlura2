import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcionBucle;

        do {
            mostrarMenu();
            opcionBucle = obtenerOpcion();
            if (opcionBucle != 7) {
                procesarOpcion(opcionBucle);
            }
        } while (opcionBucle != 7);

        System.out.println("Gracias.");
    }

    private static void mostrarMenu() {
        System.out.println("""
                ***************************************************
                Conversor de Monedas ALURA LATAM
                
                1) Dólar USA > Peso Argentino.
                2) Peso Argentino > Dólar USA.
                3) Dólar USA > Real Brasileño.
                4) Real Brasileño > Dólar USA.
                5) Dólar USA > Peso Colombiano.
                6) Peso Colombiano > Dólar USA.
                7) Salir.
                
                Seleccionar Opción de 1 a 7:
                ***************************************************
                """);
    }

    private static int obtenerOpcion() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine(); 
            System.out.println("Opción No disponible.");
            return 0;
        }
    }

    private static void procesarOpcion(int opcion) {
        try {
            System.out.println("Ingrese el monto:");
            double cantidad = sc.nextDouble();
            ApiRequest consulta = new ApiRequest(opcion, cantidad);
            consulta.llamadaRequest();

            System.out.printf("El valor de %s de %.2f es de %.2f%n", consulta.getValores(), cantidad, consulta.getResultado());
        } catch (InputMismatchException e) {
            System.out.println("Valor ingresado no correcto. Debe ingresar monto válido.");
            sc.nextLine(); 
        }
    }
}
