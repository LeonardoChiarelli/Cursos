package br.com.LeoChiarelli.models;

import com.google.gson.annotations.SerializedName;

public record EpisodesData(@SerializedName("Title") String title,
                           @SerializedName("Episode")String episode,
                           @SerializedName("imdbRating")String rating,
                           @SerializedName("Released")String dataLancamento) {
}
