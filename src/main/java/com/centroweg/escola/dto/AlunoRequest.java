package com.centroweg.escola.dto;

import java.util.Date;

public record AlunoRequest(
        String nome,
        String email,
        String matricula,
        Date dataNascimento
) {
}
