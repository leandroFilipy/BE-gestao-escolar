package com.centroweg.escola.dto;

import jakarta.validation.constraints.*;
import lombok.Setter;

import java.util.Date;

public record AlunoRequest(
        @NotBlank(message = "O valor não deve ser nulo ou vazio")
        @Size(min=6, max = 200, message = "O nome deve ter entre 6 a 200 caracteres")
        String nome,
        @Email(message = "Email não é compátivel, se vira ai e arruma isso")
        String email,
        String matricula,
        @PastOrPresent(message = "A data inserida não é compatível")
        Date dataNascimento

) {
}
