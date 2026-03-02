package com.centroweg.escola.controller;

import com.centroweg.escola.dto.CursoResponse;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public CursoResponse criarCurso (Curso curso){
        try{
            return cursoService.criarCurso(curso);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
