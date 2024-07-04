import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                ************************************************************************
                Bienvenido/a al conversor de monedas de Ric.
                --------------------------------------------
                Seleccione una de las siguientes opciones:
                -------------------------------------------- 
                1) Dólar -> Peso Argentino
                2) Peso Argentino -> Dólar
                3) Dólar -> Real Brasileño
                4) Real Brasileño -> Dólar
                5) Peso Colombiano -> Dólar
                6) Dólar -> Peso Colombiano 
                7) Peso boliviano -> Dólar
                8) Dólar -> Peso boliviano
                9) Salir
                ************************************************************************
                """);

            int opcion = teclado.nextInt();

            if (opcion == 9) {
                continuar = false;
                System.out.println("Gracias por usar el conversor de monedas de Ric.");
            } else if (opcion < 1 || opcion > 9) {
                System.out.println("Opción no válida.");
            } else {
                System.out.print("Ingrese la cantidad que desea covertir: ");
                double cantidad = teclado.nextDouble();

                String fromCurrency = "";
                String toCurrency = "";

                switch (opcion) {
                    case 1:
                        fromCurrency = "USD";
                        toCurrency = "ARS";
                        break;
                    case 2:
                        fromCurrency = "ARS";
                        toCurrency = "USD";
                        break;
                    case 3:
                        fromCurrency = "USD";
                        toCurrency = "BRL";
                        break;
                    case 4:
                        fromCurrency = "BRL";
                        toCurrency = "USD";
                        break;
                    case 5:
                        fromCurrency = "COP";
                        toCurrency = "USD";
                        break;
                    case 6:
                        fromCurrency = "USD";
                        toCurrency = "COP";
                        break;
                    case 7:
                        fromCurrency = "BOB";
                        toCurrency = "USD";
                        break;
                    case 8:
                        fromCurrency = "USD";
                        toCurrency = "BOB";
                        break;
                }

                try {
                    double convertedAmount = ConsultaConversion.convertCurrency(fromCurrency, toCurrency, cantidad);
                    System.out.println(cantidad + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
                } catch (Exception e) {
                    System.out.println("Error al realizar la conversión: " + e.getMessage());
                }
            }
        }

        teclado.close();
    }
}
