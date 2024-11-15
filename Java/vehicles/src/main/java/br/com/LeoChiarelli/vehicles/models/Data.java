package br.com.LeoChiarelli.vehicles.models;

import com.google.gson.annotations.SerializedName;

public record Data(@SerializedName("codigo") Integer code,
                   @SerializedName("nome") String name){
}
