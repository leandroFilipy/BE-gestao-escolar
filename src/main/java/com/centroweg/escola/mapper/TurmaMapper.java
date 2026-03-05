package com.centroweg.escola.mapper;

import com.centroweg.escola.dto.AlunoRequest;
import com.centroweg.escola.dto.TurmaRequest;
import com.centroweg.escola.dto.TurmaResponse;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.model.Professor;
import com.centroweg.escola.model.Turma;
import com.centroweg.escola.repository.CursoRepository;
import com.centroweg.escola.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TurmaMapper {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    public Turma paraEntidade(TurmaRequest turmaRequest){

        Curso curso = cursoRepository.findById(turmaRequest.cursoId()).orElseThrow(() -> new RuntimeException("não deu"));
        Professor professor = professorRepository.findById(turmaRequest.professorId()).orElseThrow(() ->new RuntimeException("não deu"));

        Turma turma = new Turma();
        turma.setNome(turmaRequest.nome());
        turma.setCurso(curso);
        turma.setProfessor(professor);

        return turma;
    }

    public TurmaResponse paraDTO(Turma turma){



        return new TurmaResponse(
                turma.getId(),
                turma.getNome(),
                turma.getCurso().getId(),
                turma.getProfessor().getId()
        );
    }
}
