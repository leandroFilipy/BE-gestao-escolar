package com.centroweg.escola.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CursoRequest(
        @NotBlank(message = "O valor não deve ser nulo ou vazio")
        @Size(min = 6, max = 200, message = "O nome deve estar entre 6 a 200 caracteres")
        String nome,
        String codigo,
        List<Long> professores
) {
}
