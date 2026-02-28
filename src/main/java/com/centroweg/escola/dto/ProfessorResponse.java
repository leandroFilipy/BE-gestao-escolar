package com.centroweg.escola.dto;

import jakarta.persistence.Column;

public record ProfessorResponse(
        long id,
        String nome,
        String email,
        String disciplina
) {
}
