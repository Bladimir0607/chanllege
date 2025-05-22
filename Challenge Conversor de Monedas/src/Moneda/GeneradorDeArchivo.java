package Moneda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {

    public void guardarJson(MonedasContact monedasContact) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = "conversion_rates.json";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(gson.toJson(monedasContact));
            System.out.println("File saved successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("Error while trying to save the file: " + e.getMessage());
        }
    }
}