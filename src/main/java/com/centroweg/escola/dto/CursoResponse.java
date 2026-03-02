package com.centroweg.escola.dto;

import com.centroweg.escola.model.Professor;

import java.util.List;

public record CursoResponse(
        long id,
        String nome,
        String codigo,
        List<String> professores
) {
}
