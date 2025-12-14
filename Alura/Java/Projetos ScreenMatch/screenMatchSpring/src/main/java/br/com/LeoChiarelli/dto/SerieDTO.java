package br.com.LeoChiarelli.dto;

import br.com.LeoChiarelli.models.Category;

public record SerieDTO(
        Long id,
        String title,
        Double rating,
        Integer totalSeasons,
        Category genre,
        String year,
        String actors,
        String writer,
        String poster,
        String synopsis
){}
