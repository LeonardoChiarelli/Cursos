package br.com.LeoChiarelli.api.general.dto;

public record AddressDTO(
        String logadouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String numero,
        String complemento
) {
}
