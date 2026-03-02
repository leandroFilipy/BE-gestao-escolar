package com.centroweg.escola.service;

import com.centroweg.escola.dto.CursoResponse;
import com.centroweg.escola.mapper.CursosMapper;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursosMapper cursosMapper;


    public CursoResponse criarCurso(Curso curso)throws SQLException{
        Curso curso1 = cursoRepository.save(curso);
        CursoResponse cursoResponse = cursosMapper.paraDTO(curso);

        return cursoResponse;
    }

}
