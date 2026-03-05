package com.centroweg.escola.dto;

import com.centroweg.escola.model.Curso;
import com.centroweg.escola.model.Professor;

public record TurmaRequest(
        String nome,
        Long cursoId,
        Long professorId
) {
}
