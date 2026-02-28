package com.centroweg.escola.mapper;

import com.centroweg.escola.dto.AlunoRequest;
import com.centroweg.escola.dto.AlunoResponse;
import com.centroweg.escola.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public Aluno paraEntidade (AlunoRequest alunoRequest){

        return new Aluno(
                alunoRequest.nome(),
                alunoRequest.email(),
                alunoRequest.matricula(),
                alunoRequest.dataNascimento()
        );
    }

    public AlunoResponse paraDto(Aluno aluno) {

        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento()
        );
    }
}
