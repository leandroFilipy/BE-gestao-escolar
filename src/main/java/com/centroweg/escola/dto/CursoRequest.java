package com.centroweg.escola.dto;

import java.util.List;

public record CursoRequest(
        String nome,
        String codigo,
        List<Long> professores
) {
}
