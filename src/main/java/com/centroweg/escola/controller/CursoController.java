package com.centroweg.escola.controller;

import com.centroweg.escola.dto.CursoRequest;
import com.centroweg.escola.dto.CursoResponse;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.repository.CursoRepository;
import com.centroweg.escola.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;
    private final CursoRepository cursoRepository;

    @PostMapping
    public CursoResponse criarCurso (@RequestBody CursoRequest cursoRequest){
        try{
            return cursoService.criarCurso(cursoRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<CursoResponse> listarCursos (){

        try{
            return cursoService.listarCursos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public CursoResponse mostrarCursoPorId(@PathVariable long id) {
        try{
            return cursoService.listarCursoPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public CursoResponse atualizarCurso(@PathVariable long id, @RequestBody CursoRequest cursoRequest){
        try{
            return cursoService.atualizarCurso(id, cursoRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCurso(@PathVariable long id) {
        try{

            Curso curso = cursoRepository.findById(id).orElseThrow();

            cursoService.deletarCurso(id);

            return ResponseEntity.status(201).body("O curso " + curso.getNome() + " foi deletado com sucesso");
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
