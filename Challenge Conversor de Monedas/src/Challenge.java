import Moneda.ConsultaDeMoneda;
import Moneda.MonedasContact;

import java.util.Map;
import java.util.Scanner;

public class Challenge {

    public static void main(String[] args) {
        int opcion = 0;

        System.out.println("\n*****************************************");
        System.out.println("Welcome to the currency converter ");
        String menu = """
               *** Menu ***:
               *** Write the number of the currency you want to convert ***
                1- Dóllars ==> Dominican Pesos
                2- Dominican Pesos ==> Dóllars
                3- Euro ==> Dominican Pesos
                4- Dominican Pesos ==> Euro
                5- Euro ==> Dóllars
                6- Dóllars ==> Euro
                7- Exit
               """;

        Scanner keyboard = new Scanner(System.in);
        ConsultaDeMoneda consulta = new ConsultaDeMoneda();

        while (opcion != 7) {
            System.out.println(menu);
            System.out.println("Enter your choice: ");
            System.out.println("*****************************************");
            opcion = keyboard.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                MonedasContact monedasContact = consulta.fetchCurrency("USD"); // Código de base
                Map<String, Double> rates = monedasContact.conversionRates();

                double cantidad;
                System.out.print("Enter the amount: ");
                cantidad = keyboard.nextDouble();

                switch (opcion) {
                    case 1 -> {
                        // Dólares a Pesos Dominicanos
                        double tasa = rates.get("DOP");
                        System.out.printf("%.2f Dollars are %.2f Dominican Pesos%n", cantidad, cantidad * tasa);
                    }
                    case 2 -> {
                        // Pesos Dominicanos a Dólares
                        double tasa = rates.get("DOP");
                        System.out.printf("%.2f Dominican Pesos are %.2f Dollars%n ", cantidad, cantidad / tasa);
                    }
                    case 3 -> {
                        // Euro a Pesos Dominicanos
                        double tasa = rates.get("DOP") / rates.get("EUR");
                        System.out.printf("%.2f Euros are %.2f Dominican Pesos%n", cantidad, cantidad * tasa);
                    }
                    case 4 -> {
                        // Pesos Dominicanos a Euro
                        double tasa = rates.get("EUR") / rates.get("DOP");
                        System.out.printf("%.2f Dominican Pesos are %.2f Euros%n", cantidad, cantidad * tasa);
                    }
                    case 5 -> {
                        // Euro a Dólares
                        double tasa = rates.get("USD") / rates.get("EUR");
                        System.out.printf("%.2f Euros are %.2f Dollars%n", cantidad, cantidad * tasa);
                    }
                    case 6 -> {
                        // Dólares a Euro
                        double tasa = rates.get("EUR") / rates.get("USD");
                        System.out.printf("%.2f Dollars are %.2f Euros%n ", cantidad, cantidad * tasa);
                    }
                }
            } else if (opcion == 7) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}