package adopet.api.domain.dto;

import adopet.api.domain.model.Adocao;
import adopet.api.domain.model.StatusAdocao;

public record AdocaoDTO(Long id, Long tutor, Long pet, String motivo, StatusAdocao status,
                        String justificativa) {
    public AdocaoDTO(Adocao adocao){
        this(adocao.getId(), adocao.getTutor().getId(), adocao.getPet().getId(), adocao.getMotivo(), adocao.getStatus(), adocao.getJustificativa());
    }
}
