package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Address(
        @NotBlank(message = "City is require!")
        String city,

        @NotBlank(message = "State is require!")
        String state,

        @NotBlank(message = "Public area is require!")
        String public_area,

        @NotBlank(message = "Neighbor is require!")
        String neighbor,

        @NotBlank(message = "Postal code is require!")
        String postalCode,

        String number,
        String complement
) {}
