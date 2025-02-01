package br.com.LeoChiarelli.foodstation.pagamentos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastrarPagamentoDTO(

        Long id,

        @NotNull
        @Positive
        BigDecimal valor,

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{16,19}")
        String numero,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate expiracao,

        @NotBlank
        @Pattern(regexp = "\\d{3}")
        String codigo,

        @NotNull
        Long idPedido,

        @NotNull
        Long idFormaDePagamento

) {
}
