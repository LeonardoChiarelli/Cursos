package br.com.LeoChiarelli.vehicles.models;

import com.google.gson.annotations.SerializedName;

public record Vehicle(
        @SerializedName("Valor") String price,
        @SerializedName("Marca") String brand,
        @SerializedName("Modelo") String model,
        @SerializedName("AnoModelo") String modelYear,
        @SerializedName("Combustivel") String fuel,
        @SerializedName("MesReferencia") String referenceMonth
) {
}
