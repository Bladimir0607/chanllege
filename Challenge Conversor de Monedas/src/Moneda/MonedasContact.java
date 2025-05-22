package Moneda;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public record MonedasContact(
        @SerializedName("conversion_rates") 
        Map<String, Double> conversionRates
) {}