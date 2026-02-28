package com.centroweg.escola.mapper;

import com.centroweg.escola.dto.ProfessorRequest;
import com.centroweg.escola.dto.ProfessorResponse;
import com.centroweg.escola.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor paraEntidade(ProfessorRequest professorRequest){
        return new Professor(
                professorRequest.nome(),
                professorRequest.email(),
                professorRequest.disciplina()
        );
    }

    public ProfessorResponse paraDto(Professor professor){
        return new ProfessorResponse(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina()
        );
    }
}
