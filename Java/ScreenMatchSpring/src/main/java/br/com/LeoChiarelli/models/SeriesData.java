package br.com.LeoChiarelli.models;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

public record SeriesData(@SerializedName("Title") String title,
                         @SerializedName("imdbRating")String rating,
                         String totalSeasons,
                         @SerializedName("Genre")String genre,
                         @SerializedName("Year")String year,
                         @SerializedName("Actors")String actors,
                         @SerializedName("Writer")String writer,
                         @SerializedName("Poster")String poster,
                         @SerializedName("Plot")String synopsis){
}
