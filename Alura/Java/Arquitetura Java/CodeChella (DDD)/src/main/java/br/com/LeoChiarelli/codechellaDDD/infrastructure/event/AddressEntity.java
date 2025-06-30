package br.com.LeoChiarelli.codechellaDDD.infrastructure.event;

import br.com.LeoChiarelli.codechellaDDD.application.event.AddressDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEntity {

    private String postalCode;
    private Integer number;
    private String complement;

    public AddressEntity() {}

    public AddressEntity(AddressDTO dto) {
        this.postalCode = dto.postalCode();
        this.number = dto.number();
        this.complement = dto.complement();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
