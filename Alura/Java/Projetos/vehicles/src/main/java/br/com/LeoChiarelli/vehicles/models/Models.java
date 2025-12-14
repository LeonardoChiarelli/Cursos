package br.com.LeoChiarelli.vehicles.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record Models(@SerializedName("modelos") List<Data> models) {
}
