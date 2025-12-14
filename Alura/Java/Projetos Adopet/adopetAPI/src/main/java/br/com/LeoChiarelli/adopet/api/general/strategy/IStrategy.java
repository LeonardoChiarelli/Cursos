package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;

public interface IStrategy {
    void validar(SolicitarAdocaoDTO dto);
}
