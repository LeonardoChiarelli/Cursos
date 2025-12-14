package br.com.LeoChiarelli.vehicles.models;

import com.google.gson.annotations.SerializedName;

public record Data(@SerializedName("codigo") String code,
                   @SerializedName("nome") String name){
}
