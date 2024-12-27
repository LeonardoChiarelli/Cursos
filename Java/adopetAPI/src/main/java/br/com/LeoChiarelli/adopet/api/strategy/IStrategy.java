package br.com.LeoChiarelli.adopet.api.strategy;

import br.com.LeoChiarelli.adopet.api.dto.SolicitarAdocaoDTO;

public interface IStrategy {
    void validar(SolicitarAdocaoDTO dto);
}
