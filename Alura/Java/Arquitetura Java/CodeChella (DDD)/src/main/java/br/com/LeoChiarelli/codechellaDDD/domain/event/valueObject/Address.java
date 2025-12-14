package br.com.LeoChiarelli.codechellaDDD.domain.event.valueObject;

import br.com.LeoChiarelli.codechellaDDD.application.ValidationException;

public class Address {

    private final String postalCode;
    private final Integer number;
    private final String complement;

    private Address(String postalCode, Integer number, String complement) {
        if (postalCode == null || postalCode.trim().isEmpty()) { throw new ValidationException("Address postal code must not be null."); }
        if (number == null) { throw new ValidationException("Address number must not be null."); }

        this.postalCode = postalCode;
        this.number = number;
        this.complement = complement;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Integer getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", number=" + number +
                ", complement='" + complement + '\'' +
                '}';
    }

    public static class AddressBuilder {

        private String postalCode;
        private Integer number;
        private String complement;

        public AddressBuilder() {}

        public AddressBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder withNumber(Integer number) {
            this.number = number;
            return this;
        }

        public AddressBuilder withComplement(String complement) {
            this.complement = complement;
            return this;
        }

        public Address build() {
            if (postalCode == null || postalCode.trim().isEmpty()) { throw new ValidationException("Address postal code must not be null."); }
            if (number == null) { throw new ValidationException("Address number must not be null."); }

            return new Address(this.postalCode, this.number, this.complement);
        }
    }
}
