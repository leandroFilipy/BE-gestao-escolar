package com.centroweg.escola.mapper;

import com.centroweg.escola.dto.CursoRequest;
import com.centroweg.escola.dto.CursoResponse;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.model.Professor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CursosMapper {

    public Curso paraEntidade (CursoRequest cursoRequest){

        Curso curso = new Curso();

        List<Professor> professores = new ArrayList<>();

        for(Long id : cursoRequest.professores()){
            Professor professor2 = new Professor();
            professor2.setId(id);
            professores.add(professor2);
        }

        curso.setNome(cursoRequest.nome());
        curso.setCodigo(curso.getNome());

        return curso;
    }

    public CursoResponse paraDTO (Curso curso){

        List<String> nomesProfessores = new ArrayList<>();
        for (Professor professor : curso.getProfessores()){
            nomesProfessores.add(professor.getNome());

        }
        return new CursoResponse(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo(),
                nomesProfessores
        );
    }
}
