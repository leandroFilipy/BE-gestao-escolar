package com.centroweg.escola.controller;

import com.centroweg.escola.dto.CursoRequest;
import com.centroweg.escola.dto.CursoResponse;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public CursoResponse criarCurso (@RequestBody CursoRequest cursoRequest){
        try{
            return cursoService.criarCurso(cursoRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
