package Moneda;
public class Principal {
    public static void main(String[] args) {
        try {
            // Instancia de la clase ConsultaDeMoneda
            ConsultaDeMoneda consulta = new ConsultaDeMoneda();
            
            // Realiza la consulta de las tasas para la moneda especificada (en este caso, USD)
            MonedasContact resultado = consulta.fetchCurrency("USD");

            // Instancia de la clase GeneradorDeArchivo
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            
            // Guarda el resultado JSON en un archivo
            generador.guardarJson(resultado);

            // Mensaje indicando que el proceso fue exitoso
            System.out.println("Proceso completado. Archivo generado con éxito.");
        } catch (Exception e) {
            // Manejando cualquier error ocurrido
            System.err.println("Error: " + e.getMessage());
        }
    }
}