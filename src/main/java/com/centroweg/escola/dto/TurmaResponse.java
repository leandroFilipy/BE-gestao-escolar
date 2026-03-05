package com.centroweg.escola.dto;

import com.centroweg.escola.model.Aluno;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.model.Professor;

import java.util.List;

public record TurmaResponse(
        long id,
        String nome,
        Long curso,
        Long professor
) {
}
