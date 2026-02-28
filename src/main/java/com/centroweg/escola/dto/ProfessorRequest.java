package com.centroweg.escola.dto;

import jakarta.persistence.Column;

public record ProfessorRequest(
         String nome,
         String email,
         String disciplina
) {
}
