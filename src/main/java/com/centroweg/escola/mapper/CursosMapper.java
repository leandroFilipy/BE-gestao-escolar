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


        curso.setNome(cursoRequest.nome());
        curso.setCodigo(cursoRequest.codigo());
        return curso;
    }

    public CursoResponse paraDTO (Curso curso, List<String> nomesDeProfessores){

        return new CursoResponse(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo(),
                nomesDeProfessores != null ? nomesDeProfessores : new ArrayList<>()
        );
    }
}
