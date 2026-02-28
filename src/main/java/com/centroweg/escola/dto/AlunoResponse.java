package com.centroweg.escola.dto;

import java.util.Date;

public record AlunoResponse(
        long id,
        String nome,
        String email,
        String matricula,
        Date dataNascimento
) {
}
