package adopet.api.domain.dto;

import adopet.api.domain.model.TipoPet;
import adopet.api.domain.model.TipoPorte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPetDTO(
        @NotBlank
        String nome,
        @NotNull
        Integer idade,
        @NotNull
        TipoPet tipo,
        @NotNull
        TipoPorte porte
) {
}
