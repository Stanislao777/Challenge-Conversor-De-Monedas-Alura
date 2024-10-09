import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        /*//Prueba para obtenciÓn de datos de la API

        ConsultarTasaDeMoneda consulta = new ConsultarTasaDeMoneda();
        Moneda moneda = consulta.buscaMoneda("USD", "ARS");
        System.out.println(moneda);*/

        Scanner lectura = new Scanner(System.in);
        ConsultarTasaDeMoneda consulta = new ConsultarTasaDeMoneda();

        while (true) {
            System.out.println("***************************************************\n" +
                    "Sea bienvendido/a al Conversor de monedas ^_^ \n" +
                    "Elija una opción: \n\n" +
                    "1) Dólar ==> Peso argentino\n" +
                    "2) Peso argentino ==> Dólar\n" +
                    "3) Dólar ==> Real brasilero\n" +
                    "4) Real brasilero ==> Dólar\n" +
                    "5) Dólar ==> Peso colombiano\n" +
                    "6) Peso colombiando ==> Dólar\n" +
                    "7) Salir\n" +
                    "Elija una opción válida: ");
            System.out.println("***************************************************");

            int opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el Conversor de monedas!");
                break;
            }

            if (opcion < 1 || opcion >6 ) {
                System.out.println("Opción invalida!, intenta nuevamente =]");
                continue;
            }

            Moneda moneda = consulta.buscaMoneda("USD");
            if (moneda != null) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valor = lectura.nextDouble();
                double resultado = 0;

                switch (opcion) {
                    case 1:
                        resultado = valor * moneda.conversion_rates().get("ARS");
                        System.out.println("El valor " + valor + " [USD] corresponde al valor final de ===> " + String.format("%.2f", resultado) + " [ARS]\n");
                        break;
                    case 2:
                        resultado = valor / moneda.conversion_rates().get("ARS");
                        System.out.println("El valor " + valor + " [ARS] corresponde al valor final de ===> " + String.format("%.2f", resultado) + " [USD]\n");
                        break;
                    case 3:
                        resultado = valor * moneda.conversion_rates().get("BRL");
                        System.out.println("El valor " + valor + " [USD] corresponde al valor final de ===> " + String.format("%.2f", resultado) + " [BRL]\n");
                        break;
                    case 4:
                        resultado = valor / moneda.conversion_rates().get("BRL");
                        System.out.println("El valor " + valor + " [BRL] corresponde al valor final de ===> " + String.format("%.2f", resultado) + " [USD]\n");
                        break;
                    case 5:
                        resultado = valor * moneda.conversion_rates().get("COP");
                        System.out.println("El valor " + valor + " [USD] corresponde al valor final de ===> " + String.format("%.2f", resultado) + " [COP]\n");
                        break;
                    case 6:
                        resultado = valor / moneda.conversion_rates().get("COP");
                        System.out.println("El valor " + valor + " [COP] corresponde al valor final de ===> " + String.format("%.2f", resultado) + " [USD]\n");
                        break;
                    default:
                        System.out.println("Opción no valida, intente nuevamente.");
                }
            } else {
                System.out.println("Error al consultar la tasa de cambio.");
            }
        }

        lectura.close();
    }
}
