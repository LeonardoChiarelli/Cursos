package adopet.api.general.strategy;

import adopet.api.domain.dto.SolicitacaoDeAdocaoDTO;

public interface IStrategy {
    void validar(SolicitacaoDeAdocaoDTO dto);
}
