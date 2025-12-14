package br.com.LeoChiarelli.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record SeasonsData(@SerializedName("Season") Integer season,
                          @SerializedName("Episodes")List<EpisodesData> episodes) {
}
