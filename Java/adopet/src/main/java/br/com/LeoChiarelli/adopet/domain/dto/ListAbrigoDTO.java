package br.com.LeoChiarelli.adopet.domain.dto;

import br.com.LeoChiarelli.adopet.domain.models.Abrigo;

public record ListAbrigoDTO(
        Long id,
        String nome,
        String telefone,
        String email
) {
    public ListAbrigoDTO(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
    }
}
