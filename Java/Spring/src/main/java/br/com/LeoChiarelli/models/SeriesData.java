package br.com.LeoChiarelli.models;

import com.google.gson.annotations.SerializedName;

public record SeriesData(@SerializedName("Title") String title,
                         @SerializedName("imdbRating")Float rating,
                         Integer totalSeasons,
                         @SerializedName("Genre")String genre,
                         @SerializedName("Year")String year,
                         @SerializedName("Writer")String writer) {
}
