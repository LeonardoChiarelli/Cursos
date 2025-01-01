package adopet.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroTutorDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email
) {
}
