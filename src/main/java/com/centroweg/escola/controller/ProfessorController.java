package com.centroweg.escola.controller;

import com.centroweg.escola.dto.ProfessorRequest;
import com.centroweg.escola.dto.ProfessorResponse;
import com.centroweg.escola.model.Professor;
import com.centroweg.escola.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ProfessorResponse criarProfessor (@RequestBody ProfessorRequest professor){

        try{
            return professorService.criarProfessor(professor);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<ProfessorResponse> listarProfessores (){
        try{
            return professorService.listarProfessor();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ProfessorResponse listarProfessorPorId(@PathVariable long id){
        try{
            return professorService.listarProfessorPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ProfessorResponse atualizarProfessor(@PathVariable long id, @RequestBody ProfessorRequest professorRequest){

        try{
            return professorService.atualizarProfessor(id, professorRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void removerProfessor(@PathVariable long id){
        try{
            professorService.removerProfessor(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
