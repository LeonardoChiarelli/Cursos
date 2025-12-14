package br.com.LeoChiarelli.dto;

import java.time.LocalDate;

public record EpisodeDTO(
        Integer season,
        String title,
        String episode) {
}
