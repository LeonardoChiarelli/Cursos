package br.com.LeoChiarelli.service;

import com.google.gson.annotations.SerializedName;

public record TranslateData(@SerializedName("responseData") ResponseData responseData) {
}
