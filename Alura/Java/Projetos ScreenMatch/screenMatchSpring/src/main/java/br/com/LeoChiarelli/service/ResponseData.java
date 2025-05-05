package br.com.LeoChiarelli.service;

import com.google.gson.annotations.SerializedName;

public record ResponseData(@SerializedName("translatedText") String translatedText) {
}
